/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListModel;
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

        buttonGroup1.add(rdb1);
        buttonGroup1.add(rdb2);
        buttonGroup1.add(rdb3);

        jScrollPane1.setViewportView(listView);

        rdb1.setText("Especialista en el área");

        rdb2.setText("Desocupado");

        rdb3.setText("Ambos");

        btnBusqueda.setText("Buscar");
        btnBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdb1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdb2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdb3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBusqueda)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdb1)
                    .addComponent(rdb2)
                    .addComponent(rdb3)
                    .addComponent(btnBusqueda))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBusquedaActionPerformed
        DefaultListModel<String> listPersona = new DefaultListModel<>();  
        
        //Especialista en el area
        if(rdb1.isSelected()){
            listaSugerencia = sugerencia.programadorEspecialistaSugerido(CodigoNaturaleza, CodigoTarea);
            listaSugerencia.sort(Comparator.comparing(Persona::getMatch).reversed());//mayor a menor
        }else{
            //Programador disponible
            if(rdb2.isSelected()){
                listaSugerencia = sugerencia.programadorDisponible();
                listaSugerencia.sort(Comparator.comparing(Persona::getMatch).reversed());//mayor a menor
            }else{//ambos
                sugerencia.ambosFiltros(CodigoNaturaleza, CodigoTarea);
            } 
        }
        
        for(Sugerencia.Persona p : listaSugerencia){
            listPersona.addElement(p.nombrePersona + aciertos(p.match));
            System.out.println(p.codigoPersona + " " + p.nombrePersona + " " + p.match);
        }
        listView.setModel(listPersona);
    }//GEN-LAST:event_btnBusquedaActionPerformed
    
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
    private javax.swing.JRadioButton rdb1;
    private javax.swing.JRadioButton rdb2;
    private javax.swing.JRadioButton rdb3;
    // End of variables declaration//GEN-END:variables
}
