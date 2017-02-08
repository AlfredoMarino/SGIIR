/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Alfredo Mariño
 */
public class statusBar extends JLabel {
    
        /** Creates a new instance of StatusBar */
    public statusBar() {
        super();
        super.setPreferredSize(new Dimension(100, 16));
        setMsg("Ready");
    }

    public void setMsg(String message) {
        setText(message);        
    }   
    
    public void clrMsg() {
        setText("");        
    }   
    
}
