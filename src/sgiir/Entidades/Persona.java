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
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByCodigoPersona", query = "SELECT p FROM Persona p WHERE p.codigoPersona = :codigoPersona"),
    @NamedQuery(name = "Persona.findByNombrePersona", query = "SELECT p FROM Persona p WHERE p.nombrePersona = :nombrePersona"),
    @NamedQuery(name = "Persona.findByEmailPersona", query = "SELECT p FROM Persona p WHERE p.emailPersona = :emailPersona"),
    @NamedQuery(name = "Persona.findByTelefonoPersona", query = "SELECT p FROM Persona p WHERE p.telefonoPersona = :telefonoPersona"),
    @NamedQuery(name = "Persona.findByRecordatorioPersona", query = "SELECT p FROM Persona p WHERE p.recordatorioPersona = :recordatorioPersona")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoPersona")
    private Integer codigoPersona;
    @Basic(optional = false)
    @Column(name = "NombrePersona")
    private String nombrePersona;
    @Basic(optional = false)
    @Column(name = "EmailPersona")
    private String emailPersona;
    @Basic(optional = false)
    @Column(name = "TelefonoPersona")
    private long telefonoPersona;
    @Basic(optional = false)
    @Column(name = "RecordatorioPersona")
    private boolean recordatorioPersona;
    @JoinColumn(name = "CodigoCargo", referencedColumnName = "CodigoCargo")
    @ManyToOne(optional = false)
    private Cargo codigoCargo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoPersona")
    private Collection<Autenticacion> autenticacionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
    private Collection<Involucrado> involucradoCollection;

    public Persona() {
    }

    public Persona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public Persona(Integer codigoPersona, String nombrePersona, String emailPersona, long telefonoPersona, boolean recordatorioPersona) {
        this.codigoPersona = codigoPersona;
        this.nombrePersona = nombrePersona;
        this.emailPersona = emailPersona;
        this.telefonoPersona = telefonoPersona;
        this.recordatorioPersona = recordatorioPersona;
    }

    public Integer getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Integer codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    public long getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(long telefonoPersona) {
        this.telefonoPersona = telefonoPersona;
    }

    public boolean getRecordatorioPersona() {
        return recordatorioPersona;
    }

    public void setRecordatorioPersona(boolean recordatorioPersona) {
        this.recordatorioPersona = recordatorioPersona;
    }

    public Cargo getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(Cargo codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    @XmlTransient
    public Collection<Autenticacion> getAutenticacionCollection() {
        return autenticacionCollection;
    }

    public void setAutenticacionCollection(Collection<Autenticacion> autenticacionCollection) {
        this.autenticacionCollection = autenticacionCollection;
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
        hash += (codigoPersona != null ? codigoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.codigoPersona == null && other.codigoPersona != null) || (this.codigoPersona != null && !this.codigoPersona.equals(other.codigoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Persona[ codigoPersona=" + codigoPersona + " ]";
    }
    
}
