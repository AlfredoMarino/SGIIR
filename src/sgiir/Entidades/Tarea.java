/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "tarea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tarea.findAll", query = "SELECT t FROM Tarea t"),
    @NamedQuery(name = "Tarea.findByCodigoTarea", query = "SELECT t FROM Tarea t WHERE t.codigoTarea = :codigoTarea"),
    @NamedQuery(name = "Tarea.findByCodigoInvolucrado", query = "SELECT t FROM Tarea t WHERE t.codigoInvolucrado = :codigoInvolucrado"),
    @NamedQuery(name = "Tarea.findByCodigoCaracteristica", query = "SELECT t FROM Tarea t WHERE t.codigoCaracteristica = :codigoCaracteristica"),
    @NamedQuery(name = "Tarea.findByFechaRecepcionTarea", query = "SELECT t FROM Tarea t WHERE t.fechaRecepcionTarea = :fechaRecepcionTarea"),
    @NamedQuery(name = "Tarea.findByHoraRecepcionTarea", query = "SELECT t FROM Tarea t WHERE t.horaRecepcionTarea = :horaRecepcionTarea"),
    @NamedQuery(name = "Tarea.findByFechaEstimadaTarea", query = "SELECT t FROM Tarea t WHERE t.fechaEstimadaTarea = :fechaEstimadaTarea"),
    @NamedQuery(name = "Tarea.findByHoraEstimadaTarea", query = "SELECT t FROM Tarea t WHERE t.horaEstimadaTarea = :horaEstimadaTarea"),
    @NamedQuery(name = "Tarea.findByCarpetaTarea", query = "SELECT t FROM Tarea t WHERE t.carpetaTarea = :carpetaTarea"),
    @NamedQuery(name = "Tarea.findByFechaFinalizacionTarea", query = "SELECT t FROM Tarea t WHERE t.fechaFinalizacionTarea = :fechaFinalizacionTarea"),
    @NamedQuery(name = "Tarea.findByHoraFinalizacionTarea", query = "SELECT t FROM Tarea t WHERE t.horaFinalizacionTarea = :horaFinalizacionTarea")})
public class Tarea implements Serializable {

    private static final long serialVersionUID = 1L;
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
    @Column(name = "CarpetaTarea")
    private String carpetaTarea;
    @Basic(optional = false)
    @Lob
    @Column(name = "ObservacionTarea")
    private String observacionTarea;
    @Basic(optional = false)
    @Column(name = "FechaFinalizacionTarea")
    @Temporal(TemporalType.DATE)
    private Date fechaFinalizacionTarea;
    @Basic(optional = false)
    @Column(name = "HoraFinalizacionTarea")
    @Temporal(TemporalType.TIME)
    private Date horaFinalizacionTarea;
    @JoinColumn(name = "CodigoNaturaleza", referencedColumnName = "CodigoNaturaleza")
    @ManyToOne(optional = false)
    private Naturaleza codigoNaturaleza;
    @JoinColumn(name = "CodigoSeguimiento", referencedColumnName = "CodigoSeguimiento")
    @ManyToOne(optional = false)
    private Seguimiento codigoSeguimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarea")
    private Collection<Caracteristica> caracteristicaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarea")
    private Collection<Bitacora> bitacoraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tarea")
    private Collection<Involucrado> involucradoCollection;

    public Tarea() {
    }

