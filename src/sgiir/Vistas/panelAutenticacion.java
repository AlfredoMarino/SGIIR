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
import javax.persistence.TypedQuery;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.apache.commons.codec.digest.DigestUtils;
import sgiir.Entidades.Persona;
import sgiir.comboBox;
import sgiir.manejadorDB;
import static sgiir.manejadorDB.Conexion;
import sgiir.propiedades.propiedades;
import sgiir.statusBar;

/**
 *
 * @author Alfredo Mariño
 */
public class panelAutenticacion extends JPanel {
    
    //Manejador de base de datos
    manejadorDB DataBase = manejadorDB.getInstance(); 
    private propiedades msgFile = new propiedades();
    private propiedades qryFile = new propiedades(5);
    private String Query = "";
    private ResultSet rs;
    private int i=0;
    private String SavePass = "";
    private int CodigoPersona;
    
    public panelAutenticacion() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        comboPersona();
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
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT a FROM Autenticacion a");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        rgrNivelAutenticacion = new javax.swing.ButtonGroup();
        nivelAutenticacionField = new javax.swing.JTextField();
        codigoPersonaField = new javax.swing.JTextField();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        userAutenticacionLabel = new javax.swing.JLabel();
        passAutenticacionLabel = new javax.swing.JLabel();
        codigoPersonaLabel = new javax.swing.JLabel();
        nivelAutenticacionLabel = new javax.swing.JLabel();
        userAutenticacionField = new javax.swing.JTextField();
        passAutenticacionField = new javax.swing.JPasswordField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        rdbNivelUser1 = new javax.swing.JRadioButton();
        rdbNivelUser2 = new javax.swing.JRadioButton();
        rdbNivelUser3 = new javax.swing.JRadioButton();
        rdbNivelUser4 = new javax.swing.JRadioButton();
        cbxPersona = new javax.swing.JComboBox<>();

        FormListener formListener = new FormListener();

