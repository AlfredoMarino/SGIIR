/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static sgiir.manejadorDB.Conexion;

/**
 *
 * @author Alfredo Mariño
 */
public class supervisor {

    private ResultSet rs, rsBitacora, rsInvolucrado;

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
                    + "WHERE t.FechaFinalizacionTarea IS NULL";
            
            Statement st = Conexion.prepareCall(Query);

            rs = st.executeQuery(Query);

            while(rs.next()){
                fechaRecepcion = rs.getDate("FechaRecepcionTarea");
                diasSeguimiento = rs.getInt("DiasSeguimiento");
                maximoSeguimiento = rs.getInt("MaximoSeguimiento");
                codigoTarea = rs.getInt("CodigoTarea");
                codigoNaturaleza = rs.getInt("CodigoNaturaleza");
                
                codigoBitacora = getCodigoBitacora(fechaRecepcion, diasSeguimiento);
                
                System.out.println("si existe una bitacora: " + String.valueOf(codigoBitacora) + " para la tarea " + rs.getInt("CodigoTarea") + " con un maximo de " + maximoSeguimiento);
                
                //SI EL NUMERO DE SEGUIMIENTOS TODAVIA NO HA SOBREPASADO AL MAXIMO ENVIA
                if((codigoBitacora <= maximoSeguimiento) && (codigoBitacora > 0)){
                    
                    //SI NO CONSIGUE UNA BITACORA ENVIA MENSAJE
                    if(!fetchBitacora(codigoNaturaleza, codigoTarea, codigoBitacora)){
                        System.out.println("se envia la bitacora " + String.valueOf(codigoBitacora) + " para la tarea " + rs.getInt("CodigoTarea") + " con un maximo de " + maximoSeguimiento);
                        fetchInvolucrados(codigoNaturaleza, codigoTarea);
                        
                    }
                    
                }
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    private void fetchInvolucrados(int naturaleza, int tarea){
        int involucrado;
        
        try {
            //BUSCA LOS ULTIMOS INVOLUCRADOS EN LA TAREA
            String Query = "SELECT CodigoInvolucrado FROM Involucrado WHERE CodigoNaturaleza = ? and CodigoTarea = ?  ORDER BY CodigoInvolucrado desc LIMIT 1";
            
            PreparedStatement ps = Conexion.prepareCall(Query);
            ps.setInt(1, naturaleza);
            ps.setInt(2, tarea);
            //ps.setInt(3, involucrado);
            
            rsInvolucrado = ps.executeQuery();
            if(rsInvolucrado.absolute(1)){
                
                involucrado = rsInvolucrado.getInt("CodigoInvolucrado");
                 
                Query = "SELECT i.CodigoNaturaleza, i.CodigoTarea, i.CodigoInvolucrado, "
                        + "p.NombrePersona, p.EmailPersona, p.RecordatorioPersona, "
                        + "b.ClienteInstitucion, c.CodigoCargo, b.CodigoInstitucion "
                        + "FROM involucrado i INNER JOIN persona p "
                        + "ON i.CodigoPersona = p.CodigoPersona INNER JOIN cargo c "
                        + "ON p.CodigoCargo = c.CodigoCargo INNER JOIN institucion b "
                        + "ON c.CodigoInstitucion = b.CodigoInstitucion "
                        + "WHERE b.ClienteInstitucion = 0 and p.RecordatorioPersona = 1 and "
                        + "i.CodigoNaturaleza = ? and i.CodigoTarea = ? and i.CodigoInvolucrado = ?";

                ps = Conexion.prepareCall(Query);
                ps.setInt(1, naturaleza);
                ps.setInt(2, tarea);
                ps.setInt(3, involucrado);

                rsInvolucrado = ps.executeQuery();
                while(rsInvolucrado.next()){
                    System.out.println("Naturaleza: " + naturaleza + " Tarea: " + tarea + " involucrado: " + involucrado + " se envia a" + rsInvolucrado.getString("NombrePersona") + " a su email: " + rsInvolucrado.getString("EmailPersona"));
                    
                    
                }
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(supervisor.class.getName()).log(Level.SEVERE, null, ex);
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

}
