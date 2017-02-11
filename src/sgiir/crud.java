/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir;

/**
 *
 * @author Alfredo Mariño
 */
public class crud extends javax.swing.JPanel{
    
    public crud() {
        initComponents();
    }
    
    private void initComponents() {

        BodyPanel = new javax.swing.JPanel();
        KeyPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout BodyPanelLayout = new javax.swing.GroupLayout(BodyPanel);
        BodyPanel.setLayout(BodyPanelLayout);
        BodyPanelLayout.setHorizontalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );

        add(BodyPanel, java.awt.BorderLayout.CENTER);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout KeyPanelLayout = new javax.swing.GroupLayout(KeyPanel);
        KeyPanel.setLayout(KeyPanelLayout);
        KeyPanelLayout.setHorizontalGroup(
            KeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KeyPanelLayout.createSequentialGroup()
                .addContainerGap(552, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(21, 21, 21))
        );
        KeyPanelLayout.setVerticalGroup(
            KeyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KeyPanelLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jButton1)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        add(KeyPanel, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>   
                        
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JPanel KeyPanel;
    private javax.swing.JButton jButton1;
    // End of variables declaration      
}
