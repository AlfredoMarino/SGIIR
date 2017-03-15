/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import sgiir.Vistas.framePopup;
import sgiir.Vistas.frameLogin;
import sgiir.programadorSugerido.Persona;


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

//        frameLogin VistaLogin = new frameLogin();
//        VistaLogin.setVisible(true);
        
        programadorSugerido sugerencia = new programadorSugerido();
        
        List<Persona> listaSugerencia = sugerencia.programadorDisponible();
        for(Persona  p : listaSugerencia){
            System.out.println(p.codigoPersona + " " + p.nombrePersona + " " + p.match);
        }

//        FrameTest VistaCargo = new FrameTest();
//        VistaCargo.setVisible(true);

//        supervisor Supervisor = new supervisor();
//        System.out.println(Supervisor.seguimiento());
        

//        framePopup VistaPopup = new framePopup();
//        VistaPopup.pnlReporte.setReporte(2); //REPORTE TAREAS FINALIZADAS
//        VistaPopup.showPanel("REPORTE");
//        VistaPopup.setVisible(true);
    }
    
}
