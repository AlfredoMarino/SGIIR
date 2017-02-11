/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import sgiir.Naturaleza;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "tarea", catalog = "SGIIRDB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByCodigoNaturaleza", query = "SELECT t FROM Tarea t WHERE t.codigoNaturaleza = :codigoNaturaleza"),
    @NamedQuery(name = "Tarea.findByCodigoTarea", query = "SELECT t FROM Tarea t WHERE t.codigoTarea = :codigoTarea"),
    @NamedQuery(name = "Tarea.findByCodigoSeguimiento", query = "SELECT t FROM Tarea t WHERE t.codigoSeguimiento = :codigoSeguimiento"),
    @NamedQuery(name = "Tarea.findByCodigoInvolucrado", query = "SELECT t FROM Tarea t WHERE t.codigoInvolucrado = :codigoInvolucrado"),
    @NamedQuery(name = "Tarea.findByCodigoCaracteristica", query = "SELECT t FROM Tarea t WHERE t.codigoCaracteristica = :codigoCaracteristica"),
    @NamedQuery(name = "Tarea.findByFechaRecepcionTarea", query = "SELECT t FROM Tarea t WHERE t.fechaRecepcionTarea = :fechaRecepcionTarea"),
    @NamedQuery(name = "Tarea.findByHoraRecepcionTarea", query = "SELECT t FROM Tarea t WHERE t.horaRecepcionTarea = :horaRecepcionTarea"),
    @NamedQuery(name = "Tarea.findByFechaEstimadaTarea", query = "SELECT t FROM Tarea t WHERE t.fechaEstimadaTarea = :fechaEstimadaTarea"),
    @NamedQuery(name = "Tarea.findByHoraEstimadaTarea", query = "SELECT t FROM Tarea t WHERE t.horaEstimadaTarea = :horaEstimadaTarea"),
    @NamedQuery(name = "Tarea.findByCarpetaEvento", query = "SELECT t FROM Tarea t WHERE t.carpetaEvento = :carpetaEvento"),
    @NamedQuery(name = "Tarea.findByFechaFinalizacionTarea", query = "SELECT t FROM Tarea t WHERE t.fechaFinalizacionTarea = :fechaFinalizacionTarea"),
    @NamedQuery(name = "Tarea.findByHoraFinalizacionTarea", query = "SELECT t FROM Tarea t WHERE t.horaFinalizacionTarea = :horaFinalizacionTarea")})
