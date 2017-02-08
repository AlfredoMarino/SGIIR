/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import org.apache.commons.codec.digest.DigestUtils;
import sgiir.Vistas.login;

/**
 *
 * @author Alfredo Mariño
 */
public class SGIIR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        manejadorDB DataBase = manejadorDB.getInstance();
        
        login vistaLogin = new login();
        vistaLogin.show();
        
    }
    
}
