package sgiir;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import static sgiir.manejadorDB.Conexion;

/**
 *
 * @author Alfredo Mariño
 */

//La clase que tiene la tarea debe de implementar de la clase Job de Quartz
//ya que el programador de la tarea va a buscar una clase que implemente de ella
//y buscara el metodo execute para ejecutar la tarea
public class supervisor implements Job {
    private Calendar calendario = new GregorianCalendar();
    private ResultSet rs, rsBitacora, rsInvolucrado;
    private int hora = calendario.get(Calendar.HOUR_OF_DAY);
    public String[] destinatariosEmail;
           
    //Metodo que se ejecutara cada cierto tiempo que lo programemos despues
    public void execute(JobExecutionContext jec) throws JobExecutionException {
        //Aca pueden poner la tarea o el job que desean automatizar
        //Por ejemplo enviar correo, revisar ciertos datos, etc
        SimpleDateFormat formato = new SimpleDateFormat("hh:mm:ss");
        System.out.println( "Tarea invocada a la hora: " + formato.format(new Date()));
        
        

        if(seguimiento()){
            System.out.println( "Tarea finalizo con exito a las: " + formato.format(new Date()));
        }else{
            System.out.println( "Tarea finalizo con problemas a las: " + formato.format(new Date()));
        }
    }