public class Tarea implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "CodigoNaturaleza")
    private int codigoNaturaleza;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoTarea")
    private Integer codigoTarea;
    @Basic(optional = false)
    @Lob
    @Column(name = "DescripcionTarea")
    private String descripcionTarea;
    @Basic(optional = false)
    @Column(name = "CodigoSeguimiento")
    private int codigoSeguimiento;
    @Basic(optional = false)
    @Column(name = "CodigoInvolucrado")
    private int codigoInvolucrado;
    @Basic(optional = false)
    @Column(name = "CodigoCaracteristica")
    private int codigoCaracteristica;
    @Basic(optional = false)
    @Column(name = "FechaRecepcionTarea")
    @Temporal(TemporalType.DATE)
    private Date fechaRecepcionTarea;
    @Basic(optional = false)
    @Column(name = "HoraRecepcionTarea")
    @Temporal(TemporalType.TIME)
    private Date horaRecepcionTarea;
    @Basic(optional = false)
    @Column(name = "FechaEstimadaTarea")
    @Temporal(TemporalType.DATE)
    private Date fechaEstimadaTarea;
    @Basic(optional = false)
    @Column(name = "HoraEstimadaTarea")
    @Temporal(TemporalType.TIME)
    private Date horaEstimadaTarea;
    @Basic(optional = false)
    @Column(name = "CarpetaEvento")
    private String carpetaEvento;
    @Basic(optional = false)
    @Lob
    @Column(name = "ObservacionEvento")
    private String observacionEvento;
    @Basic(optional = false)
    @Column(name = "FechaFinalizacionTarea")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacionTarea;
    @Basic(optional = false)
    @Column(name = "HoraFinalizacionTarea")
    @Temporal(TemporalType.TIME)
    private Date horaFinalizacionTarea;
    @JoinColumn(name = "CodigoNaturaleza", referencedColumnName = "CodigoNaturaleza", updatable = false, insertable = false)
    @ManyToOne
    private Naturaleza codigonaturaleza;

    public Tarea() {
    }

    public Tarea(Integer codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public Tarea(Integer codigoTarea, int codigoNaturaleza, String descripcionTarea, int codigoSeguimiento, int codigoInvolucrado, int codigoCaracteristica, Date fechaRecepcionTarea, Date horaRecepcionTarea, Date fechaEstimadaTarea, Date horaEstimadaTarea, String carpetaEvento, String observacionEvento, Date fechaFinalizacionTarea, Date horaFinalizacionTarea) {
        this.codigoTarea = codigoTarea;
        this.codigoNaturaleza = codigoNaturaleza;
        this.descripcionTarea = descripcionTarea;
        this.codigoSeguimiento = codigoSeguimiento;
        this.codigoInvolucrado = codigoInvolucrado;
        this.codigoCaracteristica = codigoCaracteristica;
        this.fechaRecepcionTarea = fechaRecepcionTarea;
        this.horaRecepcionTarea = horaRecepcionTarea;
        this.fechaEstimadaTarea = fechaEstimadaTarea;
        this.horaEstimadaTarea = horaEstimadaTarea;
        this.carpetaEvento = carpetaEvento;
        this.observacionEvento = observacionEvento;
        this.fechaFinalizacionTarea = fechaFinalizacionTarea;
        this.horaFinalizacionTarea = horaFinalizacionTarea;
    }

    public int getCodigoNaturaleza() {
        return codigoNaturaleza;
    }

    public void setCodigoNaturaleza(int codigoNaturaleza) {
        int oldCodigoNaturaleza = this.codigoNaturaleza;
        this.codigoNaturaleza = codigoNaturaleza;
        changeSupport.firePropertyChange("codigoNaturaleza", oldCodigoNaturaleza, codigoNaturaleza);
    }

    public Integer getCodigoTarea() {
        return codigoTarea;
    }

    public void setCodigoTarea(Integer codigoTarea) {
        Integer oldCodigoTarea = this.codigoTarea;
        this.codigoTarea = codigoTarea;
        changeSupport.firePropertyChange("codigoTarea", oldCodigoTarea, codigoTarea);
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        String oldDescripcionTarea = this.descripcionTarea;
        this.descripcionTarea = descripcionTarea;
        changeSupport.firePropertyChange("descripcionTarea", oldDescripcionTarea, descripcionTarea);
    }

    public int getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public void setCodigoSeguimiento(int codigoSeguimiento) {
        int oldCodigoSeguimiento = this.codigoSeguimiento;
        this.codigoSeguimiento = codigoSeguimiento;
        changeSupport.firePropertyChange("codigoSeguimiento", oldCodigoSeguimiento, codigoSeguimiento);
    }

    public int getCodigoInvolucrado() {
        return codigoInvolucrado;
    }

    public void setCodigoInvolucrado(int codigoInvolucrado) {
        int oldCodigoInvolucrado = this.codigoInvolucrado;
        this.codigoInvolucrado = codigoInvolucrado;
        changeSupport.firePropertyChange("codigoInvolucrado", oldCodigoInvolucrado, codigoInvolucrado);
    }

    public int getCodigoCaracteristica() {
        return codigoCaracteristica;
    }

    public void setCodigoCaracteristica(int codigoCaracteristica) {
        int oldCodigoCaracteristica = this.codigoCaracteristica;
        this.codigoCaracteristica = codigoCaracteristica;
        changeSupport.firePropertyChange("codigoCaracteristica", oldCodigoCaracteristica, codigoCaracteristica);
    }

    public Date getFechaRecepcionTarea() {
        return fechaRecepcionTarea;
    }

    public void setFechaRecepcionTarea(Date fechaRecepcionTarea) {
        Date oldFechaRecepcionTarea = this.fechaRecepcionTarea;
        this.fechaRecepcionTarea = fechaRecepcionTarea;
        changeSupport.firePropertyChange("fechaRecepcionTarea", oldFechaRecepcionTarea, fechaRecepcionTarea);
    }

    public Date getHoraRecepcionTarea() {
        return horaRecepcionTarea;
    }

    public void setHoraRecepcionTarea(Date horaRecepcionTarea) {
        Date oldHoraRecepcionTarea = this.horaRecepcionTarea;
        this.horaRecepcionTarea = horaRecepcionTarea;
        changeSupport.firePropertyChange("horaRecepcionTarea", oldHoraRecepcionTarea, horaRecepcionTarea);
    }

    public Date getFechaEstimadaTarea() {
        return fechaEstimadaTarea;
    }

    public void setFechaEstimadaTarea(Date fechaEstimadaTarea) {
        Date oldFechaEstimadaTarea = this.fechaEstimadaTarea;
        this.fechaEstimadaTarea = fechaEstimadaTarea;
        changeSupport.firePropertyChange("fechaEstimadaTarea", oldFechaEstimadaTarea, fechaEstimadaTarea);
    }

    public Date getHoraEstimadaTarea() {
        return horaEstimadaTarea;
    }

    public void setHoraEstimadaTarea(Date horaEstimadaTarea) {
        Date oldHoraEstimadaTarea = this.horaEstimadaTarea;
        this.horaEstimadaTarea = horaEstimadaTarea;
        changeSupport.firePropertyChange("horaEstimadaTarea", oldHoraEstimadaTarea, horaEstimadaTarea);
    }

    public String getCarpetaEvento() {
        return carpetaEvento;
    }

    public void setCarpetaEvento(String carpetaEvento) {
        String oldCarpetaEvento = this.carpetaEvento;
        this.carpetaEvento = carpetaEvento;
        changeSupport.firePropertyChange("carpetaEvento", oldCarpetaEvento, carpetaEvento);
    }

    public String getObservacionEvento() {
        return observacionEvento;
    }

    public void setObservacionEvento(String observacionEvento) {
        String oldObservacionEvento = this.observacionEvento;
        this.observacionEvento = observacionEvento;
        changeSupport.firePropertyChange("observacionEvento", oldObservacionEvento, observacionEvento);
    }

    public Date getFechaFinalizacionTarea() {
        return fechaFinalizacionTarea;
    }

    public void setFechaFinalizacionTarea(Date fechaFinalizacionTarea) {
        Date oldFechaFinalizacionTarea = this.fechaFinalizacionTarea;
        this.fechaFinalizacionTarea = fechaFinalizacionTarea;
        changeSupport.firePropertyChange("fechaFinalizacionTarea", oldFechaFinalizacionTarea, fechaFinalizacionTarea);
    }

    public Date getHoraFinalizacionTarea() {
        return horaFinalizacionTarea;
    }

    public void setHoraFinalizacionTarea(Date horaFinalizacionTarea) {
        Date oldHoraFinalizacionTarea = this.horaFinalizacionTarea;
        this.horaFinalizacionTarea = horaFinalizacionTarea;
        changeSupport.firePropertyChange("horaFinalizacionTarea", oldHoraFinalizacionTarea, horaFinalizacionTarea);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoTarea != null ? codigoTarea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarea)) {
            return false;
        }
        Tarea other = (Tarea) object;
        if ((this.codigoTarea == null && other.codigoTarea != null) || (this.codigoTarea != null && !this.codigoTarea.equals(other.codigoTarea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Vistas.Tarea[ codigoTarea=" + codigoTarea + " ]";
    }

    public Naturaleza getCodigonaturaleza() {
        return codigonaturaleza;
    }

    public void setCodigonaturaleza(Naturaleza codigonaturaleza) {
        Naturaleza oldCodigonaturaleza = this.codigonaturaleza;
        this.codigonaturaleza = codigonaturaleza;
        changeSupport.firePropertyChange("codigonaturaleza", oldCodigonaturaleza, codigonaturaleza);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
