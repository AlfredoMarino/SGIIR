/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import sgiir.Sugerencia;
import sgiir.Sugerencia.Persona;

/**
 *
 * @author Alfredo Mariño
 */
public class panelSugerencia extends javax.swing.JPanel {

    List<Integer> listaAreas = new ArrayList<>();
    Sugerencia sugerencia = new Sugerencia();
    List<Sugerencia.Persona> listaSugerencia;
    List<String> listPersona;
    int CodigoNaturaleza, CodigoTarea;
    ChartPanel chartPanel;
    
    public panelSugerencia() {
        initComponents();
    }

    public void setAreas(List<Integer> areas){
        this.listaAreas = areas;
    }
    
    public void setParametros(int naturaleza, int tarea){
        this.CodigoNaturaleza = naturaleza;
        this.CodigoTarea = tarea;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        listView = new javax.swing.JList<>();
        rdb1 = new javax.swing.JRadioButton();
        rdb2 = new javax.swing.JRadioButton();
        rdb3 = new javax.swing.JRadioButton();
        btnBusqueda = new javax.swing.JButton();
        pnlGrafico = new javax.swing.JPanel();

        buttonGroup1.add(rdb1);
        buttonGroup1.add(rdb2);
        buttonGroup1.add(rdb3);

        addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
                formAncestorResized(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jScrollPane1.setViewportView(listView);

        rdb1.setText("Especialista en el área");

        rdb2.setSelected(true);
        rdb2.setText("Desocupado");

        rdb3.setText("Ambos");

        btnBusqueda.setText("Buscar");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGraficoLayout = new javax.swing.GroupLayout(pnlGrafico);
        pnlGrafico.setLayout(pnlGraficoLayout);
        pnlGraficoLayout.setHorizontalGroup(
            pnlGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlGraficoLayout.setVerticalGroup(
            pnlGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdb3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(btnBusqueda))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlGrafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBusqueda)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdb2)
                        .addComponent(rdb1)
                        .addComponent(rdb3)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        DefaultListModel<String> listPersona = new DefaultListModel<>();  
        
        //Especialista en el area
        if(rdb1.isSelected()){
            listaSugerencia = sugerencia.programadorEspecialistaSugerido(CodigoNaturaleza, CodigoTarea);
        }else{
            //Programador disponible
            if(rdb2.isSelected()){
                listaSugerencia = sugerencia.programadorDisponible();
            }else{//ambos
                listaSugerencia = sugerencia.ambosFiltros(CodigoNaturaleza, CodigoTarea);
            } 
        }
        
        listaSugerencia.sort(Comparator.comparing(Persona::getMatch).reversed());//mayor a menor
        
        for(Sugerencia.Persona p : listaSugerencia){
            listPersona.addElement(p.nombrePersona + aciertos(p.match));
        }
        listView.setModel(listPersona);
        
        
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(Sugerencia.Persona p : listaSugerencia){
            dataSet.setValue(p.match, "Nivel", p.nombrePersona);
            
        }
        
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart
        ("Programador sugerido","programador", "", 
        dataSet, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.WHITE);
        chart.getTitle().setPaint(Color.black); 
//        CategoryPlot cp = chart.getCategoryPlot(); 
//        cp.setRangeGridlinePaint(Color.red); 
        // Mostrar Grafico
        
        chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(pnlGrafico.getSize()));
        //chartPanel.setDomainZoomable(true);
        pnlGrafico.setLayout(new BorderLayout());
        pnlGrafico.add(chartPanel, BorderLayout.CENTER);
        this.validate();
//        pnlGrafico.repaint();
//        
//        // Mostrar Grafico
//        ChartFrame frame = new ChartFrame("JFreeChart", chart);
//        frame.pack();
//        frame.setVisible(true);
        
    }//GEN-LAST:event_btnBusquedaActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        refreshGraphic();
    }//GEN-LAST:event_formComponentResized

    private void formAncestorResized(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_formAncestorResized
        refreshGraphic();
    }//GEN-LAST:event_formAncestorResized
    
    private void refreshGraphic(){
        if(chartPanel != null){
            chartPanel.setPreferredSize(new java.awt.Dimension(pnlGrafico.getSize()));
            chartPanel.setDomainZoomable(true);
            pnlGrafico.setLayout(new BorderLayout());
            pnlGrafico.add(chartPanel, BorderLayout.CENTER);
        }
        this.validate();
    }
    
    private String aciertos(int match){
        String estrellas = " ";
        
        int i = 0;
        while(i < match){
            estrellas += "*";
            i++;
        }
        
        return estrellas;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBusqueda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listView;
    private javax.swing.JPanel pnlGrafico;
    private javax.swing.JRadioButton rdb1;
    private javax.swing.JRadioButton rdb2;
    private javax.swing.JRadioButton rdb3;
    // End of variables declaration//GEN-END:variables
}
