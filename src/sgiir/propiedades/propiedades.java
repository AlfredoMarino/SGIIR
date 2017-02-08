/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.propiedades;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alfredo Mariño
 */
public class propiedades extends Properties {
    
    public String idiomaDefault = "/idiomas/espanol.properties";
    
    //PROPERTIES FILE
    public String idiomaEspanol = "/idiomas/espanol.properties";
    public String idiomaIngles = "ingles.properties";
    public String configuracionDB = "configuracionDB.properties";
    public String configuracionEmail = "";
    
    //LOS OBJETOS QUE INSTANCIAN ESTA CLASE SIN INDICAR QUE PROPERTIES FILE USARÁN, TOMAN POR DEFECTO espanol.properties
    public  propiedades(){
        getProperties(idiomaDefault);
    }
    
    public  propiedades(int IdFile){
        
        switch(IdFile){
            case 1: 
                getProperties(idiomaEspanol);
            break;
                
            case 2:
                getProperties(idiomaIngles);               
            break;
            
            case 3:               
                getProperties(configuracionDB);               
            break;
                
            case 4:              
                getProperties(configuracionEmail);               
            break;
        }
    }
    
    private void getProperties(String idioma) {
      
        try {
            this.load(getClass().getResourceAsStream(idioma));
        } catch (IOException ex) {
            Logger.getLogger(propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
