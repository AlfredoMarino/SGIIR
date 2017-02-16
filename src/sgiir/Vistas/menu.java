/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import sgiir.statusBar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import sgiir.manejadorDB;
import sgiir.propiedades.propiedades;

/**
 *
 * @author Alfredo Mariño
 */
public class menu extends javax.swing.JFrame {
    
    private propiedades msgFile = new propiedades();
    private propiedades qryFile = new propiedades(5);
    private String Query = "";
    private ResultSet rs;

    
    public byte TypeUser;
    
    //Manejador de base de datos
    manejadorDB DataBase = manejadorDB.getInstance(); 
    
    //PANELES
    public panelInstitucion VistaInstitucion = new panelInstitucion();
    public panelResumen VistaResumen = new panelResumen();
    public panelArea VistaArea = new panelArea();
    public panelCargo VistaCargo = new panelCargo();
    public panelPersona VistaPersona = new panelPersona();
    public panelAutenticacion VistaAutenticacion = new panelAutenticacion();
    public panelNaturaleza VistaNaturaleza = new panelNaturaleza();
    public panelSeguimiento VistaSeguimiento = new panelSeguimiento();
    
    
    CardLayout controladorPaneles;
    
    
    /**
     * Creates new form menu
     */
    public menu() {
        initComponents();
             
        controlPanel();
    }
    
