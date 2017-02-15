/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

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
    @NamedQuery(name = "Institucion.findByClienteInstitucion", query = "SELECT i FROM Institucion i WHERE i.clienteInstitucion = :clienteInstitucion")})
public class Institucion implements Serializable {

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
    @Column(name = "ClienteInstitucion")
    private boolean clienteInstitucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoInstitucion")
    private Collection<Naturaleza> naturalezaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoInstitucion")
    private Collection<Cargo> cargoCollection;

    public Institucion() {
    }

    public Institucion(Integer codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public Institucion(Integer codigoInstitucion, String nombreInstitucion, boolean clienteInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
        this.nombreInstitucion = nombreInstitucion;
        this.clienteInstitucion = clienteInstitucion;
    }

    public Integer getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(Integer codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    public String getNombreInstitucion() {
        return nombreInstitucion;
    }

    public void setNombreInstitucion(String nombreInstitucion) {
        this.nombreInstitucion = nombreInstitucion;
    }

    public boolean getClienteInstitucion() {
        return clienteInstitucion;
    }

    public void setClienteInstitucion(boolean clienteInstitucion) {
        this.clienteInstitucion = clienteInstitucion;
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
    
}
