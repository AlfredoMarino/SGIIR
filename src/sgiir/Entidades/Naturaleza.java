/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "naturaleza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Naturaleza.findAll", query = "SELECT n FROM Naturaleza n"),
    @NamedQuery(name = "Naturaleza.findByTipoNaturaleza", query = "SELECT n FROM Naturaleza n WHERE n.tipoNaturaleza = :tipoNaturaleza"),
    @NamedQuery(name = "Naturaleza.findByPrioridadNaturaleza", query = "SELECT n FROM Naturaleza n WHERE n.prioridadNaturaleza = :prioridadNaturaleza"),
    @NamedQuery(name = "Naturaleza.findByCodigoNaturaleza", query = "SELECT n FROM Naturaleza n WHERE n.codigoNaturaleza = :codigoNaturaleza")})
public class Naturaleza implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "TipoNaturaleza")
    private int tipoNaturaleza;
    @Basic(optional = false)
    @Column(name = "PrioridadNaturaleza")
    private int prioridadNaturaleza;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoNaturaleza")
    private Integer codigoNaturaleza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoNaturaleza")
    private Collection<Tarea> tareaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "naturaleza")
    private Collection<Caracteristica> caracteristicaCollection;
    @JoinColumn(name = "CodigoInstitucion", referencedColumnName = "CodigoInstitucion")
    @ManyToOne(optional = false)
    private Institucion codigoInstitucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoNaturaleza")
    private Collection<Seguimiento> seguimientoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "naturaleza")
    private Collection<Bitacora> bitacoraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "naturaleza")
    private Collection<Involucrado> involucradoCollection;
    
    public Naturaleza() {
    }

    public Naturaleza(Integer codigoNaturaleza) {
        this.codigoNaturaleza = codigoNaturaleza;
    }

    public Naturaleza(Integer codigoNaturaleza, int tipoNaturaleza, int prioridadNaturaleza) {
        this.codigoNaturaleza = codigoNaturaleza;
        this.tipoNaturaleza = tipoNaturaleza;
        this.prioridadNaturaleza = prioridadNaturaleza;
    }

    public int getTipoNaturaleza() {
        return tipoNaturaleza;
    }

    public void setTipoNaturaleza(int tipoNaturaleza) {
        int oldTipoNaturaleza = this.tipoNaturaleza;
        this.tipoNaturaleza = tipoNaturaleza;
        changeSupport.firePropertyChange("tipoNaturaleza", oldTipoNaturaleza, tipoNaturaleza);
    }

    public int getPrioridadNaturaleza() {
        return prioridadNaturaleza;
    }

    public void setPrioridadNaturaleza(int prioridadNaturaleza) {
        int oldPrioridadNaturaleza = this.prioridadNaturaleza;
        this.prioridadNaturaleza = prioridadNaturaleza;
        changeSupport.firePropertyChange("prioridadNaturaleza", oldPrioridadNaturaleza, prioridadNaturaleza);
    }

    public Integer getCodigoNaturaleza() {
        return codigoNaturaleza;
    }

    public void setCodigoNaturaleza(Integer codigoNaturaleza) {
        Integer oldCodigoNaturaleza = this.codigoNaturaleza;
        this.codigoNaturaleza = codigoNaturaleza;
        changeSupport.firePropertyChange("codigoNaturaleza", oldCodigoNaturaleza, codigoNaturaleza);
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    @XmlTransient
    public Collection<Caracteristica> getCaracteristicaCollection() {
        return caracteristicaCollection;
    }

    public void setCaracteristicaCollection(Collection<Caracteristica> caracteristicaCollection) {
        this.caracteristicaCollection = caracteristicaCollection;
    }

    public Institucion getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(Institucion codigoInstitucion) {
        Institucion oldCodigoInstitucion = this.codigoInstitucion;
        this.codigoInstitucion = codigoInstitucion;
        changeSupport.firePropertyChange("codigoInstitucion", oldCodigoInstitucion, codigoInstitucion);
    }

    @XmlTransient
    public Collection<Seguimiento> getSeguimientoCollection() {
        return seguimientoCollection;
    }

    public void setSeguimientoCollection(Collection<Seguimiento> seguimientoCollection) {
        this.seguimientoCollection = seguimientoCollection;
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
    
  /*  public String getDescripcionTipoNaturaleza(){
        switch(tipoNaturaleza){
            case 0:
                this.descripcionTipoNaturaleza = "Incidencia";
            break;
            case 1:
                this.descripcionTipoNaturaleza = "Requerimiento";
            break;
            default:
                this.descripcionTipoNaturaleza = "Incidencia";
            break;
        }
        return descripcionTipoNaturaleza;
    }*/
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoNaturaleza != null ? codigoNaturaleza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Naturaleza)) {
            return false;
        }
        Naturaleza other = (Naturaleza) object;
        if ((this.codigoNaturaleza == null && other.codigoNaturaleza != null) || (this.codigoNaturaleza != null && !this.codigoNaturaleza.equals(other.codigoNaturaleza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return codigoNaturaleza.toString();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
