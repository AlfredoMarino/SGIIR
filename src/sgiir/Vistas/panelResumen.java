/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

/**
 *
 * @author Alfredo Mariño
 */
public class panelResumen extends javax.swing.JPanel {

    /**
     * Creates new form resumen
     */
    public panelResumen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SGIIRPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SGIIRPU").createEntityManager();
        areaQuery = java.beans.Beans.isDesignTime() ? null : SGIIRPUEntityManager.createQuery("SELECT a FROM Area a");
        areaList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : areaQuery.getResultList();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager SGIIRPUEntityManager;
    private java.util.List<sgiir.Entidades.Area> areaList;
    private javax.persistence.Query areaQuery;
    // End of variables declaration//GEN-END:variables
}
