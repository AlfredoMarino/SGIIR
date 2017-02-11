/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import com.mysql.jdbc.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sgiir.propiedades.propiedades;

/**
 *
 * @author Alfredo Mariño
 */
public class manejadorDB {
    
    private propiedades ConfiguracionDB = new propiedades(3);
    private propiedades msgFile = new propiedades();
    
    public String Driver = ConfiguracionDB.getProperty("driver");
    public String Url = ConfiguracionDB.getProperty("url");
    public String User = ConfiguracionDB.getProperty("user");
    public String Password = ConfiguracionDB.getProperty("pass");
    
    
    public static Connection Conexion;
    public ResultSet ResultSetDB;
    public Statement StatementDB;
    
    public String status = "";
    
    
    private manejadorDB() {
        
        //ESTABLECE CONEXION CON LA BASE DE DATOS
        Conexion = null;
        try {
            Class.forName(Driver);
            Conexion = (Connection) DriverManager.getConnection(Url, User, Password);
            if(Conexion != null){
                StatementDB = Conexion.createStatement();
            }else{
                status = msgFile.getProperty("msg0002");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(manejadorDB.class.getName()).log(Level.SEVERE, null, ex);
            status = msgFile.getProperty("msg0002");
        }
        /////////////////////////////////////////////////
        
        /////////////////////////////////////////////////
    }
    
    //EJECUTA UPDATE, INSERT, DELETE, CREATE TABLE, DROP TABLE, ETC.
    public boolean executeUpdate(String Query){
        try {
            StatementDB.executeUpdate(Query);
            return true;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(manejadorDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
    }
    
    //EJECUTA SELECT
    public ResultSet executeQuery(String Query){
        try {
            ResultSetDB = StatementDB.executeQuery(Query);

        } catch (SQLException ex) {
            Logger.getLogger(manejadorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ResultSetDB;
    }

     public void insertData(String table_name, String user, String pass, String codPersona, String nivel) {
        try {
            String Query = "INSERT INTO " + table_name + " VALUES("
                    + "\"" + user + "\", "
                    + "\"" + pass + "\", "
                    + "\"" + codPersona + "\", "
                    + "\"" + nivel + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Datos almacenados de forma exitosa");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el almacenamiento de datos");
        }
    }
     

    public void metaDatos(){
        try {
            DatabaseMetaData metaDatos = Conexion.getMetaData();
            
           
            ResultSet rs = metaDatos.getTables(null, null, "%", null);
            while (rs.next()) {
                // El contenido de cada columna del ResultSet se puede ver
                // en la API, en el metodo getTables() de DataBaseMetaData.
                // La columna 1 es TABLE_CAT
                // y la 3 es TABLE_NAME
                String catalogo = rs.getString(1);
                String tabla = rs.getString(3);
                System.out.println("TABLA=" + catalogo + "." + tabla);
                
                ResultSet rs2 = metaDatos.getColumns(catalogo, null, tabla, null);
                 while (rs2.next()) {
                    // El contenido de cada columna del ResultSet se puede ver en
                    // la API de java, en el metodo getColumns() de DataBaseMetaData
                    // La 4 corresponde al TABLE_NAME
                    // y la 6 al TYPE_NAME
                    String nombreColumna = rs2.getString(4);
                    String tipoColumna = rs2.getString(6);
                    System.out.println(" COLUMNA, nombre=" + nombreColumna
                       + " tipo = " + tipoColumna);
                 }
            }
            
            
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