    public Tarea(Integer codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public Tarea(Integer codigoTarea, String descripcionTarea, int codigoInvolucrado, int codigoCaracteristica, Date fechaRecepcionTarea, Date horaRecepcionTarea, Date fechaEstimadaTarea, Date horaEstimadaTarea, String carpetaTarea, String observacionTarea, Date fechaFinalizacionTarea, Date horaFinalizacionTarea) {
        this.codigoTarea = codigoTarea;
        this.descripcionTarea = descripcionTarea;
        this.codigoInvolucrado = codigoInvolucrado;
        this.codigoCaracteristica = codigoCaracteristica;
        this.fechaRecepcionTarea = fechaRecepcionTarea;
        this.horaRecepcionTarea = horaRecepcionTarea;
        this.fechaEstimadaTarea = fechaEstimadaTarea;
        this.horaEstimadaTarea = horaEstimadaTarea;
        this.carpetaTarea = carpetaTarea;
        this.observacionTarea = observacionTarea;
        this.fechaFinalizacionTarea = fechaFinalizacionTarea;
        this.horaFinalizacionTarea = horaFinalizacionTarea;
    }

    public Integer getCodigoTarea() {
        return codigoTarea;
    }

    public void setCodigoTarea(Integer codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public int getCodigoInvolucrado() {
        return codigoInvolucrado;
    }

    public void setCodigoInvolucrado(int codigoInvolucrado) {
        this.codigoInvolucrado = codigoInvolucrado;
    }

    public int getCodigoCaracteristica() {
        return codigoCaracteristica;
    }

    public void setCodigoCaracteristica(int codigoCaracteristica) {
        this.codigoCaracteristica = codigoCaracteristica;
    }

    public Date getFechaRecepcionTarea() {
        return fechaRecepcionTarea;
    }

    public void setFechaRecepcionTarea(Date fechaRecepcionTarea) {
        this.fechaRecepcionTarea = fechaRecepcionTarea;
    }

    public Date getHoraRecepcionTarea() {
        return horaRecepcionTarea;
    }

    public void setHoraRecepcionTarea(Date horaRecepcionTarea) {
        this.horaRecepcionTarea = horaRecepcionTarea;
    }

    public Date getFechaEstimadaTarea() {
        return fechaEstimadaTarea;
    }

    public void setFechaEstimadaTarea(Date fechaEstimadaTarea) {
        this.fechaEstimadaTarea = fechaEstimadaTarea;
    }

    public Date getHoraEstimadaTarea() {
        return horaEstimadaTarea;
    }

    public void setHoraEstimadaTarea(Date horaEstimadaTarea) {
        this.horaEstimadaTarea = horaEstimadaTarea;
    }

    public String getCarpetaTarea() {
        return carpetaTarea;
    }

    public void setCarpetaTarea(String carpetaTarea) {
        this.carpetaTarea = carpetaTarea;
    }

    public String getObservacionTarea() {
        return observacionTarea;
    }

    public void setObservacionTarea(String observacionTarea) {
        this.observacionTarea = observacionTarea;
    }

    public Date getFechaFinalizacionTarea() {
        return fechaFinalizacionTarea;
    }

    public void setFechaFinalizacionTarea(Date fechaFinalizacionTarea) {
        this.fechaFinalizacionTarea = fechaFinalizacionTarea;
    }

    public Date getHoraFinalizacionTarea() {
        return horaFinalizacionTarea;
    }

    public void setHoraFinalizacionTarea(Date horaFinalizacionTarea) {
        this.horaFinalizacionTarea = horaFinalizacionTarea;
    }

    public Naturaleza getCodigoNaturaleza() {
        return codigoNaturaleza;
    }

    public void setCodigoNaturaleza(Naturaleza codigoNaturaleza) {
        this.codigoNaturaleza = codigoNaturaleza;
    }

    public Seguimiento getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public void setCodigoSeguimiento(Seguimiento codigoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
    }

    @XmlTransient
    public Collection<Caracteristica> getCaracteristicaCollection() {
        return caracteristicaCollection;
    }

    public void setCaracteristicaCollection(Collection<Caracteristica> caracteristicaCollection) {
        this.caracteristicaCollection = caracteristicaCollection;
    }

    @XmlTransient
    public Collection<Bitacora> getBitacoraCollection() {
        return bitacoraCollection;
    }

    public void setBitacoraCollection(Collection<Bitacora> bitacoraCollection) {
        this.bitacoraCollection = bitacoraCollection;
    }

    @XmlTransient
    public Collection<Involucrado> getInvolucradoCollection() {
        return involucradoCollection;
    }

    public void setInvolucradoCollection(Collection<Involucrado> involucradoCollection) {
        this.involucradoCollection = involucradoCollection;
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
        return "sgiir.Entidades.Tarea[ codigoTarea=" + codigoTarea + " ]";
    }
    
}