    public menu(int codigoPersona, Byte nivel){
        
        initComponents();

        controlPanel();

        try {
            typeUser(nivel);
        } catch (SQLException ex) {
            Logger.getLogger(menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //configura menu dependiendo del tipo de autorizacion del usuario
    private void typeUser(Byte nivelAutenticacion) throws SQLException{
        
        TypeUser = nivelAutenticacion;
        
        switch(TypeUser){
            //Master
            case 1:
                Query = qryFile.getProperty("qry0001");
                               
                rs = DataBase.executeQuery(Query);
                rs.absolute(1);
                //StatusBar.setText(rs.getString("DescripcionTarea"));
                
            break;
            
            //CAU
            case 2:
                
            break;
            
            //Director
            case 3:
                
            break;
           
            //Programador
            case 4:
                
            break;
        }

                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHead = new javax.swing.JPanel();
        pnlDetails = new javax.swing.JPanel();
        pnlFoot = new javax.swing.JPanel();
        StatusBar = new statusBar();
        menuBar = new javax.swing.JMenuBar();
        mnuInicio = new javax.swing.JMenu();
        mnuTarea = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuPersonas = new javax.swing.JMenu();
        mitPersona = new javax.swing.JMenuItem();
        mitAutenticacion = new javax.swing.JMenuItem();
        mnuConfiguracion = new javax.swing.JMenu();
        mitArea = new javax.swing.JMenuItem();
        mitInstitucion = new javax.swing.JMenuItem();
        mitCargo = new javax.swing.JMenuItem();
        mitNaturaleza = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        mnuAcerca = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(msgFile.getProperty("lbl0000"));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        pnlHead.setPreferredSize(new java.awt.Dimension(0, 50));

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 798, Short.MAX_VALUE)
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(pnlHead, java.awt.BorderLayout.NORTH);

        pnlDetails.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnlDetails, java.awt.BorderLayout.CENTER);

        StatusBar.setText("");

        javax.swing.GroupLayout pnlFootLayout = new javax.swing.GroupLayout(pnlFoot);
        pnlFoot.setLayout(pnlFootLayout);
        pnlFootLayout.setHorizontalGroup(
            pnlFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StatusBar, javax.swing.GroupLayout.DEFAULT_SIZE, 798, Short.MAX_VALUE)
        );
        pnlFootLayout.setVerticalGroup(
            pnlFootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlFootLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(StatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(pnlFoot, java.awt.BorderLayout.SOUTH);

        mnuInicio.setText("Inicio");
        mnuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnuInicioMouseClicked(evt);
            }
        });
        mnuInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuInicioActionPerformed(evt);
            }
        });
        menuBar.add(mnuInicio);

        mnuTarea.setText("Tareas");

        jMenuItem1.setText("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        mnuTarea.add(jMenuItem1);

        jMenuItem2.setText("jMenuItem2");
        mnuTarea.add(jMenuItem2);

        menuBar.add(mnuTarea);

        jMenu2.setText("Reportes");
        menuBar.add(jMenu2);

        mnuPersonas.setText(msgFile.getProperty("lbl0006"));
        mnuPersonas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mnuPersonasMouseReleased(evt);
            }
        });
        mnuPersonas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPersonasActionPerformed(evt);
            }
        });

        mitPersona.setText(msgFile.getProperty("lbl0006"));
        mitPersona.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mitPersonaMouseReleased(evt);
            }
        });
        mitPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitPersonaActionPerformed(evt);
            }
        });
        mnuPersonas.add(mitPersona);

        mitAutenticacion.setText(msgFile.getProperty("lbl0020")
        );
        mitAutenticacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mitAutenticacionMouseReleased(evt);
            }
        });
        mnuPersonas.add(mitAutenticacion);

        menuBar.add(mnuPersonas);

        mnuConfiguracion.setText(msgFile.getProperty("lbl0007"));

        mitArea.setText(msgFile.getProperty("lbl0013"));
        mitArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAreaActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mitArea);

        mitInstitucion.setText(msgFile.getProperty("lbl0014"));
        mitInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitInstitucionActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mitInstitucion);

        mitCargo.setText(msgFile.getProperty("lbl0015"));
        mitCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitCargoActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mitCargo);

        mitNaturaleza.setText("jMenuItem3");
        mitNaturaleza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitNaturalezaActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(mitNaturaleza);

        jMenuItem3.setText("jMenuItem3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        mnuConfiguracion.add(jMenuItem3);

        menuBar.add(mnuConfiguracion);

        mnuAcerca.setText("Acerca de");
        menuBar.add(mnuAcerca);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
 
        //controladorPaneles.show(pnlDetails, "TAREA");
        //controladorPaneles.show(pnlDetails, "TAREA");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void mitAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAreaActionPerformed
        controladorPaneles.show(pnlDetails, "AREA");
    }//GEN-LAST:event_mitAreaActionPerformed

    private void mitInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitInstitucionActionPerformed
       controladorPaneles.show(pnlDetails, "INSTITUCION");
    }//GEN-LAST:event_mitInstitucionActionPerformed

    private void mnuInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuInicioActionPerformed
      
    }//GEN-LAST:event_mnuInicioActionPerformed

    private void mnuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuInicioMouseClicked
        controladorPaneles.show(pnlDetails, "RESUMEN");
    }//GEN-LAST:event_mnuInicioMouseClicked

    private void mitCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitCargoActionPerformed
        controladorPaneles.show(pnlDetails, "CARGO");
    }//GEN-LAST:event_mitCargoActionPerformed

    private void mnuPersonasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPersonasActionPerformed
        
    }//GEN-LAST:event_mnuPersonasActionPerformed

    private void mnuPersonasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnuPersonasMouseReleased
        
    }//GEN-LAST:event_mnuPersonasMouseReleased

    private void mitPersonaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mitPersonaMouseReleased
        controladorPaneles.show(pnlDetails, "PERSONA");
    }//GEN-LAST:event_mitPersonaMouseReleased

    private void mitAutenticacionMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mitAutenticacionMouseReleased
        controladorPaneles.show(pnlDetails, "AUTENTICACION");
    }//GEN-LAST:event_mitAutenticacionMouseReleased

    private void mitPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mitPersonaActionPerformed

    private void mitNaturalezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitNaturalezaActionPerformed
        controladorPaneles.show(pnlDetails, "NATURALEZA");
    }//GEN-LAST:event_mitNaturalezaActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        controladorPaneles.show(pnlDetails, "SEGUIMIENTO");
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu().setVisible(true);
            }
        });
    }

    private void controlPanel(){
        
        pnlDetails.add(VistaPersona, "PERSONA");
        pnlDetails.add(VistaResumen, "RESUMEN");
        pnlDetails.add(VistaInstitucion, "INSTITUCION");
        pnlDetails.add(VistaArea, "AREA");
        pnlDetails.add(VistaCargo, "CARGO");
        pnlDetails.add(VistaAutenticacion, "AUTENTICACION");
        pnlDetails.add(VistaNaturaleza, "NATURALEZA");
        pnlDetails.add(VistaSeguimiento, "SEGUIMIENTO");
        
        
        controladorPaneles = (CardLayout)(pnlDetails.getLayout());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel StatusBar;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mitArea;
    private javax.swing.JMenuItem mitAutenticacion;
    private javax.swing.JMenuItem mitCargo;
    private javax.swing.JMenuItem mitInstitucion;
    private javax.swing.JMenuItem mitNaturaleza;
    private javax.swing.JMenuItem mitPersona;
    private javax.swing.JMenu mnuAcerca;
    private javax.swing.JMenu mnuConfiguracion;
    private javax.swing.JMenu mnuInicio;
    private javax.swing.JMenu mnuPersonas;
    private javax.swing.JMenu mnuTarea;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JPanel pnlFoot;
    private javax.swing.JPanel pnlHead;
    // End of variables declaration//GEN-END:variables
}