    public boolean seguimiento(){
        Date fechaRecepcion, fechaFinalizacion;
        int diasSeguimiento, codigoNaturaleza, codigoTarea, maximoSeguimiento, codigoBitacora;
        
        try {

            String Query = "SELECT t.CodigoNaturaleza, t.CodigoTarea, t.CodigoSeguimiento, "
                    + "s.DiasSeguimiento, s.HorasSeguimiento, s.MaximoSeguimiento, "
                    + "t.FechaRecepcionTarea, t.HoraRecepcionTarea, t.FechaFinalizacionTarea, "
                    + "t.HoraFinalizacionTarea "
                    + "FROM seguimiento s INNER JOIN tarea t "
                    + "ON s.CodigoSeguimiento = t.CodigoSeguimiento "
                    + "WHERE t.FechaFinalizacionTarea IS NULL and s.HorasSeguimiento = " + 9; //cambiar ese nueve por la variable hora
            
//            String Query = "SELECT t.CodigoNaturaleza, t.CodigoTarea, t.CodigoSeguimiento, "
//                    + "s.DiasSeguimiento, s.HorasSeguimiento, s.MaximoSeguimiento, "
//                    + "t.FechaRecepcionTarea, t.HoraRecepcionTarea, t.FechaFinalizacionTarea, "
//                    + "t.HoraFinalizacionTarea "
//                    + "FROM seguimiento s INNER JOIN tarea t "
//                    + "ON s.CodigoSeguimiento = t.CodigoSeguimiento "
//                    + "WHERE t.FechaFinalizacionTarea IS NULL";
            
            Statement st = Conexion.prepareCall(Query);

            rs = st.executeQuery(Query);

            while(rs.next()){
                fechaRecepcion = rs.getDate("FechaRecepcionTarea");
                diasSeguimiento = rs.getInt("DiasSeguimiento");
                maximoSeguimiento = rs.getInt("MaximoSeguimiento");
                codigoTarea = rs.getInt("CodigoTarea");
                codigoNaturaleza = rs.getInt("CodigoNaturaleza");
                
                codigoBitacora = getCodigoBitacora(fechaRecepcion, diasSeguimiento);
                
                //System.out.println("si existe una bitacora: " + String.valueOf(codigoBitacora) + " para la tarea " + rs.getInt("CodigoTarea") + " con un maximo de " + maximoSeguimiento);
                
                //SI EL NUMERO DE SEGUIMIENTOS TODAVIA NO HA SOBREPASADO AL MAXIMO ENVIA
                if((codigoBitacora <= maximoSeguimiento) && (codigoBitacora > 0)){
                    
                    //SI NO CONSIGUE UNA BITACORA ENVIA MENSAJE
                    if(!fetchBitacora(codigoNaturaleza, codigoTarea, codigoBitacora)){
                        //System.out.println("se envia la bitacora " + String.valueOf(codigoBitacora) + " para la tarea " + rs.getInt("CodigoTarea") + " con un maximo de " + maximoSeguimiento);
                        fetchInvolucrados(codigoNaturaleza, codigoTarea);
                        
                        if(destinatariosEmail != null){
                            enviaEmailRecordatorio(codigoNaturaleza, codigoTarea);
                        }
                    }
                    
                    //ENVIA INFORMES DE ALERTA AL DIRECTOR
                    //if(codigoBitacora == maximoSeguimiento){
                        enviaEmailInforme(codigoNaturaleza, codigoTarea);
                    //}
                    
                }
            }
            
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(supervisor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //BUSCA ULTIMOS INVOLUCRADOS DE USH EN LA TAREA
    private void fetchInvolucrados(int naturaleza, int tarea){
        int involucrado;
                
        try {
            //BUSCA LOS ULTIMOS INVOLUCRADOS EN LA TAREA
            String Query = "SELECT CodigoInvolucrado FROM Involucrado WHERE CodigoNaturaleza = ? and CodigoTarea = ?  ORDER BY CodigoInvolucrado desc LIMIT 1";
            
            PreparedStatement ps = Conexion.prepareCall(Query);
            ps.setInt(1, naturaleza);
            ps.setInt(2, tarea);
           
            rsInvolucrado = ps.executeQuery();
            if(rsInvolucrado.absolute(1)){
                
                involucrado = rsInvolucrado.getInt("CodigoInvolucrado");
                 
                Query = "SELECT i.CodigoNaturaleza, i.CodigoTarea, i.CodigoInvolucrado, "
                        + "p.NombrePersona, p.EmailPersona, p.RecordatorioPersona, "
                        + "b.ClienteInstitucion, c.CodigoCargo, b.CodigoInstitucion "
                        + "FROM involucrado i "
                        + "INNER JOIN persona p ON i.CodigoPersona = p.CodigoPersona "
                        + "INNER JOIN cargo c ON p.CodigoCargo = c.CodigoCargo "
                        + "INNER JOIN institucion b ON c.CodigoInstitucion = b.CodigoInstitucion "
                        + "WHERE b.ClienteInstitucion = 0 and p.RecordatorioPersona = 1 and "
                        + "i.CodigoNaturaleza = ? and i.CodigoTarea = ? and i.CodigoInvolucrado = ?";

                ps = Conexion.prepareCall(Query);
                ps.setInt(1, naturaleza);
                ps.setInt(2, tarea);
                ps.setInt(3, involucrado);

                rsInvolucrado = ps.executeQuery();
                String[] DestinoEmail = new String[(resultSetSize(rsInvolucrado))];
                
                //POSICIONA RESULTSET ANTES DEL PRIMERO PARA QUE CUANDO HAGA .NEXT SE PARE EN EL PRIMERO
                rsInvolucrado.beforeFirst();
                
                int i = 0;
                while(rsInvolucrado.next()){
                    System.out.println("Naturaleza: " + naturaleza + " Tarea: " 
                            + tarea + " involucrado: " + involucrado 
                            + " se envia a" + rsInvolucrado.getString("NombrePersona") 
                            + " a su email: " + rsInvolucrado.getString("EmailPersona"));
                    DestinoEmail[i] = rsInvolucrado.getString("EmailPersona");
                    
                    i++;
                }
                
                
                if(i > 0){
                    this.destinatariosEmail = DestinoEmail;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void enviaEmailRecordatorio(int naturaleza, int tarea){
        String Asunto = "Tarea pendiente";
        String Texto = "No se actualizado el estado de la tarea " + tarea + " de naturaleza " + naturaleza;
                    
        email despachadorEmail  = new email();          
        if(despachadorEmail.sendEmail(Asunto, destinatariosEmail, Texto)){
            System.out.println("El envio de emails se ha realizado con exito");
        }else{
            System.out.println("El envio de emails ha fallado");
        }
                    
    }
    
    public void enviaEmailInforme(int naturaleza, int tarea) throws SQLException{
        String Asunto = "Tarea no cumple con los tiempos";
        String Texto = "La tarea" + tarea + " de naturaleza " + naturaleza;
        
        String Query = "SELECT p.EmailPersona FROM persona p INNER JOIN cargo c "
                + "ON p.CodigoCargo = c.CodigoCargo WHERE c.InformeCargo = 1";
            
        Statement st = Conexion.prepareCall(Query);

        ResultSet rsInforme = st.executeQuery(Query);
        
        //EL ARREGLO TOMA EL TAMAÑO DEL RESULTSET        
        String[] DestinoEmail = new String[(resultSetSize(rsInforme))];
        
        //POSICIONA RESULTSET ANTES DEL PRIMERO PARA QUE CUANDO HAGA .NEXT SE PARE EN EL PRIMERO
        rsInforme.beforeFirst();
        
        int i = 0;
        while(rsInforme.next()){
            DestinoEmail[i] = rsInforme.getString("EmailPersona");

                i++;
        }
        if(i>0){
            email despachadorEmail  = new email();          
            if(despachadorEmail.sendEmail(Asunto, DestinoEmail, Texto)){
                System.out.println("El envio de emails se ha realizado con exito");
            }else{
                System.out.println("El envio de emails ha fallado");
            }
        }        
        
    }
    
    //BUSCA LA BITACORA
    private boolean fetchBitacora(int naturaleza, int tarea, int correlativo){
        try {

            String Query = "SELECT * FROM Bitacora WHERE CodigoNaturaleza = ? and CodigoTarea = ? and CorrelativoBitacora = ?";

            PreparedStatement ps = Conexion.prepareCall(Query);
            ps.setInt(1, naturaleza);
            ps.setInt(2, tarea);
            ps.setInt(3, correlativo);
            
            rsBitacora = ps.executeQuery();
            if(rsBitacora.absolute(1)){
                return true;
            }else{
                return false;
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(supervisor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //Devuelve el codigo de bitacora vigente para esa fecha
    private int getCodigoBitacora(Date fechaRecepcion, int diasSeguimiento){
         
        //calcula los dias que han pasado entre la fecha de recepcion y la fecha actual
        int diferencia = (int) diferenciaDias(fechaRecepcion, new Date());
        
        //se divide la diferencia entre los dias de seguimiento para saber cuantas bitacoras deben haber 
        return (diferencia / diasSeguimiento);
    }
    
    //devuelve la diferencia en dias entre dos fechas
    public long diferenciaDias(Date fecha1, Date fecha2){
        GregorianCalendar date = new GregorianCalendar();
        GregorianCalendar date2 = new GregorianCalendar();
        
        date.setTime(fecha1);
        date2.setTime(fecha2);
        
        long difms=date2.getTimeInMillis() - date.getTimeInMillis();
        long difd=difms / (1000 * 60 * 60 * 24);
        return difd;
    }

    //Retorna el numero de registros en el resultSet
    private int resultSetSize(ResultSet rs) throws SQLException{
        int i = 0;
        
        while(rs.next()){
            i++;
        }
        return i;
    }
}
