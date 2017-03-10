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
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.RollbackException;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sgiir.Entidades.Bitacora;
import sgiir.Entidades.BitacoraPK;
import sgiir.Entidades.Estado;
import sgiir.Entidades.Institucion;
import sgiir.Entidades.Involucrado;
import sgiir.Entidades.Naturaleza;
import sgiir.Entidades.Persona;
import sgiir.statusBar;
import sgiir.Entidades.Tarea;
import sgiir.comboBox;
import static sgiir.manejadorDB.Conexion;

/**
 *
 * @author Alfredo Mariño
 */
public class panelBitacora extends JPanel {

    private int codigoInstitucion;
    private int tipoNaturaleza;
    private int prioridadNaturaleza;
    private Naturaleza n;
    private Integer codigoNaturaleza;
    private Date dateDefault;
    private int codigoTarea;
    private short codigoEstado;
    private Estado e;
    private String observacionBitacora;
    private Date fechaBitacora;
    private Date horaBitacora;
    private int correlativoBitacora;
    private int codigoInvolucrado;
    private Tarea t;
    
    public panelBitacora() {
        //prepara una fecha en cero
        Calendar calendarDefault = Calendar.getInstance();
        calendarDefault.set(Calendar.HOUR_OF_DAY, 0);
        calendarDefault.set(Calendar.MINUTE, 0);
        calendarDefault.set(Calendar.SECOND, 0);
        dateDefault = calendarDefault.getTime();
        
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        
        comboInstitucion();
        comboEstado();
        
        listTarea.clear();
        list.clear();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("SGIIRPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT b FROM Bitacora b");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        queryTarea = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT t FROM Tarea t");
        listTarea = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryTarea.getResultList());
        queryEstado = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM Estado e");
        listEstado = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryEstado.getResultList());
        queryInstitucion = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT i FROM Institucion i");
        listInstitucion = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(queryInstitucion.getResultList());
        codigoEstadoField = new javax.swing.JTextField();
        codigoInvolucradoField = new javax.swing.JTextField();
        rgrTipo = new javax.swing.ButtonGroup();
        rgrPrioridad = new javax.swing.ButtonGroup();
        tareaField = new javax.swing.JTextField();
        naturalezaField = new javax.swing.JTextField();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        correlativoLabel = new javax.swing.JLabel();
        codigoEstadoLabel = new javax.swing.JLabel();
        observacionBitacoraLabel = new javax.swing.JLabel();
        fechaBitacoraLabel = new javax.swing.JLabel();
        correlativoBitacoraField = new javax.swing.JTextField();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tareaTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        fldObservacion = new javax.swing.JTextArea();
        dchFecha = new com.toedter.calendar.JDateChooser();
        spnHora = new javax.swing.JSpinner();
        cbxEstado = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstArea = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstInvolucrado = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoEstado.codigoEstado}"), codigoEstadoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("null");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), codigoEstadoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoInvolucrado}"), codigoInvolucradoField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), codigoInvolucradoField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        rgrTipo.add(rdbTipo1);
        rgrTipo.add(rdbTipo2);

        rgrPrioridad.add(rdbPrioridad1);
        rgrPrioridad.add(rdbPrioridad2);
        rgrPrioridad.add(rdbPrioridad3);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tareaTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoTarea}"), tareaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), tareaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tareaTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.codigoNaturaleza.codigoNaturaleza}"), naturalezaField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), naturalezaField, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        masterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bitacoraPK.correlativoBitacora}"));
        columnBinding.setColumnName("Código");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${observacionBitacora}"));
        columnBinding.setColumnName("Observación");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoEstado.descripcionEstado}"));
        columnBinding.setColumnName("Estado");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaBitacora}"));
        columnBinding.setColumnName("Fecha");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterTable.addMouseListener(formListener);
        masterScrollPane.setViewportView(masterTable);

        correlativoLabel.setText("Correlativo");

        codigoEstadoLabel.setText("Codigo Estado:");

        observacionBitacoraLabel.setText("Observacióna:");

        fechaBitacoraLabel.setText("Fecha Bitacora:");

        correlativoBitacoraField.setEditable(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.bitacoraPK.correlativoBitacora}"), correlativoBitacoraField, org.jdesktop.beansbinding.BeanProperty.create("text"));
        binding.setSourceUnreadableValue("");
        bindingGroup.addBinding(binding);

        saveButton.setText("Guardar");
        saveButton.addActionListener(formListener);

        refreshButton.setText("Refrescar");
        refreshButton.addActionListener(formListener);

        newButton.setText("Nuevo");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tareaTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), newButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        newButton.addActionListener(formListener);

        deleteButton.setText("Eliminar");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(rdbTipo1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbTipo2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(rdbPrioridad1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdbPrioridad2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdbPrioridad3)
                .addGap(149, 149, 149)
                .addComponent(cbtTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnBuscar)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbxInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(cbtTodos))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbTipo1)
                    .addComponent(rdbTipo2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdbPrioridad1)
                        .addComponent(rdbPrioridad2)
                        .addComponent(rdbPrioridad3)))
                .addContainerGap())
        );

        tareaTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, listTarea, tareaTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoNaturaleza.codigoNaturaleza}"));
        columnBinding.setColumnName("Naturaleza");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoTarea}"));
        columnBinding.setColumnName("Tarea");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descripcionTarea}"));
        columnBinding.setColumnName("Descripción");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${codigoNaturaleza.codigoInstitucion.nombreInstitucion}"));
        columnBinding.setColumnName("Institución");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaRecepcionTarea}"));
        columnBinding.setColumnName("Fecha de recepción");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaEstimadaTarea}"));
        columnBinding.setColumnName("Fecha estimada de Resolución");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${fechaFinalizacionTarea}"));
        columnBinding.setColumnName("Fecha de finalización");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding.setEditable(false);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        tareaTable.addMouseListener(formListener);
        jScrollPane1.setViewportView(tareaTable);
        if (tareaTable.getColumnModel().getColumnCount() > 0) {
            tareaTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        fldObservacion.setColumns(20);
        fldObservacion.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        fldObservacion.setRows(5);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.observacionBitacora}"), fldObservacion, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), fldObservacion, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jScrollPane2.setViewportView(fldObservacion);

        dchFecha.setDate(new Date());

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.fechaBitacora}"), dchFecha, org.jdesktop.beansbinding.BeanProperty.create("date"));
        binding.setSourceNullValue(new Date());
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), dchFecha, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        spnHora.setModel(new javax.swing.SpinnerDateModel());
        spnHora.setEditor(new javax.swing.JSpinner.DateEditor(spnHora, "HH:mm:ss"));

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.horaBitacora}"), spnHora, org.jdesktop.beansbinding.BeanProperty.create("value"));
        binding.setSourceNullValue(new Date());
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dchFecha, org.jdesktop.beansbinding.ELProperty.create("${date != null}"), spnHora, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), cbxEstado, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        cbxEstado.addItemListener(formListener);
        cbxEstado.addMouseListener(formListener);

        lstArea.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.caracteristicaCollection}");
        org.jdesktop.swingbinding.JListBinding jListBinding = org.jdesktop.swingbinding.SwingBindings.createJListBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, tareaTable, eLProperty, lstArea);
        jListBinding.setDetailBinding(org.jdesktop.beansbinding.ELProperty.create("${area.nombreArea}"));
        bindingGroup.addBinding(jListBinding);

        jScrollPane3.setViewportView(lstArea);

        lstInvolucrado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(lstInvolucrado);

        jButton1.setText("Agregar involucrados");
        jButton1.addActionListener(formListener);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(183, 183, 183)
                                    .addComponent(jButton1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane4))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(newButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(deleteButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(refreshButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(saveButton))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(96, 96, 96)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(correlativoLabel)
                                    .addComponent(fechaBitacoraLabel))
                                .addComponent(observacionBitacoraLabel)
                                .addComponent(codigoEstadoLabel))
                            .addGap(10, 10, 10)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(correlativoBitacoraField, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                                .addComponent(cbxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {deleteButton, newButton, refreshButton, saveButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(masterScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(correlativoBitacoraField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(codigoEstadoLabel)))
                            .addComponent(correlativoLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(observacionBitacoraLabel)
                                .addGap(95, 95, 95)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dchFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(spnHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechaBitacoraLabel)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(21, 21, 21)))
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
                panelBitacora.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                panelBitacora.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newButton) {
                panelBitacora.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                panelBitacora.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == btnBuscar) {
                panelBitacora.this.btnBuscarActionPerformed(evt);
            }
            else if (evt.getSource() == rdbPrioridad3) {
                panelBitacora.this.rdbPrioridad3ActionPerformed(evt);
            }
            else if (evt.getSource() == rdbPrioridad2) {
                panelBitacora.this.rdbPrioridad2ActionPerformed(evt);
            }
            else if (evt.getSource() == rdbTipo1) {
                panelBitacora.this.rdbTipo1ActionPerformed(evt);
            }
            else if (evt.getSource() == rdbPrioridad1) {
                panelBitacora.this.rdbPrioridad1ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                panelBitacora.this.jButton1ActionPerformed(evt);
            }
        }

        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            if (evt.getSource() == cbtTodos) {
                panelBitacora.this.cbtTodosItemStateChanged(evt);
            }
            else if (evt.getSource() == cbxEstado) {
                panelBitacora.this.cbxEstadoItemStateChanged(evt);
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
                panelBitacora.this.masterTableMouseReleased(evt);
            }
            else if (evt.getSource() == tareaTable) {
                panelBitacora.this.tareaTableMouseReleased(evt);
            }
            else if (evt.getSource() == cbxEstado) {
                panelBitacora.this.cbxEstadoMouseReleased(evt);
            }
        }

        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            if (evt.getSource() == cbtTodos) {
                panelBitacora.this.cbtTodosStateChanged(evt);
            }
        }
    }// </editor-fold>//GEN-END:initComponents

    
    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        refresh();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<sgiir.Entidades.Bitacora> toRemove = new ArrayList<sgiir.Entidades.Bitacora>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            sgiir.Entidades.Bitacora b = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(b);
            entityManager.remove(b);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        sgiir.Entidades.Bitacora b = new sgiir.Entidades.Bitacora();
        entityManager.persist(b);
        
        ////////
        //ASIGNA CORRELATIVO
        correlativoBitacora = asignaCorrelativo(codigoNaturaleza, codigoTarea);
        if(correlativoBitacora == 0){
            System.out.println("error asignando correlativo");
        }else{
            codigoInvolucrado = correlativoBitacora;
        }
        
        b.setBitacoraPK(new BitacoraPK(codigoNaturaleza, codigoTarea, correlativoBitacora));
        b.setCodigoInvolucrado(codigoInvolucrado);
        
        /////
        
        list.add(b);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            
            seteaCampos();
            if(validaciones()){
                
                int[] selected = masterTable.getSelectedRows();
                List<Bitacora> toMerged = new ArrayList<Bitacora>(selected.length);
                for (int idx = 0; idx < selected.length; idx++) {
                    Bitacora b = list.get(masterTable.convertRowIndexToModel(selected[idx]));

                    b.setBitacoraPK(new BitacoraPK(codigoNaturaleza, codigoTarea, correlativoBitacora));
                    b.setCodigoEstado(e);
                    b.setCodigoInvolucrado(codigoInvolucrado);
                    b.setTarea(t);
                    b.setNaturaleza(n);
                    b.setFechaBitacora(fechaBitacora);
                    b.setHoraBitacora(horaBitacora);
                    b.setObservacionBitacora(observacionBitacora);

                    toMerged.add(b);

                    entityManager.merge(b);
                }

                entityManager.getTransaction().commit();
                entityManager.getTransaction().begin();

                //defaultField();

                statusBar.getInstance().setMsg("Operación exitosa");
                refresh();
            }
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<sgiir.Entidades.Bitacora> merged = new ArrayList<sgiir.Entidades.Bitacora>(list.size());
            for (sgiir.Entidades.Bitacora b : list) {
                merged.add(entityManager.merge(b));
            }
            list.clear();
            list.addAll(merged);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void defaultField(){
        
        spnHora.setValue(new Date());
        dchFecha.setDate(new Date());
        fldObservacion.setText("");
        if(cbxEstado.getItemCount() > 0){
            cbxEstado.setSelectedIndex(0);
        }

    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        statusBar.getInstance().clrMsg();
        int noResult = 0;

        try{
            //BUSCA TODAS LAS TAREAS, INHABILTA LA CREACION PORQUE DEBE ESPECIFICAR LA NATURALEZA
            if(cbtTodos.isSelected()){

                queryTarea = entityManager.createNamedQuery("Tarea.findAll");

                java.util.Collection data = queryTarea.getResultList();
                /*for (Object entity : data) {
                    entityManager.refresh(entity);
                }*/
                listTarea.clear();
                listTarea.addAll(data);

                //comboSeguimiento();

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
                    naturalezaField.setText(String.valueOf(codigoNaturaleza));

                    noResult = 2;
                    queryTarea = entityManager.createNativeQuery("SELECT * FROM Tarea WHERE CodigoNaturaleza = ?", Tarea.class);
                    queryTarea.setParameter(1, codigoNaturaleza);

                    java.util.Collection data = queryTarea.getResultList();
                    /*for (Object entity : data) {
                        entityManager.refresh(entity);
                    }*/
                    listTarea.clear();
                    listTarea.addAll(data);

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

            listTarea.clear();
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

        //defaultField();

        list.clear();
    }//GEN-LAST:event_cbtTodosItemStateChanged

    private void cbtTodosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_cbtTodosStateChanged

    }//GEN-LAST:event_cbtTodosStateChanged

    private void cbxEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxEstadoItemStateChanged

    }//GEN-LAST:event_cbxEstadoItemStateChanged

    private void cbxEstadoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbxEstadoMouseReleased

    }//GEN-LAST:event_cbxEstadoMouseReleased

    private void tareaTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tareaTableMouseReleased
        if(this.isNumeric(naturalezaField.getText())){
            codigoNaturaleza = Integer.parseInt(naturalezaField.getText());
        }else{
            codigoNaturaleza = 0;
        }

        if(this.isNumeric(tareaField.getText())){
            codigoTarea = Integer.parseInt(tareaField.getText());
        }else{
            codigoTarea = 0;
        } 
        
        statusBar.getInstance().clrMsg();
        try{

            query = entityManager.createNativeQuery("SELECT * FROM Bitacora where CodigoNaturaleza = ? and CodigoTarea = ?", Bitacora.class);

            query.setParameter(1, codigoNaturaleza);
            query.setParameter(2, codigoTarea);

            java.util.Collection data = query.getResultList();;
            for (Object entity : data) {
                entityManager.refresh(entity);
            }
            list.clear();
            list.addAll(data);

        }catch(javax.persistence.NoResultException nre){

            statusBar.getInstance().setMsg("No se encontraron tareas");

            list.clear();
        }
    }//GEN-LAST:event_tareaTableMouseReleased

    private void masterTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_masterTableMouseReleased
        if(masterTable.getSelectedRow() != -1){
    
            posicionaComboEstado();
            
            
            if(isNumeric(codigoInvolucradoField.getText())){
                codigoInvolucrado = Integer.valueOf(codigoInvolucradoField.getText());
            }
            
            cargaInvolucrados(codigoNaturaleza, codigoTarea, codigoInvolucrado);
            
            
        }
    }//GEN-LAST:event_masterTableMouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(masterTable.getSelectedRow() != -1){
            framePopup vistaInvolucrado = new framePopup();
            vistaInvolucrado.pnlInvolucrado.setInvolucrado(codigoNaturaleza, codigoTarea, codigoInvolucrado);
            vistaInvolucrado.showPanel("INVOLUCRADO");
            vistaInvolucrado.setVisible(true);

        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void cargaInvolucrados(int naturaleza, int tarea, int involucrado){
        DefaultListModel<String> listPersona = new DefaultListModel<>();
        
        try{
            Query queryInvolucrado = entityManager.createNativeQuery("SELECT * FROM Involucrado where CodigoNaturaleza = ? and CodigoTarea = ? and CodigoInvolucrado = ?", Involucrado.class);

            queryInvolucrado.setParameter(1, naturaleza);
            queryInvolucrado.setParameter(2, tarea);
            queryInvolucrado.setParameter(3, involucrado);

            List<Involucrado> data = queryInvolucrado.getResultList();;
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
    
    private void refresh(){
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        
        comboEstado();
        list.clear();
        list.addAll(data);
    }
    private void seteaCampos(){
        
              
        comboBox itemCombo = (comboBox) cbxEstado.getSelectedItem();
        codigoEstado = (short) itemCombo.getId();
        
        e = (Estado) entityManager.find(Estado.class, codigoEstado);
        n = (Naturaleza) entityManager.find(Naturaleza.class, codigoNaturaleza);
        t = (Tarea) entityManager.find(Tarea.class, codigoTarea);
        
        observacionBitacora = fldObservacion.getText();
        fechaBitacora = dchFecha.getDate();
        horaBitacora = (Date) spnHora.getValue();
        
        /*
        //SI NO TIENE ASIGINADO UN CORRELATIVO, SE LO ASIGNA
        if(! isNumeric(correlativoBitacoraField.getText())){
            correlativoBitacora = asignaCorrelativo(codigoNaturaleza, (int) codigoTarea);
            if(correlativoBitacora == 0){
                System.out.println("error asignando correlativo");
            }else{
                codigoInvolucrado = correlativoBitacora;
            }
        }*/
    }
    
    private boolean validaciones(){
        boolean check = false;
        
        if(n.getCodigoNaturaleza() != 0){
            if(t.getCodigoTarea() != 0){
                if(e != null){
                    if(fechaBitacora != null){
                        if(horaBitacora != null){
                            check = true;
                        }else{
                            statusBar.getInstance().setMsg("Ingrese la hora");
                        }
                    }else{
                        statusBar.getInstance().setMsg("Ingrese la fecha de valida");
                    }
                }else{
                    statusBar.getInstance().setMsg("Debe actualizar el estado de la tarea");
                }
            }else{
                statusBar.getInstance().setMsg("Debe seleccionar una tarea");
            }
        }else{
            statusBar.getInstance().setMsg("Debe seleccionar una naturaleza valida");
        } 
               
        return check;
    }
    
    private void comboInstitucion(){
        cbxInstitucion.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxInstitucion.addItem(ItemCombo);   
        
        for(Institucion entidad : listInstitucion){

            cbxInstitucion.addItem(new comboBox(entidad.getCodigoInstitucion(), entidad.getNombreInstitucion()));
            
        }
    }

    private void comboEstado(){
        cbxEstado.removeAllItems();
        comboBox ItemCombo = new comboBox(0, "");
        cbxEstado.addItem(ItemCombo);   

        //sgiir.Entidades.Naturaleza n = (Naturaleza) entityManager.find(Naturaleza.class, codigo);
        //Estado e = (Estado) entityManager.find(Estado.class, codigo)

        for(Estado entidad : listEstado){

            cbxEstado.addItem(entidad.getItemComboBox()); 
        }
        
    }
    
    private void posicionaComboEstado(){
        if(isNumeric(codigoEstadoField.getText())){
            for (int index = 0; index < cbxEstado.getItemCount(); index++) {
                if(Integer.valueOf(codigoEstadoField.getText()) == cbxEstado.getItemAt(index).getId()){
                    cbxEstado.setSelectedIndex(index);
                }
            }
        }
    }
    
    private static int asignaCorrelativo(int Naturaleza, int tarea){
        try {
            String Query = "SELECT CorrelativoBitacora FROM bitacora WHERE CodigoNaturaleza = ? and CodigoTarea = ? ORDER BY CorrelativoBitacora DESC LIMIT 1";
            PreparedStatement ps = Conexion.prepareCall(Query);
            ps.setInt(1, Naturaleza);
            ps.setInt(2, tarea);
          
            ResultSet rs = ps.executeQuery();
            if(rs.absolute(1)){
                return (rs.getInt("CorrelativoBitacora") + 1);
            }else{
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(panelBitacora.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JCheckBox cbtTodos;
    private javax.swing.JComboBox<comboBox> cbxEstado;
    private javax.swing.JComboBox<comboBox> cbxInstitucion;
    private javax.swing.JTextField codigoEstadoField;
    private javax.swing.JLabel codigoEstadoLabel;
    private javax.swing.JTextField codigoInvolucradoField;
    private javax.swing.JTextField correlativoBitacoraField;
    private javax.swing.JLabel correlativoLabel;
    private com.toedter.calendar.JDateChooser dchFecha;
    private javax.swing.JButton deleteButton;
    private javax.persistence.EntityManager entityManager;
    private javax.swing.JLabel fechaBitacoraLabel;
    private javax.swing.JTextArea fldObservacion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.util.List<sgiir.Entidades.Bitacora> list;
    private java.util.List<Estado> listEstado;
    private java.util.List<Institucion> listInstitucion;
    private java.util.List<Tarea> listTarea;
    private javax.swing.JList<String> lstArea;
    private javax.swing.JList<String> lstInvolucrado;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JTextField naturalezaField;
    private javax.swing.JButton newButton;
    private javax.swing.JLabel observacionBitacoraLabel;
    private javax.persistence.Query query;
    private javax.persistence.Query queryEstado;
    private javax.persistence.Query queryInstitucion;
    private javax.persistence.Query queryTarea;
    private javax.swing.JRadioButton rdbPrioridad1;
    private javax.swing.JRadioButton rdbPrioridad2;
    private javax.swing.JRadioButton rdbPrioridad3;
    private javax.swing.JRadioButton rdbTipo1;
    private javax.swing.JRadioButton rdbTipo2;
    private javax.swing.JButton refreshButton;
    private javax.swing.ButtonGroup rgrPrioridad;
    private javax.swing.ButtonGroup rgrTipo;
    private javax.swing.JButton saveButton;
    private javax.swing.JSpinner spnHora;
    private javax.swing.JTextField tareaField;
    private javax.swing.JTable tareaTable;
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
            java.util.logging.Logger.getLogger(panelBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panelBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panelBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panelBitacora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new panelBitacora());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
}
