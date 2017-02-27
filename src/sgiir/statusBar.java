/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Alfredo Mariño
 */
public class statusBar extends JLabel {
    
        /** Creates a new instance of StatusBar */
    public statusBar() {
        super();
        super.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        super.setPreferredSize(new Dimension(100, 16));
        super.setFont(new Font("Tahoma", Font.BOLD, 11));
        clrMsg();
    }

    public void setMsg(String message) {
        setText(message);        
    }   
    
    public void clrMsg() {
        setText("");        
    }   
    
    
    //////////////SINGLETON
    public static statusBar getInstance() {
        return statusBarHolder.INSTANCE;
    }
    
    private static class statusBarHolder {
        private static final statusBar INSTANCE = new statusBar();
    }
    ////////////////////////
}
