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
    
    public String idioma = "Español";
    public String idiomaEspanol = "espanol.properties";
    public String idiomaIngles = "ingles.properties";
    public String configuracionDB = "configuracionDB.properties";
    public String configuracionEmail = "";
    
    
    public void setIdioma(String lenguaje){
        idioma = lenguaje;
    }
    
    public void cargaIdioma(){
        switch(idioma){
            
            case "Español": 
                
                getProperties(idiomaEspanol);
                
            break;
                
            case "Ingles":
                
                getProperties(idiomaIngles);
                
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