        rgrNivelAutenticacion.add(rdbNivelUser1);
        rgrNivelAutenticacion.add(rdbNivelUser2);
        rgrNivelAutenticacion.add(rdbNivelUser3);
        rgrNivelAutenticacion.add(rdbNivelUser4);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.nivelAutenticacion}"), nivelAutenticacionField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), nivelAutenticacionField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        nivelAutenticacionField.addCaretListener(formListener);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoPersona.codigoPersona}"), codigoPersonaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), codigoPersonaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        masterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${userAutenticacion}"));
        columnBinding.setColumnName("Usuario");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoPersona.nombrePersona}"));
        columnBinding.setColumnName("Nombre");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setResizable(false);
        }

        userAutenticacionLabel.setText("Usuario:");

        passAutenticacionLabel.setText("Contraseña:");

        codigoPersonaLabel.setText("Persona:");

        nivelAutenticacionLabel.setText("Nivel Autenticacion:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.userAutenticacion}"), userAutenticacionField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.userAutenticacion == null}"), userAutenticacionField, org.jdesktop.beansbinding.BeanProperty.create("editable"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), userAutenticacionField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.passAutenticacion}"), passAutenticacionField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), passAutenticacionField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

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

        rdbNivelUser1.setText(msgFile.getProperty("lbl0021")
        );
        rdbNivelUser1.addItemListener(formListener);

        rdbNivelUser2.setText(msgFile.getProperty("lbl0022"));

        rdbNivelUser3.setText(msgFile.getProperty("lbl0023"));

        rdbNivelUser4.setText(msgFile.getProperty("lbl0024"));

        cbxPersona.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
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
                            .addComponent(masterScrollPane)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userAutenticacionLabel)
                                    .addComponent(passAutenticacionLabel)
                                    .addComponent(codigoPersonaLabel)
                                    .addComponent(nivelAutenticacionLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdbNivelUser1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdbNivelUser2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbNivelUser3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdbNivelUser4))
                                    .addComponent(userAutenticacionField, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(passAutenticacionField, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 77, Short.MAX_VALUE)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userAutenticacionLabel)
                    .addComponent(userAutenticacionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passAutenticacionLabel)
                    .addComponent(passAutenticacionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoPersonaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nivelAutenticacionLabel)
                    .addComponent(rdbNivelUser1)
                    .addComponent(rdbNivelUser2)
                    .addComponent(rdbNivelUser3)
                    .addComponent(rdbNivelUser4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton)
                    .addComponent(refreshButton)
                    .addComponent(deleteButton)
                    .addComponent(newButton)))
        );

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.ItemListener, java.awt.event.MouseListener, javax.swing.event.CaretListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                panelAutenticacion.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                panelAutenticacion.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                panelAutenticacion.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                panelAutenticacion.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == cbxPersona) {
                panelAutenticacion.this.cbxPersonaActionPerformed(evt);
            }
        }

        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (evt.getSource() == rdbNivelUser1) {
                panelAutenticacion.this.rdbNivelUser1ItemStateChanged(evt);
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
                panelAutenticacion.this.masterTableMouseReleased(evt);
            }
        }

        public void caretUpdate(javax.swing.event.CaretEvent evt) {
            if (evt.getSource() == nivelAutenticacionField) {
                panelAutenticacion.this.nivelAutenticacionFieldCaretUpdate(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    
    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refreshMasterTable();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<sgiir.Entidades.Autenticacion> toRemove = new ArrayList<sgiir.Entidades.Autenticacion>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            sgiir.Entidades.Autenticacion a = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(a);
            entityManager.remove(a);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        
        defaultField();
        
        userAutenticacionField.enable(true);
        sgiir.Entidades.Autenticacion a = new sgiir.Entidades.Autenticacion();
        entityManager.persist(a);
        list.add(a);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
      
        
        try {
            //si esta seleccionando uno en el grid y el codigo de la primera columna es diferente de 0 hace update
            comboBox itemCombo;
            itemCombo = (comboBox) cbxPersona.getSelectedItem();
            CodigoPersona = itemCombo.getId();
            if(validaciones()){
                if(masterTable.getSelectedRow() != -1){

                    int filaSeleccionada = masterTable.getSelectedRow();

                    if(masterTable.getValueAt(filaSeleccionada, 0) != null){

                        if(SavePass != passAutenticacionField.getText()){
                           passAutenticacionField.setText(Encrypt(passAutenticacionField.getText().toUpperCase()));
                        }
                        Query = "UPDATE autenticacion SET PassAutenticacion = ?, CodigoPersona = ?, NivelAutenticacion = ? WHERE autenticacion.UserAutenticacion = '" + masterTable.getValueAt(filaSeleccionada, 0) + "'";
                            PreparedStatement ps = Conexion.prepareCall(Query);
                            //ps.setString(1, userAutenticacionField.getText());
                            ps.setString(1, Encrypt(passAutenticacionField.getText().toUpperCase()));
                            ps.setInt(2, CodigoPersona);
                            ps.setInt(3, selectNivelAutenticacion());
                            //ps.setBoolean(5, chbRecordatorio.isSelected());

                            int res = ps.executeUpdate();
                            if(res > 0){
                                refreshMasterTable();
                            }
                    }else{
                        Query = "INSERT INTO autenticacion (UserAutenticacion, PassAutenticacion, CodigoPersona, NivelAutenticacion) VALUES (?, ?, ?, ?)"; 

                        PreparedStatement ps = Conexion.prepareCall(Query);
                        ps.setString(1, userAutenticacionField.getText());
                        ps.setString(2, Encrypt(passAutenticacionField.getText().toUpperCase()));
                        ps.setInt(3, CodigoPersona);
                        ps.setInt(4, selectNivelAutenticacion());

                        int res = ps.executeUpdate();
                        if(res > 0){
                            refreshMasterTable();
                        }
                    }

                }
                
                defaultField();
            }
            statusBar.getInstance().setMsg("Operación Exitosa");
            
                //entityManager.getTransaction().commit();
                //entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<sgiir.Entidades.Autenticacion> merged = new ArrayList<sgiir.Entidades.Autenticacion>(list.size());
            for (sgiir.Entidades.Autenticacion a : list) {
                merged.add(entityManager.merge(a));
            }
            list.clear();
            list.addAll(merged);
            
            statusBar.getInstance().setMsg("Operación fallida");
        } catch (SQLException ex) {
            Logger.getLogger(panelAutenticacion.class.getName()).log(Level.SEVERE, null, ex);
            entityManager.getTransaction().begin();
            List<sgiir.Entidades.Autenticacion> merged = new ArrayList<sgiir.Entidades.Autenticacion>(list.size());
            for (sgiir.Entidades.Autenticacion a : list) {
                merged.add(entityManager.merge(a));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void nivelAutenticacionFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_nivelAutenticacionFieldCaretUpdate
        nivelAutenticacion();
    }//GEN-LAST:event_nivelAutenticacionFieldCaretUpdate

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
    
        if(masterTable.getSelectedRow() != -1){
            for (int index = 0; index < cbxPersona.getItemCount(); index++) {
                if(Integer.valueOf(codigoPersonaField.getText()) == cbxPersona.getItemAt(index).getId()){
                    cbxPersona.setSelectedIndex(index);
                }
            }
            statusBar.getInstance().clrMsg();
            
        }
    }//GEN-LAST:event_masterTableMouseReleased

    private void rdbNivelUser1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbNivelUser1ItemStateChanged

    }//GEN-LAST:event_rdbNivelUser1ItemStateChanged

    private void cbxPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPersonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPersonaActionPerformed

    private void refreshMasterTable(){
        comboPersona();
        
        SavePass = "";
        userAutenticacionField.enable(false);
        //cbxCargo.setSelectedIndex(0);
        nivelAutenticacionField.setText("0");
        
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
        
        defaultField();
    }
    private int selectNivelAutenticacion(){
        if(rdbNivelUser1.isSelected() == true){
            return 1;
        }else{
            if(rdbNivelUser2.isSelected() == true){
                return 2;
            }else{
                if(rdbNivelUser3.isSelected() == true){
                    return 3;
                }else{
                    if(rdbNivelUser4.isSelected() == true){
                        return 4;
                    }else{
                        return 0;
                    }
                }
            }
        }
    }
    
    private void comboPersona(){
        cbxPersona.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxPersona.addItem(ItemCombo);   

        TypedQuery<Persona> queryPersona = entityManager.createNamedQuery("Persona.findAll", Persona.class);
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        List<Persona> resultQueryPersona = queryPersona.getResultList();
        
        for(Persona entidad : resultQueryPersona){
            cbxPersona.addItem(entidad.getItemComboBox());
        }

    }
    
    private boolean validaciones(){
        boolean check = false;
        
        if(userAutenticacionField.getText() != ""){
            if(passAutenticacionField.getText() != ""){
                if(CodigoPersona > 0){
                   check = true;
                }else{
                    statusBar.getInstance().setMsg("Debe seleccionar una persona");
                }
            }else{
                statusBar.getInstance().setMsg("Ingrese una contraseña");
            }
        }else{
            statusBar.getInstance().setMsg("Ingrese un usuario");
        } 
               
        return check;
    }
    
    private void nivelAutenticacion(){
        switch(nivelAutenticacionField.getText()){
            //Master
            case "1":
                rdbNivelUser1.setSelected(true);
            break;
            
            //CAU
            case "2":
                rdbNivelUser2.setSelected(true);
            break;
            
            //Director
            case "3":
                rdbNivelUser3.setSelected(true);
            break;
           
            //Programador
            case "4":
                rdbNivelUser4.setSelected(true);
            break;
        }
    }
    
    private void defaultField(){
        if(cbxPersona.getItemCount() > 0){
            cbxPersona.setSelectedIndex(0);
        }
        passAutenticacionField.setText("");
        statusBar.getInstance().clrMsg();
    }
    
    //Encripta texto como la contraseña
    private static String Encrypt(String texto){
      
        return DigestUtils.md5Hex(texto); 
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<comboBox> cbxPersona;
    private javax.swing.JTextField codigoPersonaField;
    private javax.swing.JLabel codigoPersonaLabel;
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private java.util.List<sgiir.Entidades.Autenticacion> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField nivelAutenticacionField;
    private javax.swing.JLabel nivelAutenticacionLabel;
    private javax.swing.JTextField passAutenticacionField;
    private javax.swing.JLabel passAutenticacionLabel;
    private javax.persistence.Query query;
    private javax.swing.JRadioButton rdbNivelUser1;
    private javax.swing.JRadioButton rdbNivelUser2;
    private javax.swing.JRadioButton rdbNivelUser3;
    private javax.swing.JRadioButton rdbNivelUser4;
    private javax.swing.JButton refreshButton;
    private javax.swing.ButtonGroup rgrNivelAutenticacion;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField userAutenticacionField;
    private javax.swing.JLabel userAutenticacionLabel;
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
            java.util.logging.Logger.getLogger(panelAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelAutenticacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new panelAutenticacion());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
