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
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sgiir.Entidades.Cargo;
import sgiir.comboBox;
import sgiir.manejadorDB;
import static sgiir.manejadorDB.Conexion;
import sgiir.propiedades.propiedades;


/**
 *
 * @author Alfredo Mariño
 */
public class panelPersona extends JPanel {
    
    //Manejador de base de datos
    manejadorDB DataBase = manejadorDB.getInstance(); 
    private propiedades msgFile = new propiedades();
    private propiedades qryFile = new propiedades(5);
    private String Query = "";
    private ResultSet rs;
    private int i=0;
    
    public panelPersona() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        cargaComboCargo();
    }
    
    private void cargaComboCargo(){
       //cargo1 = (Cargo) entityManager.find(Cargo.class, 1);
        cbxCargo.removeAllItems();
        Cargo[] cargos = new Cargo[100];
                
        try {
            rs = DataBase.executeQuery(qryFile.getProperty("qry0004"));
            i = 0;
            cbxCargo.addItem(new comboBox(i,""));
            i++;
            while(rs.next()){

                cbxCargo.addItem(new comboBox(rs.getInt("codigoCargo"), rs.getString("descripcionCargo")));
 
                i++;
            }
        } catch (SQLException ex) {
        Logger.getLogger(panelCargo.class.getName()).log(Level.SEVERE, null, ex);
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
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SGIIRPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT p FROM Persona p");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        cargoQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT c FROM Cargo c");
        cargoList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : cargoQuery.getResultList();
        cargo1 = new sgiir.Entidades.Cargo();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        codigoPersonaLabel = new javax.swing.JLabel();
        nombrePersonaLabel = new javax.swing.JLabel();
        emailPersonaLabel = new javax.swing.JLabel();
        telefonoPersonaLabel = new javax.swing.JLabel();
        codigoCargoLabel = new javax.swing.JLabel();
        recordatorioPersonaLabel = new javax.swing.JLabel();
        codigoPersonaField = new javax.swing.JTextField();
        nombrePersonaField = new javax.swing.JTextField();
        emailPersonaField = new javax.swing.JTextField();
        telefonoPersonaField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        cbxCargo = new javax.swing.JComboBox<>();
        chbRecordatorio = new javax.swing.JCheckBox();

        FormListener formListener = new FormListener();

        masterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoPersona}"));
        columnBinding.setColumnName("Codigo de persona");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoCargo.codigoCargo}"));
        columnBinding.setColumnName("Codigo Cargo");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${nombrePersona}"));
        columnBinding.setColumnName("Nombre Persona");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoCargo.descripcionCargo}"));
        columnBinding.setColumnName("Cargo");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoCargo.codigoInstitucion.nombreInstitucion}"));
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
            masterTable.getColumnModel().getColumn(3).setResizable(false);
            masterTable.getColumnModel().getColumn(4).setResizable(false);
        }
        masterTable.getColumnModel().getColumn(0).setMaxWidth(0);
        masterTable.getColumnModel().getColumn(0).setMinWidth(0);
        masterTable.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        masterTable.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);

        masterTable.getColumnModel().getColumn(1).setMaxWidth(0);
        masterTable.getColumnModel().getColumn(1).setMinWidth(0);
        masterTable.getTableHeader().getColumnModel().getColumn(1).setMaxWidth(0);
        masterTable.getTableHeader().getColumnModel().getColumn(1).setMinWidth(0);

        codigoPersonaLabel.setText("Codigo Persona:");

        nombrePersonaLabel.setText("Nombre Persona:");

        emailPersonaLabel.setText("Email Persona:");

        telefonoPersonaLabel.setText("Telefono Persona:");

        codigoCargoLabel.setText("Codigo Cargo:");

        recordatorioPersonaLabel.setText("Recordatorio Persona:");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoPersona}"), codigoPersonaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), codigoPersonaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nombrePersona}"), nombrePersonaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), nombrePersonaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.emailPersona}"), emailPersonaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), emailPersonaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.telefonoPersona}"), telefonoPersonaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), telefonoPersonaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
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

        cbxCargo.addMouseListener(formListener);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.recordatorioPersona}"), chbRecordatorio, org.jdesktop.beansbinding.BeanProperty.create("selected"));
        bindingGroup.addBinding(binding);

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
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigoPersonaLabel)
                                    .addComponent(nombrePersonaLabel)
                                    .addComponent(emailPersonaLabel)
                                    .addComponent(telefonoPersonaLabel)
                                    .addComponent(codigoCargoLabel)
                                    .addComponent(recordatorioPersonaLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigoPersonaField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(nombrePersonaField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(emailPersonaField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addComponent(telefonoPersonaField, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chbRecordatorio)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(cbxCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoPersonaLabel)
                    .addComponent(codigoPersonaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombrePersonaLabel)
                    .addComponent(nombrePersonaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailPersonaLabel)
                    .addComponent(emailPersonaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefonoPersonaLabel)
                    .addComponent(telefonoPersonaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoCargoLabel)
                    .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recordatorioPersonaLabel)
                    .addComponent(chbRecordatorio))
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
                panelPersona.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                panelPersona.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                panelPersona.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                panelPersona.this.deleteButtonActionPerformed(evt);
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
            if (evt.getSource() == cbxCargo) {
                panelPersona.this.cbxCargoMouseReleased(evt);
            }
            else if (evt.getSource() == masterTable) {
                panelPersona.this.masterTableMouseReleased(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    
    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshMasterTable();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
         Query = "DELETE FROM persona WHERE CodigoPersona = " + masterTable.getValueAt(masterTable.getSelectedRow(), 0).toString();
        if(DataBase.executeUpdate(Query)){
            refreshMasterTable();
        }
        /*
        int[] selected = masterTable.getSelectedRows();
        List<sgiir.Entidades.Persona> toRemove = new ArrayList<sgiir.Entidades.Persona>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            sgiir.Entidades.Persona p = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(p);
            entityManager.remove(p);
        }
        list.removeAll(toRemove);*/
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        sgiir.Entidades.Persona p = new sgiir.Entidades.Persona();
        entityManager.persist(p);
        list.add(p);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        comboBox datoCombo =(comboBox) cbxCargo.getSelectedItem();
        
        try {
            //si esta seleccionando uno en el grid y el codigo de la primera columna es diferente de 0 hace update
            if(masterTable.getSelectedRow() != -1){
                Query = "INSERT INTO persona (CodigoPersona, NombrePersona, EmailPersona, TelefonoPersona, CodigoCargo, RecordatorioPersona) VALUES (NULL, ?, ?, ?, ?, ?)"; 
                int filaSeleccionada = masterTable.getSelectedRow();
                
                if(masterTable.getValueAt(filaSeleccionada, 0) != null){     
                    Query = "UPDATE persona SET NombrePersona = ?, EmailPersona = ?, TelefonoPersona = ?, CodigoCargo = ?, RecordatorioPersona = ? WHERE persona.CodigoPersona = " + masterTable.getValueAt(filaSeleccionada, 0);
                }

                PreparedStatement ps = Conexion.prepareCall(Query);
                ps.setString(1, nombrePersonaField.getText());
                ps.setString(2, emailPersonaField.getText());
                ps.setString(3, telefonoPersonaField.getText());
                ps.setInt(4, datoCombo.getId());
                ps.setBoolean(5, chbRecordatorio.isSelected());

                int res = ps.executeUpdate();
                if(res > 0){
                    refreshMasterTable();
                }
                //entityManager.getTransaction().commit();
                //entityManager.getTransaction().begin();
            }
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<sgiir.Entidades.Persona> merged = new ArrayList<sgiir.Entidades.Persona>(list.size());
            for (sgiir.Entidades.Persona p : list) {
                merged.add(entityManager.merge(p));
            }
            list.clear();
            list.addAll(merged);
        } catch (SQLException ex) {
            Logger.getLogger(panelPersona.class.getName()).log(Level.SEVERE, null, ex);
            
            entityManager.getTransaction().begin();
            List<sgiir.Entidades.Persona> merged = new ArrayList<sgiir.Entidades.Persona>(list.size());
            for (sgiir.Entidades.Persona p : list) {
                merged.add(entityManager.merge(p));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cbxCargoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxCargoMouseReleased
        
    }//GEN-LAST:event_cbxCargoMouseReleased

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        if(evt.getButton()==1){
            int filaSeleccionada = masterTable.getSelectedRow();
            try{
                //habilitar
                Query = "select * from cargo where codigoCargo = " + masterTable.getValueAt(filaSeleccionada, 1);
                rs = DataBase.executeQuery(Query);
                rs.next();              
                cbxCargo.setSelectedItem(new comboBox(rs.getInt("codigoCargo"), rs.getString("DescripcionCargo")));
                
            } catch (SQLException ex) {
                Logger.getLogger(panelCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_masterTableMouseReleased

    private void refreshMasterTable(){
        
        cbxCargo.setSelectedIndex(0);
        chbRecordatorio.setSelected(false);
        
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
    private sgiir.Entidades.Cargo cargo1;
    private java.util.List<sgiir.Entidades.Cargo> cargoList;
    private javax.persistence.Query cargoQuery;
    private javax.swing.JComboBox<comboBox> cbxCargo;
    private javax.swing.JCheckBox chbRecordatorio;
    private javax.swing.JLabel codigoCargoLabel;
    private javax.swing.JTextField codigoPersonaField;
    private javax.swing.JLabel codigoPersonaLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField emailPersonaField;
    private javax.swing.JLabel emailPersonaLabel;
    private javax.persistence.EntityManager entityManager;
    private java.util.List<sgiir.Entidades.Persona> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nombrePersonaField;
    private javax.swing.JLabel nombrePersonaLabel;
    private javax.persistence.Query query;
    private javax.swing.JLabel recordatorioPersonaLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField telefonoPersonaField;
    private javax.swing.JLabel telefonoPersonaLabel;
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
            java.util.logging.Logger.getLogger(panelPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new panelPersona());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}