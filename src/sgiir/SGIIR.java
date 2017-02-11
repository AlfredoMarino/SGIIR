/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sgiir.Vistas.login;

/**
 *
 * @author Alfredo Mariño
 */
public class SGIIR {

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        // TODO code application logic here
        manejadorDB DataBase = manejadorDB.getInstance();

        //Estilo de ventanas
        UIManager.setLookAndFeel(new WindowsLookAndFeel());

        login VistaLogin = new login();
        VistaLogin.setVisible(true);
        
    }
    
}
