/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.awt.EventQueue;
import java.beans.Beans;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.DefaultListCellRenderer.UIResource;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.SwingConstants;
import sgiir.Entidades.Institucion;
import sgiir.Entidades.Involucrado;
import sgiir.Entidades.Naturaleza;
import sgiir.Entidades.Seguimiento;
import sgiir.Entidades.Tarea;
import sgiir.comboBox;
import sgiir.propiedades.propiedades;
import sgiir.statusBar;

/**
 *
 * @author Alfredo Mariño
 */
public class panelTarea extends JPanel {
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
    Date dateDefault;
    private propiedades msgFile = new propiedades();
    //POSICION DE LOS ITEMS EN LAS LISTAS
    UIResource posicion = new UIResource();
    
    public panelTarea() {
        //prepara una fecha en cero
        Calendar calendarDefault = Calendar.getInstance();
        calendarDefault.set(Calendar.HOUR_OF_DAY, 0);
        calendarDefault.set(Calendar.MINUTE, 0);
        calendarDefault.set(Calendar.SECOND, 0);
        dateDefault = calendarDefault.getTime();
        
        
        //se alinean las celdas a la izquierda
        posicion.setHorizontalAlignment(SwingConstants.CENTER);
        
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
        queryInstitucion = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Institucion i");
        listInstitucion = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryInstitucion.getResultList());
        codigoSeguimientoField = new javax.swing.JTextField();
        rgrTipo = new javax.swing.ButtonGroup();
        rgrPrioridad = new javax.swing.ButtonGroup();
        descripcionTareaField = new javax.swing.JTextField();
        fechaRecepcionTareaField = new javax.swing.JTextField();
        horaRecepcionTareaField = new javax.swing.JTextField();
        fechaEstimadaTareaField = new javax.swing.JTextField();
        fechaFinalizacionTareaField = new javax.swing.JTextField();
        fchCarpetaTarea = new javax.swing.JFileChooser();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        codigoNaturalezaLabel = new javax.swing.JLabel();
        codigoTareaLabel = new javax.swing.JLabel();
        descripcionTareaLabel = new javax.swing.JLabel();
        codigoSeguimientoLabel = new javax.swing.JLabel();
        fechaRecepcionTareaLabel = new javax.swing.JLabel();
        fechaEstimadaTareaLabel = new javax.swing.JLabel();
        carpetaTareaLabel = new javax.swing.JLabel();
        observacionTareaLabel = new javax.swing.JLabel();
        fechaFinalizacionTareaLabel = new javax.swing.JLabel();
        codigoNaturalezaField = new javax.swing.JTextField();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbxSeguimiento = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        fldDescripcion = new javax.swing.JTextArea();
        spnHoraRecepcion = new javax.swing.JSpinner();
        dchRecepcion = new com.toedter.calendar.JDateChooser();
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
        lstInvolucrado = new javax.swing.JList<>();
        btnRutaCarpeta = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoSeguimiento.codigoSeguimiento}"), codigoSeguimientoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), codigoSeguimientoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        rgrTipo.add(rdbTipo1);
        rgrTipo.add(rdbTipo2);

        rgrPrioridad.add(rdbPrioridad1);
        rgrPrioridad.add(rdbPrioridad2);
        rgrPrioridad.add(rdbPrioridad3);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), descripcionTareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaRecepcionTareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), horaRecepcionTareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaEstimadaTareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fechaFinalizacionTareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        fchCarpetaTarea.setDialogTitle("Seleccionar carpeta");
        fchCarpetaTarea.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fchCarpetaTarea.addActionListener(formListener);

        masterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoTarea}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcionTarea}"));
        columnBinding.setColumnName("Descripción");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaRecepcionTarea}"));
        columnBinding.setColumnName("Fecha de recepción");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaEstimadaTarea}"));
        columnBinding.setColumnName("Fecha estimada de resolución");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaFinalizacionTarea}"));
        columnBinding.setColumnName("Fecha de finalización");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterTable.addInputMethodListener(formListener);
        masterTable.addKeyListener(formListener);
        masterTable.addVetoableChangeListener(formListener);
        masterScrollPane.setViewportView(masterTable);
        if (masterTable.getColumnModel().getColumnCount() > 0) {
            masterTable.getColumnModel().getColumn(0).setResizable(false);
            masterTable.getColumnModel().getColumn(1).setResizable(false);
            masterTable.getColumnModel().getColumn(2).setResizable(false);
            masterTable.getColumnModel().getColumn(3).setResizable(false);
            masterTable.getColumnModel().getColumn(4).setResizable(false);
        }

        codigoNaturalezaLabel.setText("Código Naturaleza:");

        codigoTareaLabel.setText("Código Tarea:");

        descripcionTareaLabel.setText("Descripción:");

        codigoSeguimientoLabel.setText("Tipo de seguimiento:");

        fechaRecepcionTareaLabel.setText("Fecha de recepción:");

        fechaEstimadaTareaLabel.setText("Fecha estimada de resolución:");

        carpetaTareaLabel.setText("Ubicación de carpeta:");

        observacionTareaLabel.setText("Observación:");

        fechaFinalizacionTareaLabel.setText("Fecha de finalización:");

        codigoNaturalezaField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoNaturaleza.codigoNaturaleza}"), codigoNaturalezaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        codigoTareaField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoTarea}"), codigoTareaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.carpetaTarea}"), carpetaTareaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), carpetaTareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.setText("Guardar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), saveButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        saveButton.addActionListener(formListener);

        refreshButton.setText("Refrescar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), refreshButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        refreshButton.addActionListener(formListener);

        newButton.setText("Nuevo");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, cbtTodos, org.jdesktop.beansbinding.ELProperty.create("${selected != true}"), newButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        newButton.addActionListener(formListener);

        deleteButton.setText("Eliminar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Institución:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tipo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Prioridad");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbTipo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbTipo2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(73, 73, 73)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbPrioridad1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbPrioridad2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbPrioridad3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(53, 53, 53)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbtTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBuscar)
                            .addComponent(cbtTodos))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbPrioridad1)
                            .addComponent(rdbPrioridad2)
                            .addComponent(rdbPrioridad3))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbTipo1)
                    .addComponent(rdbTipo2))
                .addContainerGap())
        );

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), cbxSeguimiento, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        cbxSeguimiento.addItemListener(formListener);
        cbxSeguimiento.addMouseListener(formListener);

        fldDescripcion.setColumns(20);
        fldDescripcion.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        fldDescripcion.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.descripcionTarea}"), fldDescripcion, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fldDescripcion, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jScrollPane1.setViewportView(fldDescripcion);

        spnHoraRecepcion.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        spnHoraRecepcion.setEditor(new javax.swing.JSpinner.DateEditor(spnHoraRecepcion, "HH:mm:ss"));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.horaRecepcionTarea}"), spnHoraRecepcion, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setSourceNullValue(new Date());
        binding.setSourceUnreadableValue(new Date());
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), spnHoraRecepcion, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaRecepcionTarea}"), dchRecepcion, org.jdesktop.beansbinding.BeanProperty.create("date"));
        binding.setSourceNullValue(new Date());
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), dchRecepcion, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaEstimadaTarea}"), dchEstimada, org.jdesktop.beansbinding.BeanProperty.create("date"));
        binding.setSourceNullValue(new Date());
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), dchEstimada, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dchRecepcion, org.jdesktop.beansbinding.ELProperty.create("${date}"), dchEstimada, org.jdesktop.beansbinding.BeanProperty.create("minSelectableDate"));
        bindingGroup.addBinding(binding);

        spnHoraEstimada.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        spnHoraEstimada.setEditor(new javax.swing.JSpinner.DateEditor(spnHoraEstimada, "HH:mm:ss"));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.horaEstimadaTarea}"), spnHoraEstimada, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setSourceNullValue(new Date());
        binding.setSourceUnreadableValue(new Date());
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), spnHoraEstimada, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        fldObservacion.setColumns(20);
        fldObservacion.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        fldObservacion.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.observacionTarea}"), fldObservacion, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fldObservacion, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(fldObservacion);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaFinalizacionTarea}"), dchFinalizacion, org.jdesktop.beansbinding.BeanProperty.create("date"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), dchFinalizacion, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dchRecepcion, org.jdesktop.beansbinding.ELProperty.create("${date}"), dchFinalizacion, org.jdesktop.beansbinding.BeanProperty.create("minSelectableDate"));
        bindingGroup.addBinding(binding);

        spnHoraFinalizacion.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.HOUR));
        spnHoraFinalizacion.setEditor(new javax.swing.JSpinner.DateEditor(spnHoraFinalizacion, "HH:mm:ss"));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.horaFinalizacionTarea}"), spnHoraFinalizacion, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setSourceNullValue(dateDefault);
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dchFinalizacion, org.jdesktop.beansbinding.ELProperty.create("${date != null && enable == true}"), spnHoraFinalizacion, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        lstArea.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.caracteristicaCollection}");
        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, eLProperty, lstArea);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${area.nombreArea}"));
        bindingGroup.addBinding(jListBinding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), lstArea, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jScrollPane3.setViewportView(lstArea);

        btnCaracteristica.setText("Agregar area:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoTarea != null}"), btnCaracteristica, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btnCaracteristica.addActionListener(formListener);

        btnInvolucrado.setText("Agregar involucrados");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoTarea != null}"), btnInvolucrado, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btnInvolucrado.addActionListener(formListener);

        lstInvolucrado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), lstInvolucrado, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jScrollPane4.setViewportView(lstInvolucrado);

        btnRutaCarpeta.setText("Seleccionar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), btnRutaCarpeta, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        btnRutaCarpeta.addActionListener(formListener);

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
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(codigoNaturalezaLabel)
                                    .addComponent(codigoTareaLabel)
                                    .addComponent(descripcionTareaLabel)
                                    .addComponent(codigoSeguimientoLabel)
                                    .addComponent(fechaRecepcionTareaLabel)
                                    .addComponent(fechaEstimadaTareaLabel)
                                    .addComponent(carpetaTareaLabel)
                                    .addComponent(observacionTareaLabel)
                                    .addComponent(fechaFinalizacionTareaLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dchRecepcion, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                            .addComponent(dchEstimada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(spnHoraEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dchFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                                        .addComponent(spnHoraFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2)
                                    .addComponent(spnHoraRecepcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbxSeguimiento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(carpetaTareaField)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnRutaCarpeta))
                                    .addComponent(codigoTareaField, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                                    .addComponent(codigoNaturalezaField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 216, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnInvolucrado)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCaracteristica, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcionTareaLabel)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoSeguimientoLabel)
                            .addComponent(cbxSeguimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spnHoraRecepcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(dchRecepcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fechaRecepcionTareaLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoNaturalezaLabel)
                            .addComponent(codigoNaturalezaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCaracteristica))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(codigoTareaLabel)
                            .addComponent(codigoTareaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInvolucrado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fechaEstimadaTareaLabel)
                            .addComponent(dchEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnHoraEstimada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carpetaTareaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRutaCarpeta)
                            .addComponent(carpetaTareaLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fechaFinalizacionTareaLabel)
                                    .addComponent(dchFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnHoraFinalizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(observacionTareaLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.InputMethodListener, java.awt.event.ItemListener, java.awt.event.KeyListener, java.awt.event.MouseListener, java.beans.VetoableChangeListener, javax.swing.event.ChangeListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == saveButton) {
                panelTarea.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                panelTarea.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                panelTarea.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                panelTarea.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == btnBuscar) {
                panelTarea.this.btnBuscarActionPerformed(evt);
            }
            else if (evt.getSource() == rdbPrioridad3) {
                panelTarea.this.rdbPrioridad3ActionPerformed(evt);
            }
            else if (evt.getSource() == rdbPrioridad2) {
                panelTarea.this.rdbPrioridad2ActionPerformed(evt);
            }
            else if (evt.getSource() == rdbTipo1) {
                panelTarea.this.rdbTipo1ActionPerformed(evt);
            }
            else if (evt.getSource() == rdbPrioridad1) {
                panelTarea.this.rdbPrioridad1ActionPerformed(evt);
            }
            else if (evt.getSource() == btnCaracteristica) {
                panelTarea.this.btnCaracteristicaActionPerformed(evt);
            }
            else if (evt.getSource() == btnInvolucrado) {
                panelTarea.this.btnInvolucradoActionPerformed(evt);
            }
            else if (evt.getSource() == btnRutaCarpeta) {
                panelTarea.this.btnRutaCarpetaActionPerformed(evt);
            }
            else if (evt.getSource() == fchCarpetaTarea) {
                panelTarea.this.fchCarpetaTareaActionPerformed(evt);
            }
        }

        public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            if (evt.getSource() == masterTable) {
                panelTarea.this.masterTableCaretPositionChanged(evt);
            }
        }

        public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
        }

        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (evt.getSource() == cbtTodos) {
                panelTarea.this.cbtTodosItemStateChanged(evt);
            }
            else if (evt.getSource() == cbxSeguimiento) {
                panelTarea.this.cbxSeguimientoItemStateChanged(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == masterTable) {
                panelTarea.this.masterTableKeyReleased(evt);
            }
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
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
                panelTarea.this.masterTableMouseReleased(evt);
            }
            else if (evt.getSource() == cbxSeguimiento) {
                panelTarea.this.cbxSeguimientoMouseReleased(evt);
            }
        }

        public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
            if (evt.getSource() == masterTable) {
                panelTarea.this.masterTableVetoableChange(evt);
            }
        }

        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            if (evt.getSource() == cbtTodos) {
                panelTarea.this.cbtTodosStateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents
    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refresh();
        defaultField();
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
        if(cbtTodos.isSelected()){
            statusBar.getInstance().setMsg("Debe seleccionar una naturaleza");
        }else{   
            if(!codigoNaturalezaField.getText().isEmpty()){
                sgiir.Entidades.Tarea t = new sgiir.Entidades.Tarea();
                t.setCodigoNaturaleza(n);
                entityManager.persist(t);
                list.add(t);
                int row = list.size() - 1;
                masterTable.setRowSelectionInterval(row, row);
                masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));

                cbxSeguimiento.setSelectedIndex(0);
            }else{
                //si no encuentra la naturaleza
                if(buscaNaturaleza()){
                    //if(!codigoNaturalezaField.getText().isEmpty()){
                        sgiir.Entidades.Tarea t = new sgiir.Entidades.Tarea();
                        t.setCodigoNaturaleza(n);
                        entityManager.persist(t);
                        list.add(t);
                        int row = list.size() - 1;
                        masterTable.setRowSelectionInterval(row, row);
                        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));

                        cbxSeguimiento.setSelectedIndex(0);
                    //}
                }else{
                    statusBar.getInstance().setMsg("Debe seleccionar una naturaleza");
                }
            }
            defaultField();
        }
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            comboBox itemCombo;
            itemCombo = (comboBox) cbxSeguimiento.getSelectedItem();
            codigoSeguimiento = itemCombo.getId();
            
            //pasa los campos visuales a la variables
            seteaCampos();
            
            //valida las variables
            if(validaciones()){
                int[] selected = masterTable.getSelectedRows();
                List<Tarea> toMerged = new ArrayList<Tarea>(selected.length);
                for (int idx = 0; idx < selected.length; idx++) {
                    Tarea t = list.get(masterTable.convertRowIndexToModel(selected[idx]));

                    t.setCodigoSeguimiento(s);
                    t.setCodigoNaturaleza(n);
                    t.setDescripcionTarea(descripcionTarea);
                    t.setFechaRecepcionTarea(fechaRecepcionTarea);
                    t.setHoraRecepcionTarea(horaRecepcionTarea);
                    t.setFechaEstimadaTarea(fechaEstimadaTarea);
                    t.setHoraEstimadaTarea(horaEstimadaTarea);
                    t.setCarpetaTarea(carpetaTarea);
                    t.setObservacionTarea(observacionTarea);
                    t.setFechaFinalizacionTarea(fechaFinalizacionTarea);
                    t.setHoraFinalizacionTarea(horaFinalizacionTarea);

                    toMerged.add(t);

                    entityManager.merge(t);
                }


                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();



                defaultField();

                statusBar.getInstance().setMsg("Operación exitosa");
                refresh();
            }

        } catch (RollbackException rex) {
            statusBar.getInstance().setMsg("Operación fallida");
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
        statusBar.getInstance().clrMsg();
        int noResult = 0;
        
        try{
            //BUSCA TODAS LAS TAREAS, INHABILTA LA CREACION PORQUE DEBE ESPECIFICAR LA NATURALEZA
            if(cbtTodos.isSelected()){

                query = entityManager.createNamedQuery("Tarea.findAll");

                java.util.Collection data = query.getResultList();
                for (Object entity : data) {
                    entityManager.refresh(entity);
                }
                list.clear();
                list.addAll(data);

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
                    
                    noResult = 1;
                    javax.persistence.Query queryNaturaleza = entityManager.createNativeQuery("SELECT * FROM Naturaleza where CodigoInstitucion = ? and TipoNaturaleza = ? and PrioridadNaturaleza = ?", Naturaleza.class);

                    queryNaturaleza.setParameter(1, codigoInstitucion);
                    queryNaturaleza.setParameter(2, tipoNaturaleza);
                    queryNaturaleza.setParameter(3, prioridadNaturaleza);

                    entityManager.getTransaction().rollback();
                    entityManager.getTransaction().begin();

                    this.n = (Naturaleza) queryNaturaleza.getSingleResult();
                    this.codigoNaturaleza = n.getCodigoNaturaleza();
                    codigoNaturalezaField.setText(String.valueOf(codigoNaturaleza));
                    
                    noResult = 2;
                    query = entityManager.createNativeQuery("SELECT * FROM Tarea WHERE CodigoNaturaleza = ?", Tarea.class);
                    query.setParameter(1, codigoNaturaleza);

                    java.util.Collection data = query.getResultList();
                    for (Object entity : data) {
                        entityManager.refresh(entity);
                    }
                    list.clear();
                    list.addAll(data);

                    comboSeguimiento(codigoNaturaleza);

                }else{
                    statusBar.getInstance().setMsg("Debe selecionar una institución");
                }
            }
            
        }catch(javax.persistence.NoResultException nre){
            if(noResult == 1){
                statusBar.getInstance().setMsg("Naturaleza invalida");
            }else{
                statusBar.getInstance().setMsg("No se encontraron tareas");
            }
            
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

    private void cbtTodosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbtTodosItemStateChanged
        cbxInstitucion.setSelectedIndex(0);
        statusBar.getInstance().clrMsg();
        
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

        }
        
        defaultField();
        
        list.clear();
    }//GEN-LAST:event_cbtTodosItemStateChanged

    private void cbtTodosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbtTodosStateChanged

    }//GEN-LAST:event_cbtTodosStateChanged

    private void cbxSeguimientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxSeguimientoItemStateChanged

    }//GEN-LAST:event_cbxSeguimientoItemStateChanged

    private void cbxSeguimientoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxSeguimientoMouseReleased

    }//GEN-LAST:event_cbxSeguimientoMouseReleased

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        if(masterTable.getSelectedRow() != -1){
            statusBar.getInstance().clrMsg();
            
            if(this.isNumeric(codigoNaturalezaField.getText())){
                codigoNaturaleza = Integer.parseInt(codigoNaturalezaField.getText());
                comboSeguimiento(codigoNaturaleza);
            }            
            
            if(isNumeric(codigoSeguimientoField.getText())){
                for (int index = 0; index < cbxSeguimiento.getItemCount(); index++) {
                    if(Integer.valueOf(codigoSeguimientoField.getText()) == cbxSeguimiento.getItemAt(index).getId()){
                        cbxSeguimiento.setSelectedIndex(index);
                    }
                }
            }
            
            seteaCampos();
            
            cargaInvolucrados(codigoNaturaleza, codigoTarea, 0);
        }
    }//GEN-LAST:event_masterTableMouseReleased

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

    private void masterTableVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_masterTableVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_masterTableVetoableChange

    private void masterTableCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_masterTableCaretPositionChanged

    }//GEN-LAST:event_masterTableCaretPositionChanged

    private void btnRutaCarpetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRutaCarpetaActionPerformed
        int rutaInstitucion = n.getCodigoInstitucion().getCodigoInstitucion();
        String ruta =fchCarpetaTarea.getCurrentDirectory().getAbsolutePath() + msgFile.getProperty("msg0003") + rutaInstitucion + "\\";
        fchCarpetaTarea.setCurrentDirectory(new File(ruta));
        int seleccion = fchCarpetaTarea.showOpenDialog(this.getParent());
    }//GEN-LAST:event_btnRutaCarpetaActionPerformed

    private void fchCarpetaTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fchCarpetaTareaActionPerformed
        JFileChooser temp = (JFileChooser) evt.getSource();
        String comando = evt.getActionCommand();
        
        if(comando.equals(JFileChooser.APPROVE_SELECTION)){
            File archivoSeleccionado = temp.getCurrentDirectory();
            carpetaTareaField.setText(temp.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_fchCarpetaTareaActionPerformed

    private void masterTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_masterTableKeyReleased
        if(masterTable.getSelectedRow() != -1){
            statusBar.getInstance().clrMsg();
            
            if(this.isNumeric(codigoNaturalezaField.getText())){
                codigoNaturaleza = Integer.parseInt(codigoNaturalezaField.getText());
                comboSeguimiento(codigoNaturaleza);
            }            
            
            if(isNumeric(codigoSeguimientoField.getText())){
                for (int index = 0; index < cbxSeguimiento.getItemCount(); index++) {
                    if(Integer.valueOf(codigoSeguimientoField.getText()) == cbxSeguimiento.getItemAt(index).getId()){
                        cbxSeguimiento.setSelectedIndex(index);
                    }
                }
            }
            
            seteaCampos();
            
            cargaInvolucrados(codigoNaturaleza, codigoTarea, 0);
        }
    }//GEN-LAST:event_masterTableKeyReleased
    private void comboInstitucion(){
        cbxInstitucion.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxInstitucion.addItem(ItemCombo);   
        
        for(Institucion entidad : listInstitucion){

            cbxInstitucion.addItem(new comboBox(entidad.getCodigoInstitucion(), entidad.getNombreInstitucion()));
            
        }
    }
    private void comboSeguimiento(int codigo){
        cbxSeguimiento.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxSeguimiento.addItem(ItemCombo);   

        sgiir.Entidades.Naturaleza n = (Naturaleza) entityManager.find(Naturaleza.class, codigo);

        for(Seguimiento entidad : n.getSeguimientoCollection()){

            cbxSeguimiento.addItem(entidad.getItemComboBox()); 
        }
        
    }
    private void refresh(){
        cargaInvolucrados(codigoNaturaleza, codigoTarea, 0);
        comboSeguimiento(codigoNaturaleza);
        
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            
            Tarea t = (Tarea) entity;
            makeDir((t.getCarpetaTarea() + "\\" + t.getCodigoTarea()));
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
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
        
        comboBox itemCombo = (comboBox) cbxSeguimiento.getSelectedItem();
        codigoSeguimiento = itemCombo.getId();
        
        s = (Seguimiento) entityManager.find(Seguimiento.class, codigoSeguimiento);
        n = (Naturaleza) entityManager.find(Naturaleza.class, codigoNaturaleza);
        
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
    private void defaultField(){
        lstInvolucrado.setModel(new DefaultListModel<>());
        fldDescripcion.setText("");
        spnHoraRecepcion.setValue(dateDefault);
        spnHoraFinalizacion.setValue(dateDefault);
        spnHoraEstimada.setValue(dateDefault);
        dchRecepcion.setDate(dateDefault);
        dchFinalizacion.setDate(dateDefault);
        dchEstimada.setDate(dateDefault);
        fldObservacion.setText("");
        if(cbxSeguimiento.getItemCount() > 0){
            cbxSeguimiento.setSelectedIndex(0);
        }

    }
    
    private boolean validaciones(){
        boolean check = false;
        
        if(n.getCodigoNaturaleza() != 0){
            if(s != null){
                if(!descripcionTarea.isEmpty()){
                    if(fechaRecepcionTarea != null){
                        if(fechaEstimadaTarea != null){
                            if(!carpetaTarea.isEmpty()){
                                
                                check = true;
                                
                            }else{
                                statusBar.getInstance().setMsg("Ingrese una ubicación para la carpeta de archivos");
                            }
                        }else{
                            statusBar.getInstance().setMsg("Ingrese la fecha estimada de resolución de la tarea");
                        }
                    }else{
                        statusBar.getInstance().setMsg("Ingrese la fecha de recepción");
                    }
                }else{
                    statusBar.getInstance().setMsg("Ingrese una descripción");
                }
            }else{
                statusBar.getInstance().setMsg("Debe seleccionar un tipo de seguimiento");
            }
        }else{
            statusBar.getInstance().setMsg("Naturaleza invalida");
        }
        
        return check;
    }
    
    private static boolean isNotNull(Object objeto){
        if(objeto == null){
            return false;
        }else{
            return true;
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
    
    private void makeDir(String ruta){
        File folder = new File(ruta);
        
        if(!folder.exists()){
            folder.mkdirs();
        }
    }
    
    private boolean buscaNaturaleza(){
        try{
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
                codigoNaturalezaField.setText(String.valueOf(codigoNaturaleza));
            }
        }catch(javax.persistence.NoResultException nre){
            return false;
        }
        return true;
    }
    
    private void cargaInvolucrados(int naturaleza, int tarea, int involucrado){
        DefaultListModel<String> listPersona = new DefaultListModel<>();
        
        try{
            Query queryInvolucrado = entityManager.createNativeQuery("SELECT * FROM Involucrado where CodigoNaturaleza = ? and CodigoTarea = ? and CodigoInvolucrado = ?", Involucrado.class);

            queryInvolucrado.setParameter(1, naturaleza);
            queryInvolucrado.setParameter(2, tarea);
            queryInvolucrado.setParameter(3, involucrado);
            
            entityManager.getTransaction().rollback();
            entityManager.getTransaction().begin();
            List<Involucrado> data = queryInvolucrado.getResultList();
            for (Involucrado i : data) {
                listPersona.addElement(i.getPersona().getNombrePersona());
            }
            
        }catch(javax.persistence.NoResultException nre){
            statusBar.getInstance().setMsg("No se encontraron involucrados");
            listPersona.clear();
        }
        
        lstInvolucrado.setModel(listPersona);
        if((listPersona.isEmpty()) && (involucrado > 0)){
            cargaInvolucrados(naturaleza, tarea, (involucrado -1 ));
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCaracteristica;
    private javax.swing.JButton btnInvolucrado;
    private javax.swing.JButton btnRutaCarpeta;
    private javax.swing.JTextField carpetaTareaField;
    private javax.swing.JLabel carpetaTareaLabel;
    private javax.swing.JCheckBox cbtTodos;
    private javax.swing.JComboBox<comboBox> cbxInstitucion;
    private javax.swing.JComboBox<comboBox> cbxSeguimiento;
    private javax.swing.JTextField codigoNaturalezaField;
    private javax.swing.JLabel codigoNaturalezaLabel;
    private javax.swing.JTextField codigoSeguimientoField;
    private javax.swing.JLabel codigoSeguimientoLabel;
    private javax.swing.JTextField codigoTareaField;
    private javax.swing.JLabel codigoTareaLabel;
    private com.toedter.calendar.JDateChooser dchEstimada;
    private com.toedter.calendar.JDateChooser dchFinalizacion;
    private com.toedter.calendar.JDateChooser dchRecepcion;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextField descripcionTareaField;
    private javax.swing.JLabel descripcionTareaLabel;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JFileChooser fchCarpetaTarea;
    private javax.swing.JTextField fechaEstimadaTareaField;
    private javax.swing.JLabel fechaEstimadaTareaLabel;
    private javax.swing.JTextField fechaFinalizacionTareaField;
    private javax.swing.JLabel fechaFinalizacionTareaLabel;
    private javax.swing.JTextField fechaRecepcionTareaField;
    private javax.swing.JLabel fechaRecepcionTareaLabel;
    private javax.swing.JTextArea fldDescripcion;
    private javax.swing.JTextArea fldObservacion;
    private javax.swing.JTextField horaRecepcionTareaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.util.List<sgiir.Entidades.Tarea> list;
    private java.util.List<Institucion> listInstitucion;
    private javax.swing.JList<String> lstArea;
    private javax.swing.JList<String> lstInvolucrado;
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
            java.util.logging.Logger.getLogger(panelTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new panelTarea());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
