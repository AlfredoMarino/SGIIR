/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.awt.EventQueue;
import java.beans.Beans;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sgiir.Entidades.Institucion;
import sgiir.Entidades.Naturaleza;
import sgiir.Entidades.Seguimiento;
import sgiir.Entidades.Tarea;
import sgiir.comboBox;
import sgiir.statusBar;

/**
 *
 * @author Alfredo Mariño
 */
public class panelTarea4 extends JPanel {
    int codigoSeguimiento;
    Tarea tareaSeleccionada;
    Seguimiento s;
    Naturaleza n;
    Date fechaRecepcionTarea;
    Date horaRecepcionTarea;
    Date fechaEstimadaTarea;
    Date horaEstimadaTarea;
    String carpetaTarea;
    String observacionTarea;
    Date fechaFinalizacionTarea;
    Date horaFinalizacionTarea;
    String descripcionTarea;
    int codigoTarea;
    int codigoNaturaleza ;
    int tipoNaturaleza;
    int prioridadNaturaleza;
    int codigoInstitucion;
    
    public panelTarea4() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        
        comboInstitucion();
        
        list.clear();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SGIIRPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT t FROM Tarea t");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        codigoNaturalezaField = new javax.swing.JTextField();
        codigoSeguimientoField = new javax.swing.JTextField();
        rgrPrioridad = new javax.swing.ButtonGroup();
        rgrTipo = new javax.swing.ButtonGroup();
        queryInstitucion = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Institucion i");
        listInstitucion = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryInstitucion.getResultList());
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        codigoTareaLabel = new javax.swing.JLabel();
        descripcionTareaLabel = new javax.swing.JLabel();
        codigoSeguimientoLabel = new javax.swing.JLabel();
        fechaRecepcionTareaLabel = new javax.swing.JLabel();
        fechaEstimadaTareaLabel = new javax.swing.JLabel();
        carpetaTareaLabel = new javax.swing.JLabel();
        observacionTareaLabel = new javax.swing.JLabel();
        fechaFinalizacionTareaLabel = new javax.swing.JLabel();
        codigoTareaField = new javax.swing.JTextField();
        carpetaTareaField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        cbxInstitucion = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        rdbPrioridad3 = new javax.swing.JRadioButton();
        rdbPrioridad2 = new javax.swing.JRadioButton();
        rdbTipo2 = new javax.swing.JRadioButton();
        rdbTipo1 = new javax.swing.JRadioButton();
        rdbPrioridad1 = new javax.swing.JRadioButton();
        cbtTodos = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        fldDescripcion = new javax.swing.JTextArea();
        cbxSeguimiento = new javax.swing.JComboBox<>();
        dchRecepcion = new com.toedter.calendar.JDateChooser();
        spnHoraRecepcion = new javax.swing.JSpinner();
        dchEstimada = new com.toedter.calendar.JDateChooser();
        spnHoraEstimada = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        fldObservacion = new javax.swing.JTextArea();
        dchFinalizacion = new com.toedter.calendar.JDateChooser();
        spnHoraFinalizacion = new javax.swing.JSpinner();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstArea = new javax.swing.JList<>();
        btnCaracteristica = new javax.swing.JButton();
        btnInvolucrado = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        FormListener formListener = new FormListener();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoNaturaleza.codigoNaturaleza}"), codigoNaturalezaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), codigoNaturalezaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoSeguimiento.codigoSeguimiento}"), codigoSeguimientoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), codigoSeguimientoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        rgrPrioridad.add(rdbPrioridad1);
        rgrPrioridad.add(rdbPrioridad2);
        rgrPrioridad.add(rdbPrioridad3);

        rgrTipo.add(rdbTipo1);
        rgrTipo.add(rdbTipo2);

        masterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoSeguimiento.codigoSeguimiento}"));
        columnBinding.setColumnName("Codigo Seguimiento");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoTarea}"));
        columnBinding.setColumnName("Codigo Tarea");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcionTarea}"));
        columnBinding.setColumnName("Descripcion Tarea");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaRecepcionTarea}"));
        columnBinding.setColumnName("Fecha Recepcion Tarea");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaEstimadaTarea}"));
        columnBinding.setColumnName("Fecha Estimada Tarea");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaFinalizacionTarea}"));
        columnBinding.setColumnName("Fecha Finalizacion Tarea");
        columnBinding.setColumnClass(java.util.Date.class);
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
            masterTable.getColumnModel().getColumn(5).setResizable(false);
        }

        codigoTareaLabel.setText("Codigo Tarea:");

        descripcionTareaLabel.setText("Descripcion Tarea:");

        codigoSeguimientoLabel.setText("Codigo Seguimiento:");

        fechaRecepcionTareaLabel.setText("Fecha Recepcion Tarea:");

        fechaEstimadaTareaLabel.setText("Fecha Estimada Tarea:");

        carpetaTareaLabel.setText("Carpeta Tarea:");

        observacionTareaLabel.setText("Observacion Tarea:");

        fechaFinalizacionTareaLabel.setText("Fecha Finalizacion Tarea:");

        codigoTareaField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoTarea}"), codigoTareaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), codigoTareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.carpetaTarea}"), carpetaTareaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != ' '}"), carpetaTareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
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

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(formListener);

        rdbPrioridad3.setText("Alta");
        rdbPrioridad3.addActionListener(formListener);

        rdbPrioridad2.setText("Media");
        rdbPrioridad2.addActionListener(formListener);

        rdbTipo2.setText("Requerimiento");

        rdbTipo1.setSelected(true);
        rdbTipo1.setText("Incidencia");
        rdbTipo1.addActionListener(formListener);

        rdbPrioridad1.setSelected(true);
        rdbPrioridad1.setText("Baja");
        rdbPrioridad1.addActionListener(formListener);

        cbtTodos.setText("Todos");
        cbtTodos.addItemListener(formListener);
        cbtTodos.addChangeListener(formListener);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbTipo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbTipo2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addComponent(rdbPrioridad1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbPrioridad2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbPrioridad3)
                .addGap(80, 80, 80)
                .addComponent(cbtTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbTipo1)
                        .addComponent(rdbTipo2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbPrioridad1)
                        .addComponent(rdbPrioridad2)
                        .addComponent(rdbPrioridad3)
                        .addComponent(btnBuscar)
                        .addComponent(cbtTodos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        fldDescripcion.setColumns(20);
        fldDescripcion.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.descripcionTarea}"), fldDescripcion, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(fldDescripcion);

        cbxSeguimiento.addItemListener(formListener);
        cbxSeguimiento.addMouseListener(formListener);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaRecepcionTarea}"), dchRecepcion, org.jdesktop.beansbinding.BeanProperty.create("date"));
        bindingGroup.addBinding(binding);

        spnHoraRecepcion.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        spnHoraRecepcion.setEditor(new javax.swing.JSpinner.DateEditor(spnHoraRecepcion, "HH:mm:ss"));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.horaRecepcionTarea}"), spnHoraRecepcion, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaEstimadaTarea}"), dchEstimada, org.jdesktop.beansbinding.BeanProperty.create("date"));
        bindingGroup.addBinding(binding);

        spnHoraEstimada.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        spnHoraEstimada.setEditor(new javax.swing.JSpinner.DateEditor(spnHoraEstimada, "HH:mm:ss"));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.horaEstimadaTarea}"), spnHoraEstimada, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        fldObservacion.setColumns(20);
        fldObservacion.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.observacionTarea}"), fldObservacion, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(fldObservacion);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaFinalizacionTarea}"), dchFinalizacion, org.jdesktop.beansbinding.BeanProperty.create("date"));
        bindingGroup.addBinding(binding);

        spnHoraFinalizacion.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        spnHoraFinalizacion.setEditor(new javax.swing.JSpinner.DateEditor(spnHoraFinalizacion, "HH:mm:ss"));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.horaFinalizacionTarea}"), spnHoraFinalizacion, org.jdesktop.beansbinding.BeanProperty.create("value"));
        bindingGroup.addBinding(binding);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.caracteristicaCollection}");
        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, eLProperty, lstArea);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${area.nombreArea}"));
        bindingGroup.addBinding(jListBinding);

        jScrollPane3.setViewportView(lstArea);

        btnCaracteristica.setText("Agregar area:");
        btnCaracteristica.addActionListener(formListener);

        btnInvolucrado.setText("Agregar involucrados");
        btnInvolucrado.addActionListener(formListener);

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.involucradoCollection}");
        jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, eLProperty, jList1);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${persona.itemComboBox.descripcion}"));
        bindingGroup.addBinding(jListBinding);

        jScrollPane4.setViewportView(jList1);

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
                            .addComponent(masterScrollPane)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(descripcionTareaLabel)
                                    .addComponent(codigoSeguimientoLabel)
                                    .addComponent(fechaRecepcionTareaLabel)
                                    .addComponent(fechaEstimadaTareaLabel)
                                    .addComponent(carpetaTareaLabel)
                                    .addComponent(observacionTareaLabel)
                                    .addComponent(fechaFinalizacionTareaLabel)
                                    .addComponent(codigoTareaLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dchFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(spnHoraFinalizacion))
                                    .addComponent(carpetaTareaField)
                                    .addComponent(jScrollPane1)
                                    .addComponent(codigoTareaField)
                                    .addComponent(cbxSeguimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(dchRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dchEstimada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(spnHoraRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                            .addComponent(spnHoraEstimada)))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnInvolucrado)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCaracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoTareaLabel)
                            .addComponent(codigoTareaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(descripcionTareaLabel))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoSeguimientoLabel)
                            .addComponent(cbxSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaRecepcionTareaLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spnHoraRecepcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dchRecepcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaEstimadaTareaLabel)
                            .addComponent(dchEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnHoraEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carpetaTareaLabel)
                            .addComponent(carpetaTareaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(observacionTareaLabel)
                                .addGap(54, 54, 54))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(6, 6, 6)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaFinalizacionTareaLabel)
                            .addComponent(dchFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnHoraFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCaracteristica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInvolucrado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.ItemListener, java.awt.event.MouseListener, javax.swing.event.ChangeListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                panelTarea4.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                panelTarea4.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                panelTarea4.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                panelTarea4.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == btnBuscar) {
                panelTarea4.this.btnBuscarActionPerformed(evt);
            }
            else if (evt.getSource() == rdbPrioridad3) {
                panelTarea4.this.rdbPrioridad3ActionPerformed(evt);
            }
            else if (evt.getSource() == rdbPrioridad2) {
                panelTarea4.this.rdbPrioridad2ActionPerformed(evt);
            }
            else if (evt.getSource() == rdbTipo1) {
                panelTarea4.this.rdbTipo1ActionPerformed(evt);
            }
            else if (evt.getSource() == rdbPrioridad1) {
                panelTarea4.this.rdbPrioridad1ActionPerformed(evt);
            }
            else if (evt.getSource() == btnCaracteristica) {
                panelTarea4.this.btnCaracteristicaActionPerformed(evt);
            }
            else if (evt.getSource() == btnInvolucrado) {
                panelTarea4.this.btnInvolucradoActionPerformed(evt);
            }
        }

        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (evt.getSource() == cbxSeguimiento) {
                panelTarea4.this.cbxSeguimientoItemStateChanged(evt);
            }
            else if (evt.getSource() == cbtTodos) {
                panelTarea4.this.cbtTodosItemStateChanged(evt);
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
                panelTarea4.this.masterTableMouseReleased(evt);
            }
            else if (evt.getSource() == cbxSeguimiento) {
                panelTarea4.this.cbxSeguimientoMouseReleased(evt);
            }
        }

        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            if (evt.getSource() == cbtTodos) {
                panelTarea4.this.cbtTodosStateChanged(evt);
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
        List<sgiir.Entidades.Tarea> toRemove = new ArrayList<sgiir.Entidades.Tarea>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            sgiir.Entidades.Tarea t = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(t);
            entityManager.remove(t);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        sgiir.Entidades.Tarea t = new sgiir.Entidades.Tarea();
        entityManager.persist(t);
        list.add(t);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            
            
            comboBox itemCombo;
            itemCombo = (comboBox) cbxSeguimiento.getSelectedItem();
            codigoSeguimiento = itemCombo.getId();
            

            int[] selected = masterTable.getSelectedRows();
            List<Tarea> toMerged = new ArrayList<Tarea>(selected.length);
            for (int idx = 0; idx < selected.length; idx++) {
                Tarea t = list.get(masterTable.convertRowIndexToModel(selected[idx]));
                /*i.setInvolucradoPK(new InvolucradoPK(CodigoNaturaleza, CodigoTarea, CodigoInvolucrado, CodigoPersona));
                i.setTarea(new Tarea(CodigoTarea));
                i.setNaturaleza(new Naturaleza(CodigoNaturaleza));
                i.setPersona(new Persona(CodigoPersona));
                */
                toMerged.add(t);

                entityManager.merge(t);
            }
            
            
            
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<sgiir.Entidades.Tarea> merged = new ArrayList<sgiir.Entidades.Tarea>(list.size());
            for (sgiir.Entidades.Tarea t : list) {
                merged.add(entityManager.merge(t));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try{
        
            if(cbtTodos.isSelected()){

                query = entityManager.createNamedQuery("Tarea.findAll");
                        
                java.util.Collection data = query.getResultList();
                for (Object entity : data) {
                    entityManager.refresh(entity);
                }
                list.clear();
                list.addAll(data);

                comboSeguimiento();
                
            }else{
                comboBox combo = (comboBox) cbxInstitucion.getSelectedItem();
                if(combo.getId() != 0){
                    this.codigoInstitucion = combo.getId();
                    if(rdbTipo1.isSelected()){
                        this.tipoNaturaleza = 1; //INCIDENCIA
                    }else{
                        this.tipoNaturaleza = 0; //REQUERIMIENTO
                    }

                    if(rdbPrioridad1.isSelected()){
                        this.prioridadNaturaleza = 1; //Baja
                    }else{
                        if(rdbPrioridad2.isSelected()){
                            this.prioridadNaturaleza = 2; //Media
                        }else{
                            this.prioridadNaturaleza = 3; //Alta
                        }
                    }

                        javax.persistence.Query queryNaturaleza = entityManager.createNativeQuery("SELECT * FROM Naturaleza where CodigoInstitucion = ? and TipoNaturaleza = ? and PrioridadNaturaleza = ?", Naturaleza.class);

                        queryNaturaleza.setParameter(1, codigoInstitucion);
                        queryNaturaleza.setParameter(2, tipoNaturaleza);
                        queryNaturaleza.setParameter(3, prioridadNaturaleza);

                        entityManager.getTransaction().rollback();
                        entityManager.getTransaction().begin();

                        this.n = (Naturaleza) queryNaturaleza.getSingleResult();
                        this.codigoNaturaleza = n.getCodigoNaturaleza();

                        query = entityManager.createNativeQuery("SELECT * FROM Tarea WHERE CodigoNaturaleza = ?", Tarea.class);
                        query.setParameter(1, codigoNaturaleza);

                        java.util.Collection data = query.getResultList();
                        for (Object entity : data) {
                            entityManager.refresh(entity);
                        }
                        list.clear();
                        list.addAll(data);

                        comboSeguimiento();

                }else{
                    statusBar.getInstance().setMsg("Debe selecionar una institución");
                }
            }
        }catch(javax.persistence.NoResultException nre){
            statusBar.getInstance().setMsg("No se encontraron tareas");
            list.clear();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void rdbPrioridad3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPrioridad3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbPrioridad3ActionPerformed

    private void rdbPrioridad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPrioridad2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbPrioridad2ActionPerformed

    private void rdbTipo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbTipo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbTipo1ActionPerformed

    private void rdbPrioridad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbPrioridad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbPrioridad1ActionPerformed

    private void cbxSeguimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSeguimientoItemStateChanged

    }//GEN-LAST:event_cbxSeguimientoItemStateChanged

    private void cbxSeguimientoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxSeguimientoMouseReleased

    }//GEN-LAST:event_cbxSeguimientoMouseReleased

    private void btnCaracteristicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaracteristicaActionPerformed
        if(masterTable.getSelectedRow() != -1){
            framePopup vistaCaracteristica = new framePopup();
            vistaCaracteristica.pnlCaracteristica.setCaracteristica(codigoNaturaleza, codigoTarea);
            vistaCaracteristica.showPanel("CARACTERISTICA");
            vistaCaracteristica.setVisible(true);
        }
    }//GEN-LAST:event_btnCaracteristicaActionPerformed

    private void btnInvolucradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvolucradoActionPerformed
        if(masterTable.getSelectedRow() != -1){
            framePopup vistaInvolucrado = new framePopup();
            vistaInvolucrado.pnlInvolucrado.setInvolucrado(codigoNaturaleza, codigoTarea, 0);
            vistaInvolucrado.showPanel("INVOLUCRADO");
            vistaInvolucrado.setVisible(true);
            
        }
    }//GEN-LAST:event_btnInvolucradoActionPerformed

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        if(masterTable.getSelectedRow() != -1){
            comboSeguimiento();
            
            for (int index = 0; index < cbxSeguimiento.getItemCount(); index++) {
                if(Integer.valueOf(codigoSeguimientoField.getText()) == cbxSeguimiento.getItemAt(index).getId()){
                    cbxSeguimiento.setSelectedIndex(index);
                }
            }
            seteaCampos();
            
            
        }
    }//GEN-LAST:event_masterTableMouseReleased

    private void cbtTodosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbtTodosStateChanged
       
    }//GEN-LAST:event_cbtTodosStateChanged

    private void cbtTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbtTodosItemStateChanged
         cbxInstitucion.setSelectedIndex(0);
        
        if(cbtTodos.isSelected()){
            
            cbxInstitucion.setEnabled(false);
            
            rdbTipo1.setSelected(false);
            rdbTipo1.setEnabled(false);
            
            rdbTipo2.setSelected(false);
            rdbTipo2.setEnabled(false);
            
            rdbPrioridad1.setSelected(false);
            rdbPrioridad1.setEnabled(false);
            
            rdbPrioridad2.setSelected(false);
            rdbPrioridad2.setEnabled(false);
            
            rdbPrioridad3.setSelected(false);
            rdbPrioridad3.setEnabled(false);
            
            newButton.setEnabled(false);
                      
        }else{
            cbxInstitucion.setEnabled(true);
            
            rdbTipo1.setSelected(true);
            rdbTipo1.setEnabled(true);
            
            rdbTipo2.setSelected(false);
            rdbTipo2.setEnabled(true);
            
            rdbPrioridad1.setSelected(true);
            rdbPrioridad1.setEnabled(true);
            
            rdbPrioridad2.setSelected(false);
            rdbPrioridad2.setEnabled(true);
            
            rdbPrioridad3.setSelected(false);
            rdbPrioridad3.setEnabled(true);
            
            newButton.setEnabled(true);
        }
    }//GEN-LAST:event_cbtTodosItemStateChanged
    private void comboSeguimiento(){
        cbxSeguimiento.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxSeguimiento.addItem(ItemCombo);   

        if(this.isNumeric(codigoNaturalezaField.getText())){

            sgiir.Entidades.Naturaleza n = (Naturaleza) entityManager.find(Naturaleza.class, Integer.valueOf(codigoNaturalezaField.getText()));

            for(Seguimiento entidad : n.getSeguimientoCollection()){

                cbxSeguimiento.addItem(entidad.getItemComboBox()); 
            }
        }
    }
    
    private void comboInstitucion(){
        cbxInstitucion.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxInstitucion.addItem(ItemCombo);   
        
        for(Institucion entidad : listInstitucion){

            cbxInstitucion.addItem(new comboBox(entidad.getCodigoInstitucion(), entidad.getNombreInstitucion()));
            
        }
    }
    
    private void clearAll(){
        
        statusBar.getInstance().clrMsg();
        list.clear(); 
        cbxSeguimiento.setSelectedIndex(0);
        
        fldDescripcion.setText("");
        
        codigoSeguimiento = 0;
        descripcionTarea = fldDescripcion.getText();
        fechaRecepcionTarea = dchRecepcion.getDate();
        horaRecepcionTarea = (Date) spnHoraRecepcion.getValue();
        fechaEstimadaTarea = dchEstimada.getDate();
        horaEstimadaTarea = (Date) spnHoraEstimada.getValue();
        carpetaTarea = carpetaTareaField.getText();
        observacionTarea = fldObservacion.getText();
        fechaFinalizacionTarea = dchFinalizacion.getDate();
        horaFinalizacionTarea = (Date) spnHoraFinalizacion.getValue();
    }
    
    private void seteaCampos(){
        
        if(this.isNumeric(codigoNaturalezaField.getText())){
            codigoNaturaleza = Integer.parseInt(codigoNaturalezaField.getText());
        }else{
            codigoNaturaleza = 0;
        }

        if(this.isNumeric(codigoTareaField.getText())){
            codigoTarea = Integer.parseInt(codigoTareaField.getText());
        }else{
            codigoTarea = 0;
        }
        
        comboBox itemCombo;
        itemCombo = (comboBox) cbxSeguimiento.getSelectedItem();
        codigoSeguimiento = itemCombo.getId();
        descripcionTarea = fldDescripcion.getText();
        fechaRecepcionTarea = dchRecepcion.getDate();
        horaRecepcionTarea = (Date) spnHoraRecepcion.getValue();
        fechaEstimadaTarea = dchEstimada.getDate();
        horaEstimadaTarea = (Date) spnHoraEstimada.getValue();
        carpetaTarea = carpetaTareaField.getText();
        observacionTarea = fldObservacion.getText();
        fechaFinalizacionTarea = dchFinalizacion.getDate();
        horaFinalizacionTarea = (Date) spnHoraFinalizacion.getValue();
    }
    private static boolean isNumeric(String cadena){
	try {
            Integer.parseInt(cadena);
            return true;
	} catch (NumberFormatException nfe){
            return false;
	}
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCaracteristica;
    private javax.swing.JButton btnInvolucrado;
    private javax.swing.JTextField carpetaTareaField;
    private javax.swing.JLabel carpetaTareaLabel;
    private javax.swing.JCheckBox cbtTodos;
    private javax.swing.JComboBox<comboBox> cbxInstitucion;
    private javax.swing.JComboBox<comboBox> cbxSeguimiento;
    private javax.swing.JTextField codigoNaturalezaField;
    private javax.swing.JTextField codigoSeguimientoField;
    private javax.swing.JLabel codigoSeguimientoLabel;
    private javax.swing.JTextField codigoTareaField;
    private javax.swing.JLabel codigoTareaLabel;
    private com.toedter.calendar.JDateChooser dchEstimada;
    private com.toedter.calendar.JDateChooser dchFinalizacion;
    private com.toedter.calendar.JDateChooser dchRecepcion;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descripcionTareaLabel;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel fechaEstimadaTareaLabel;
    private javax.swing.JLabel fechaFinalizacionTareaLabel;
    private javax.swing.JLabel fechaRecepcionTareaLabel;
    private javax.swing.JTextArea fldDescripcion;
    private javax.swing.JTextArea fldObservacion;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.util.List<sgiir.Entidades.Tarea> list;
    private java.util.List<Institucion> listInstitucion;
    private javax.swing.JList<String> lstArea;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel observacionTareaLabel;
    private javax.persistence.Query query;
    private javax.persistence.Query queryInstitucion;
    private javax.swing.JRadioButton rdbPrioridad1;
    private javax.swing.JRadioButton rdbPrioridad2;
    private javax.swing.JRadioButton rdbPrioridad3;
    private javax.swing.JRadioButton rdbTipo1;
    private javax.swing.JRadioButton rdbTipo2;
    private javax.swing.JButton refreshButton;
    private javax.swing.ButtonGroup rgrPrioridad;
    private javax.swing.ButtonGroup rgrTipo;
    private javax.swing.JButton saveButton;
    private javax.swing.JSpinner spnHoraEstimada;
    private javax.swing.JSpinner spnHoraFinalizacion;
    private javax.swing.JSpinner spnHoraRecepcion;
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
            java.util.logging.Logger.getLogger(panelTarea4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelTarea4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelTarea4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelTarea4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new panelTarea4());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
