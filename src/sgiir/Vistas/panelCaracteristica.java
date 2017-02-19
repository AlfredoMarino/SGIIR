/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sgiir.Entidades.Area;
import sgiir.Entidades.Caracteristica;
import sgiir.Entidades.Naturaleza;
import sgiir.Entidades.Tarea;
import sgiir.comboBox;

/**
 *
 * @author Alfredo Mariño
 */
public class panelCaracteristica extends JPanel {
    
    public panelCaracteristica() {
        
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        
        comboArea();
    }
    
    public void setCaracteristica(int CodigoNaturaleza, int CodigoTarea) {
        
        
        query = entityManager.createNativeQuery("SELECT * FROM Caracteristica where codigoNaturaleza = ? and codigoTarea = ?", Caracteristica.class);
        
        query.setParameter(1, CodigoNaturaleza);
        query.setParameter(2, CodigoTarea);
        
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
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
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Caracteristica c");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        areaField = new javax.swing.JTextField();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        tareaLabel = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        tareaField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cbxArea = new javax.swing.JComboBox<>();

        FormListener formListener = new FormListener();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.area.descripcionArea}"), areaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), areaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${area.codigoArea}"));
        columnBinding.setColumnName("Area");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${naturaleza}"));
        columnBinding.setColumnName("Naturaleza");
        columnBinding.setColumnClass(sgiir.Entidades.Naturaleza.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tarea}"));
        columnBinding.setColumnName("Tarea");
        columnBinding.setColumnClass(sgiir.Entidades.Tarea.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${area.nombreArea}"));
        columnBinding.setColumnName("Nombre Area");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${area.descripcionArea}"));
        columnBinding.setColumnName("Descripcion");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);

        tareaLabel.setText("Tarea:");

        areaLabel.setText("Area:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), tareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setText("Save");
        saveButton.addActionListener(formListener);

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(formListener);

        newButton.setText("New");
        newButton.addActionListener(formListener);

        deleteButton.setText("Delete");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        cbxArea.addMouseListener(formListener);

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
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tareaLabel)
                                    .addComponent(areaLabel))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tareaField, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
                                    .addComponent(cbxArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(cbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tareaLabel)
                    .addComponent(tareaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(areaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                panelCaracteristica.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                panelCaracteristica.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                panelCaracteristica.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                panelCaracteristica.this.deleteButtonActionPerformed(evt);
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
            if (evt.getSource() == cbxArea) {
                panelCaracteristica.this.cbxAreaMouseReleased(evt);
            }
            else if (evt.getSource() == masterTable) {
                panelCaracteristica.this.masterTableMouseReleased(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    
    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<sgiir.Entidades.Caracteristica> toRemove = new ArrayList<sgiir.Entidades.Caracteristica>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            sgiir.Entidades.Caracteristica c = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(c);
            entityManager.remove(c);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        sgiir.Entidades.Caracteristica c = new sgiir.Entidades.Caracteristica();
        entityManager.persist(c);
        list.add(c);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            Caracteristica c = new Caracteristica(1, 2, 3);
            entityManager.merge(c);
            
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<sgiir.Entidades.Caracteristica> merged = new ArrayList<sgiir.Entidades.Caracteristica>(list.size());
            for (sgiir.Entidades.Caracteristica c : list) {
                merged.add(entityManager.merge(c));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cbxAreaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxAreaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxAreaMouseReleased

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        if(masterTable.getSelectedRow() != -1){
            for (int index = 0; index < cbxArea.getItemCount(); index++) {
                if(Integer.valueOf(areaField.getText()) == cbxArea.getItemAt(index).getId()){
                    cbxArea.setSelectedIndex(index);
                }
            }
        }
    }//GEN-LAST:event_masterTableMouseReleased
    private void defaultComboArea(){
        cbxArea.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxArea.addItem(ItemCombo);        
    }
    private void comboArea(){
        cbxArea.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxArea.addItem(ItemCombo);   

        TypedQuery<Area> queryArea = entityManager.createNamedQuery("Area.findAll", Area.class);
        List<Area> resultQueryArea = queryArea.getResultList();
        
        for(Area entidad : resultQueryArea){
            cbxArea.addItem(entidad.getItemComboBox());
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaField;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JComboBox<comboBox> cbxArea;
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private java.util.List<sgiir.Entidades.Caracteristica> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField tareaField;
    private javax.swing.JLabel tareaLabel;
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
            java.util.logging.Logger.getLogger(panelCaracteristica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelCaracteristica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelCaracteristica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelCaracteristica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new panelCaracteristica());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
