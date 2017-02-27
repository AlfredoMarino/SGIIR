/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagenes;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Alfredo Mariño
 */
public class panelImagen extends JPanel {
    private Image img;
    
    public panelImagen(Image img){
        this.img = img;
        /*Dimension dimension = new Dimension(img.getWidth(null), img.getHeight(null));
        this.setPreferredSize(dimension);
        this.setMaximumSize(dimension);
        this.setSize(dimension);
        this.setLayout(null);
        this.setBounds(this.getX(), this.getY(), img.getWidth(null), img.getHeight(null));*/
    }
    
   /*
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(img, 0, 0, null);
    }*/
    
    @Override
    public void paintComponent(Graphics g){
        Dimension dimensionSize = getSize();
        //ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/imagenes/banner.png")).getImage());
        ImageIcon imagen = new ImageIcon(img);
        g.drawImage(imagen.getImage(), 0, 0, dimensionSize.width, dimensionSize.height, null);
    }
    
}
