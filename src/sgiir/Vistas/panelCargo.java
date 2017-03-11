/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import sgiir.comboBox;
import sgiir.manejadorDB;
import static sgiir.manejadorDB.Conexion;
import sgiir.propiedades.propiedades;

/**
 *
 * @author Alfredo Mariño
 */
public class panelCargo extends javax.swing.JPanel {
    
    //Manejador de base de datos
    manejadorDB DataBase = manejadorDB.getInstance(); 
    private propiedades msgFile = new propiedades();
    private propiedades qryFile = new propiedades(5);
    private String Query = "";
    private ResultSet rs;
    private ResultSet rsInstitucion;

    private int i = 0;
    private String[] columnas = {"CodigoCargo", "Cargo", "Intitución"};
    private DefaultTableModel model = new DefaultTableModel(null, columnas);

    

  
    public byte TypeUser;
    


    /**
     * Creates new form panelCargo
     */
    public panelCargo() {
        initComponents();
         
        cargaComboInstitucion();
        refreshMasterTable();
        limpiarCampos();

    }
    
    private void cargaComboInstitucion(){
       
        cbxInstitucion.removeAllItems();
                
        try {
            rsInstitucion = DataBase.executeQuery(qryFile.getProperty("qry0002"));
            i = 0;
            cbxInstitucion.addItem(new comboBox(i,""));
            i++;
            while(rsInstitucion.next()){

                cbxInstitucion.addItem(new comboBox(rsInstitucion.getInt("codigoInstitucion"), rsInstitucion.getString("nombreInstitucion")));
 
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

        jScrollPane1 = new javax.swing.JScrollPane();
        MasterTable = new javax.swing.JTable();
        cbxInstitucion = new javax.swing.JComboBox<>();
        fldDescripcion = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnRead = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        chbInforme = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        MasterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo Cargo", "Cargo", "Institución"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        MasterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        MasterTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MasterTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                MasterTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(MasterTable);

        cbxInstitucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbxInstitucionMouseClicked(evt);
            }
        });
        cbxInstitucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxInstitucionActionPerformed(evt);
            }
        });

        fldDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldDescripcionActionPerformed(evt);
            }
        });

        btnCreate.setText(msgFile.getProperty("lbl0009"));
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnRead.setText(msgFile.getProperty("lbl0016"));
        btnRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReadActionPerformed(evt);
            }
        });

        btnUpdate.setText(msgFile.getProperty("lbl0010"));
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText(msgFile.getProperty("lbl0012"));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel1.setText(msgFile.getProperty("lbl0017"));

        jLabel2.setText(msgFile.getProperty("lbl0018"));

        jLabel3.setText(msgFile.getProperty("lbl0019"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 688, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chbInforme))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCreate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRead)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(chbInforme))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRead)
                    .addComponent(btnUpdate)
                    .addComponent(btnCreate)
                    .addComponent(btnDelete))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MasterTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasterTableMouseClicked
        
    }//GEN-LAST:event_MasterTableMouseClicked

    private void cbxInstitucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxInstitucionActionPerformed
        
    }//GEN-LAST:event_cbxInstitucionActionPerformed

    private void cbxInstitucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxInstitucionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxInstitucionMouseClicked

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        comboBox datoCombo =(comboBox) cbxInstitucion.getSelectedItem();

        try {
            Query = "INSERT INTO cargo (CodigoCargo, DescripcionCargo, CodigoInstitucion, InformeCargo) VALUES (NULL, ?, ?, ?)";
            PreparedStatement ps = Conexion.prepareCall(Query);
            ps.setString(1, fldDescripcion.getText());
            ps.setInt(2, datoCombo.getId());
            ps.setBoolean(3, chbInforme.isSelected());
            
            int res = ps.executeUpdate();
            if(res > 0){
                refreshMasterTable();
                limpiarCampos();
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReadActionPerformed
        refreshMasterTable();
        limpiarCampos();
    }//GEN-LAST:event_btnReadActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        comboBox datoCombo =(comboBox) cbxInstitucion.getSelectedItem();

        try {
            if(MasterTable.getSelectedRow() != -1){

                Query = "UPDATE cargo SET DescripcionCargo = ?, CodigoInstitucion = ?, InformeCargo = ? WHERE cargo.CodigoCargo = " + MasterTable.getValueAt(MasterTable.getSelectedRow(), 0).toString();
                PreparedStatement ps = Conexion.prepareCall(Query);
                ps.setString(1, fldDescripcion.getText());
                ps.setInt(2, datoCombo.getId());
                ps.setBoolean(3, chbInforme.isSelected());
                //ps.setInt(4, (int) MasterTable.getValueAt(MasterTable.getSelectedRow(), 0));

                int res = ps.executeUpdate();
                if(res > 0){
                    refreshMasterTable();
                    limpiarCampos();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        Query = "DELETE FROM cargo WHERE cargo.CodigoCargo = " + MasterTable.getValueAt(MasterTable.getSelectedRow(), 0).toString();
        if(DataBase.executeUpdate(Query)){
            refreshMasterTable();
            limpiarCampos();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void MasterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MasterTableMouseReleased
        if(evt.getButton()==1){
            int filaSeleccionada = MasterTable.getSelectedRow();
            try{
                //habilitar
                Query = "select a.*, b.NombreInstitucion from cargo a, institucion b where a.CodigoInstitucion = b.CodigoInstitucion and a.codigoCargo = " + MasterTable.getValueAt(filaSeleccionada, 0);
                rs = DataBase.executeQuery(Query);
                rs.next();
                fldDescripcion.setText(rs.getString("descripcionCargo"));
                chbInforme.setSelected(rs.getBoolean("informeCargo"));
                
                cbxInstitucion.setSelectedItem(new comboBox(rs.getInt("codigoInstitucion"), rs.getString("NombreInstitucion")));
                
            } catch (SQLException ex) {
                Logger.getLogger(panelCargo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_MasterTableMouseReleased

    private void fldDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fldDescripcionActionPerformed
    
    private void limpiarCampos(){
        fldDescripcion.setText("");
        cbxInstitucion.setSelectedIndex(0);
        chbInforme.setSelected(false);
    }
    
    private void refreshMasterTable(){
        
        model.setRowCount(0);
        String[] fila = new String[3];
        
        try {
            Query = qryFile.getProperty("qry0003");
            rs = DataBase.executeQuery(Query);
            while(rs.next()){
                fila[0] = rs.getString("codigoCargo");
                fila[1] = rs.getString("descripcionCargo");
                fila[2] = rs.getString("NombreInstitucion");

                model.addRow(fila);
            }
            MasterTable.setModel(model);
            MasterTable.getColumnModel().getColumn(0).setMaxWidth(0);
            MasterTable.getColumnModel().getColumn(0).setMinWidth(0);
            MasterTable.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
            MasterTable.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
            
        } catch (SQLException ex) {
            Logger.getLogger(panelCargo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable MasterTable;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnRead;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<comboBox> cbxInstitucion;
    private javax.swing.JCheckBox chbInforme;
    private javax.swing.JTextField fldDescripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
