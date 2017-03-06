/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static sgiir.manejadorDB.Conexion;

/**
 *
 * @author Alfredo Mariño
 */
public class panelReporte extends javax.swing.JPanel {
    private String ReportPath = "C:\\Users\\alfre\\Documents\\NetBeansProjects\\SGIIR\\src\\Reportes\\reporteTareasFinalizadas.jasper"; //POR DEFECTO
    
    public panelReporte() {
        initComponents();
    }
    
    public void setReporte(int Reporte) {
               
        switch(Reporte){
            case 1: //REPORTE TAREAS FINALIZADAS  
               this.ReportPath = "C:\\Users\\alfre\\Documents\\NetBeansProjects\\SGIIR\\src\\Reportes\\reporteTareasFinalizadas.jasper";
            break;
            
            case 2: //REPORTE ESTADO DE LAS TAREAS
                this.ReportPath = "C:\\Users\\alfre\\Documents\\NetBeansProjects\\SGIIR\\src\\Reportes\\reporteEstadoTarea.jasper";
            break;    
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        dchDesde = new com.toedter.calendar.JDateChooser();
        dchHasta = new com.toedter.calendar.JDateChooser();
        btnGenerar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        dchDesde.setDate(new Date());

        dchHasta.setDate(new Date());

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dchDesde, org.jdesktop.beansbinding.ELProperty.create("${date}"), dchHasta, org.jdesktop.beansbinding.BeanProperty.create("minSelectableDate"));
        bindingGroup.addBinding(binding);

        btnGenerar.setText("Generar Reporte");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        jLabel1.setText("Desde:");

        jLabel2.setText("Hasta:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(dchHasta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dchDesde, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(dchDesde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dchHasta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnGenerar)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        bindingGroup.bind();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        try {
            Map parametro = new HashMap();
            parametro.put("FECHA_DESDE",  new java.sql.Date(dchDesde.getDate().getTime()));
            parametro.put("FECHA_HASTA", new java.sql.Date(dchHasta.getDate().getTime()));
            
            JasperReport jr = null;
            jr = (JasperReport) JRLoader.loadObjectFromFile(ReportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, Conexion);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(panelReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGenerarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerar;
    private com.toedter.calendar.JDateChooser dchDesde;
    private com.toedter.calendar.JDateChooser dchHasta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
