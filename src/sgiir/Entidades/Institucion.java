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
@Table(name = "institucion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Institucion.findAll", query = "SELECT i FROM Institucion i"),
    @NamedQuery(name = "Institucion.findByCodigoInstitucion", query = "SELECT i FROM Institucion i WHERE i.codigoInstitucion = :codigoInstitucion"),
    @NamedQuery(name = "Institucion.findByNombreInstitucion", query = "SELECT i FROM Institucion i WHERE i.nombreInstitucion = :nombreInstitucion"),
    @NamedQuery(name = "Institucion.findByCliente", query = "SELECT i FROM Institucion i WHERE i.cliente = :cliente")})
public class Institucion implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoInstitucion")
    private Integer codigoInstitucion;
    @Basic(optional = false)
    @Column(name = "NombreInstitucion")
    private String nombreInstitucion;
    @Basic(optional = false)
    @Column(name = "Cliente")
    private boolean cliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoInstitucion")
    private Collection<Naturaleza> naturalezaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoInstitucion")
    private Collection<Cargo> cargoCollection;

    public Institucion() {
    }

    public Institucion(Integer codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public Institucion(Integer codigoInstitucion, String nombreInstitucion, boolean cliente) {
        this.codigoInstitucion = codigoInstitucion;
        this.nombreInstitucion = nombreInstitucion;
        this.cliente = cliente;
    }

    public Integer getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(Integer codigoInstitucion) {
        Integer oldCodigoInstitucion = this.codigoInstitucion;
        this.codigoInstitucion = codigoInstitucion;
        changeSupport.firePropertyChange("codigoInstitucion", oldCodigoInstitucion, codigoInstitucion);
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        String oldNombreInstitucion = this.nombreInstitucion;
        this.nombreInstitucion = nombreInstitucion;
        changeSupport.firePropertyChange("nombreInstitucion", oldNombreInstitucion, nombreInstitucion);
    }

    public boolean getCliente() {
        return cliente;
    }

    public void setCliente(boolean cliente) {
        boolean oldCliente = this.cliente;
        this.cliente = cliente;
        changeSupport.firePropertyChange("cliente", oldCliente, cliente);
    }

    @XmlTransient
    public Collection<Naturaleza> getNaturalezaCollection() {
        return naturalezaCollection;
    }

    public void setNaturalezaCollection(Collection<Naturaleza> naturalezaCollection) {
        this.naturalezaCollection = naturalezaCollection;
    }

    @XmlTransient
    public Collection<Cargo> getCargoCollection() {
        return cargoCollection;
    }

    public void setCargoCollection(Collection<Cargo> cargoCollection) {
        this.cargoCollection = cargoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoInstitucion != null ? codigoInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Institucion)) {
            return false;
        }
        Institucion other = (Institucion) object;
        if ((this.codigoInstitucion == null && other.codigoInstitucion != null) || (this.codigoInstitucion != null && !this.codigoInstitucion.equals(other.codigoInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Institucion[ codigoInstitucion=" + codigoInstitucion + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
