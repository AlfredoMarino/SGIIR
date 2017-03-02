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

    private ResultSet rs;
    
    
    public boolean seguimiento(){
        Statement statementDB;
        Date fechaRecepcion;
        Date fechaFinalizacion;
        int diasSeguimiento;
        
        try {

            String Query = "SELECT t.CodigoNaturaleza, t.CodigoTarea, t.CodigoSeguimiento, s.DiasSeguimiento, s.HorasSeguimiento, s.MaximoSeguimiento, t.FechaRecepcionTarea, t.HoraRecepcionTarea, t.FechaFinalizacionTarea, t.HoraFinalizacionTarea FROM seguimiento s INNER JOIN tarea t ON s.CodigoSeguimiento = t.CodigoSeguimiento WHERE t.FechaFinalizacionTarea IS NULL";
            
            Statement st = Conexion.prepareCall(Query);

                rs = st.executeQuery(Query);

            while(rs.next()){
                fechaRecepcion = rs.getDate("FechaRecepcionTarea");
                diasSeguimiento = rs.getInt("DiasSeguimiento");
                
                
                System.out.println("si existe una bitacora: " + String.valueOf(getCodigoBitacora(fechaRecepcion, diasSeguimiento)) + "para la tarea " + rs.getInt("CodigoTarea"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(supervisor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
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
