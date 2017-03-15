/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.awt.EventQueue;
import java.beans.Beans;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sgiir.Entidades.Involucrado;
import sgiir.Entidades.InvolucradoPK;
import sgiir.Entidades.Naturaleza;
import sgiir.Entidades.Persona;
import sgiir.Entidades.Tarea;
import sgiir.comboBox;
import static sgiir.manejadorDB.Conexion;

/**
 *
 * @author Alfredo Mariño
 */
public class panelInvolucrado extends JPanel {
    private int CodigoNaturaleza;
    private int CodigoTarea;
    private int CodigoInvolucrado;
    private int CodigoPersona;
    
    public panelInvolucrado() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        
        comboPersona();
    }

    public void setInvolucrado(int CodigoNaturaleza, int CodigoTarea, int CodigoInvolucrado) {
        this.CodigoNaturaleza = CodigoNaturaleza;
        this.CodigoTarea = CodigoTarea;
        this.CodigoInvolucrado = CodigoInvolucrado;
        
        query = entityManager.createNativeQuery("SELECT * FROM Involucrado where codigoNaturaleza = ? and codigoTarea = ? and codigoInvolucrado = ?", Involucrado.class);
        
        query.setParameter(1, CodigoNaturaleza);
        query.setParameter(2, CodigoTarea);
        query.setParameter(3, CodigoInvolucrado);
        
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);

    }
    
    //carga el ultimo involucrado, y le setea el codigo involucrado que viene de parametro, por si decide insertar
    public void setUltimoInvolucrado(int CodigoNaturaleza, int CodigoTarea, int CodigoInvolucrado) {
        int ultimoInvolucrado = 0;
        this.CodigoNaturaleza = CodigoNaturaleza;
        this.CodigoTarea = CodigoTarea;
        this.CodigoInvolucrado = CodigoInvolucrado;
        
        Query queryUltimoInvolucrado = entityManager.createNativeQuery("SELECT * FROM Involucrado "
                + "where codigoNaturaleza = ? and codigoTarea = ? and codigoInvolucrado = "
                + "(Select codigoInvolucrado from involucrado "
                + "where codigoNaturaleza = ? and codigoTarea = ? "
                + "ORDER BY codigoInvolucrado DESC "
                + "LIMIT 1)", Involucrado.class);
        queryUltimoInvolucrado.setParameter(1, CodigoNaturaleza);
        queryUltimoInvolucrado.setParameter(2, CodigoTarea);
        queryUltimoInvolucrado.setParameter(3, CodigoNaturaleza);
        queryUltimoInvolucrado.setParameter(4, CodigoTarea);
        
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = queryUltimoInvolucrado.getResultList();
        for (Object entity : data) {
            
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);

    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SGIIRPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Involucrado i");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        personaField = new javax.swing.JTextField();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        personaLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cbxPersona = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.persona.codigoPersona}"), personaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), personaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        masterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${persona.nombrePersona}"));
        columnBinding.setColumnName("Persona");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${persona.codigoCargo.descripcionCargo}"));
        columnBinding.setColumnName("Cargo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${persona.codigoCargo.codigoInstitucion.nombreInstitucion}"));
        columnBinding.setColumnName("Institucion");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setResizable(false);
            masterTable.getColumnModel().getColumn(1).setResizable(false);
            masterTable.getColumnModel().getColumn(2).setResizable(false);
        }

        personaLabel.setText("Persona:");

        saveButton.setText("Guardar");
        saveButton.addActionListener(formListener);

        refreshButton.setText("Refrescar");
        refreshButton.addActionListener(formListener);

        newButton.setText("Nuevo");
        newButton.addActionListener(formListener);

        deleteButton.setText("Eliminar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        jButton1.setText("Sugerencia");
        jButton1.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(newButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refreshButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(personaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbxPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(jButton1)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personaLabel)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(refreshButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton))
                .addContainerGap())
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.MouseListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                panelInvolucrado.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                panelInvolucrado.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                panelInvolucrado.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                panelInvolucrado.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                panelInvolucrado.this.jButton1ActionPerformed(evt);
            }
        }

        public void mouseClicked(java.awt.event.MouseEvent evt) {
        }

        public void mouseEntered(java.awt.event.MouseEvent evt) {
        }

        public void mouseExited(java.awt.event.MouseEvent evt) {
        }

        public void mousePressed(java.awt.event.MouseEvent evt) {
        }

        public void mouseReleased(java.awt.event.MouseEvent evt) {
            if (evt.getSource() == masterTable) {
                panelInvolucrado.this.masterTableMouseReleased(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    
    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refresh();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<sgiir.Entidades.Involucrado> toRemove = new ArrayList<sgiir.Entidades.Involucrado>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            sgiir.Entidades.Involucrado i = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(i);
            entityManager.remove(i);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        sgiir.Entidades.Involucrado i = new sgiir.Entidades.Involucrado();
        entityManager.persist(i);
        list.add(i);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            
            
            comboBox itemCombo;
            itemCombo = (comboBox) cbxPersona.getSelectedItem();
            CodigoPersona = itemCombo.getId();
            

            int[] selected = masterTable.getSelectedRows();
            List<Involucrado> toMerged = new ArrayList<Involucrado>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                Involucrado i = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                i.setInvolucradoPK(new InvolucradoPK(CodigoNaturaleza, CodigoTarea, CodigoInvolucrado, CodigoPersona));
                i.setTarea(new Tarea(CodigoTarea));
                i.setNaturaleza(new Naturaleza(CodigoNaturaleza));
                i.setPersona(new Persona(CodigoPersona));
                
                toMerged.add(i);

                entityManager.merge(i);
            }
            
            
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
            
            refresh();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<sgiir.Entidades.Involucrado> merged = new ArrayList<sgiir.Entidades.Involucrado>(list.size());
            for (sgiir.Entidades.Involucrado i : list) {
                merged.add(entityManager.merge(i));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        if(masterTable.getSelectedRow() != -1){
            for (int index = 0; index < cbxPersona.getItemCount(); index++) {
                if(Integer.valueOf(personaField.getText()) == cbxPersona.getItemAt(index).getId()){
                    cbxPersona.setSelectedIndex(index);
                }
            }
        }
    }//GEN-LAST:event_masterTableMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        framePopup vistaSugerencia = new framePopup();
        vistaSugerencia.pnlSugerencia.setParametros(CodigoNaturaleza, CodigoTarea);
        vistaSugerencia.showPanel("SUGERENCIA");
        vistaSugerencia.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void defaultComboPersona(){
        cbxPersona.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxPersona.addItem(ItemCombo);        
    }
    private void comboPersona(){
        cbxPersona.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxPersona.addItem(ItemCombo);   

        TypedQuery<Persona> queryPersona = entityManager.createNamedQuery("Persona.findAll", Persona.class);
        List<Persona> resultQueryPersona = queryPersona.getResultList();
        
        for(Persona entidad : resultQueryPersona){
            cbxPersona.addItem(entidad.getItemComboBox());
        }

    }
    
    private static boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }

    private void refresh(){
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<comboBox> cbxPersona;
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JButton jButton1;
    private java.util.List<sgiir.Entidades.Involucrado> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField personaField;
    private javax.swing.JLabel personaLabel;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    public static void main(String[] args) {
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
            java.util.logging.Logger.getLogger(panelInvolucrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelInvolucrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelInvolucrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelInvolucrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new panelInvolucrado());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
