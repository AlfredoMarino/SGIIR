/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

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

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codigoPersona")
    private Autenticacion autenticacion;

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
        Integer oldCodigoPersona = this.codigoPersona;
        this.codigoPersona = codigoPersona;
        changeSupport.firePropertyChange("codigoPersona", oldCodigoPersona, codigoPersona);
    }

    public String getNombrePersona() {
        return nombrePersona;
    }

    public void setNombrePersona(String nombrePersona) {
        String oldNombrePersona = this.nombrePersona;
        this.nombrePersona = nombrePersona;
        changeSupport.firePropertyChange("nombrePersona", oldNombrePersona, nombrePersona);
    }

    public String getEmailPersona() {
        return emailPersona;
    }

    public void setEmailPersona(String emailPersona) {
        String oldEmailPersona = this.emailPersona;
        this.emailPersona = emailPersona;
        changeSupport.firePropertyChange("emailPersona", oldEmailPersona, emailPersona);
    }

    public long getTelefonoPersona() {
        return telefonoPersona;
    }

    public void setTelefonoPersona(long telefonoPersona) {
        long oldTelefonoPersona = this.telefonoPersona;
        this.telefonoPersona = telefonoPersona;
        changeSupport.firePropertyChange("telefonoPersona", oldTelefonoPersona, telefonoPersona);
    }

    public boolean getRecordatorioPersona() {
        return recordatorioPersona;
    }

    public void setRecordatorioPersona(boolean recordatorioPersona) {
        boolean oldRecordatorioPersona = this.recordatorioPersona;
        this.recordatorioPersona = recordatorioPersona;
        changeSupport.firePropertyChange("recordatorioPersona", oldRecordatorioPersona, recordatorioPersona);
    }

    public Cargo getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(Cargo codigoCargo) {
        Cargo oldCodigoCargo = this.codigoCargo;
        this.codigoCargo = codigoCargo;
        changeSupport.firePropertyChange("codigoCargo", oldCodigoCargo, codigoCargo);
    }

    public Autenticacion getAutenticacion() {
        return autenticacion;
    }

    public void setAutenticacion(Autenticacion autenticacion) {
        this.autenticacion = autenticacion;
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
