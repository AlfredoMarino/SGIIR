/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.awt.CardLayout;

/**
 *
 * @author Alfredo Mariño
 */
public class framePopup extends javax.swing.JFrame {
    
    public panelCaracteristica pnlCaracteristica = new panelCaracteristica();
    public panelInvolucrado pnlInvolucrado = new panelInvolucrado();
    public panelReporte pnlReporte = new panelReporte();
    public panelSugerencia pnlSugerencia = new panelSugerencia();
    CardLayout controladorPaneles;
    
    /**
     * Creates new form popup
     */
    public framePopup() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        controlPanel();
    }

    public void controlPanel(){
        
        pnlDetails.add(pnlCaracteristica, "CARACTERISTICA");
        pnlDetails.add(pnlInvolucrado, "INVOLUCRADO");
        pnlDetails.add(pnlReporte, "REPORTE");
        pnlDetails.add(pnlSugerencia, "SUGERENCIA");

        controladorPaneles = (CardLayout)(pnlDetails.getLayout());
    }
    
    public void showPanel(String panel){
        controladorPaneles.show(pnlDetails, panel);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDetails = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(500, 250));
        setSize(new java.awt.Dimension(500, 500));

        pnlDetails.setOpaque(false);
        pnlDetails.setPreferredSize(new java.awt.Dimension(500, 350));
        pnlDetails.setLayout(new java.awt.CardLayout());
        getContentPane().add(pnlDetails, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(framePopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(framePopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(framePopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(framePopup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new framePopup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlDetails;
    // End of variables declaration//GEN-END:variables
}
