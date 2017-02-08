/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sgiir.propiedades.propiedades;

/**
 *
 * @author Alfredo Mariño
 */
public class manejadorDB {
    
    private propiedades ConfiguracionDB = new propiedades(3);
    public String Driver = ConfiguracionDB.getProperty("driver");
    public String Url = ConfiguracionDB.getProperty("url");
    public String User = ConfiguracionDB.getProperty("user");
    public String Password = ConfiguracionDB.getProperty("pass");
    
    
    public static Connection con;
   
    
    
    private manejadorDB() {
                con = null;
        try {
            Class.forName(Driver);
            con = (Connection) DriverManager.getConnection(Url, User, Password);
            if(con != null){
                System.out.println("Conexion establecida");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(manejadorDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(manejadorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static manejadorDB getInstance() {
        return manejadorDBHolder.INSTANCE;
    }
    
    private static class manejadorDBHolder {

        private static final manejadorDB INSTANCE = new manejadorDB();
    }
}
