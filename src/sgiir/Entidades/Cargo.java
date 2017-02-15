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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cargo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByCodigoCargo", query = "SELECT c FROM Cargo c WHERE c.codigoCargo = :codigoCargo"),
    @NamedQuery(name = "Cargo.findByDescripcionCargo", query = "SELECT c FROM Cargo c WHERE c.descripcionCargo = :descripcionCargo"),
    @NamedQuery(name = "Cargo.findByInformeCargo", query = "SELECT c FROM Cargo c WHERE c.informeCargo = :informeCargo")})
public class Cargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoCargo")
    private Integer codigoCargo;
    @Basic(optional = false)
    @Column(name = "DescripcionCargo")
    private String descripcionCargo;
    @Basic(optional = false)
    @Column(name = "InformeCargo")
    private boolean informeCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCargo")
    private Collection<Persona> personaCollection;
    @JoinColumn(name = "CodigoInstitucion", referencedColumnName = "CodigoInstitucion")
    @ManyToOne(optional = false)
    private Institucion codigoInstitucion;

    public Cargo() {
    }

    public Cargo(Integer codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public Cargo(Integer codigoCargo, String descripcionCargo, boolean informeCargo) {
        this.codigoCargo = codigoCargo;
        this.descripcionCargo = descripcionCargo;
        this.informeCargo = informeCargo;
    }

    public Integer getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(Integer codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        this.descripcionCargo = descripcionCargo;
    }

    public boolean getInformeCargo() {
        return informeCargo;
    }

    public void setInformeCargo(boolean informeCargo) {
        this.informeCargo = informeCargo;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    public Institucion getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(Institucion codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCargo != null ? codigoCargo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cargo)) {
            return false;
        }
        Cargo other = (Cargo) object;
        if ((this.codigoCargo == null && other.codigoCargo != null) || (this.codigoCargo != null && !this.codigoCargo.equals(other.codigoCargo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Cargo[ codigoCargo=" + codigoCargo + " ]";
    }
    
}
