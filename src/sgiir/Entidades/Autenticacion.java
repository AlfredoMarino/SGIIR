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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "autenticacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autenticacion.findAll", query = "SELECT a FROM Autenticacion a"),
    @NamedQuery(name = "Autenticacion.findByUserAutenticacion", query = "SELECT a FROM Autenticacion a WHERE a.userAutenticacion = :userAutenticacion"),
    @NamedQuery(name = "Autenticacion.findByPassAutenticacion", query = "SELECT a FROM Autenticacion a WHERE a.passAutenticacion = :passAutenticacion"),
    @NamedQuery(name = "Autenticacion.findByNivelAutenticacion", query = "SELECT a FROM Autenticacion a WHERE a.nivelAutenticacion = :nivelAutenticacion")})
public class Autenticacion implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserAutenticacion")
    private String userAutenticacion;
    @Basic(optional = false)
    @Column(name = "PassAutenticacion")
    private String passAutenticacion;
    @Basic(optional = false)
    @Column(name = "NivelAutenticacion")
    private short nivelAutenticacion;
    @JoinColumn(name = "CodigoPersona", referencedColumnName = "CodigoPersona")
    @ManyToOne(optional = false)
    private Persona codigoPersona;

    public Autenticacion() {
    }

    public Autenticacion(String userAutenticacion) {
        this.userAutenticacion = userAutenticacion;
    }

    public Autenticacion(String userAutenticacion, String passAutenticacion, short nivelAutenticacion) {
        this.userAutenticacion = userAutenticacion;
        this.passAutenticacion = passAutenticacion;
        this.nivelAutenticacion = nivelAutenticacion;
    }

    public String getUserAutenticacion() {
        return userAutenticacion;
    }

    public void setUserAutenticacion(String userAutenticacion) {
        String oldUserAutenticacion = this.userAutenticacion;
        this.userAutenticacion = userAutenticacion;
        changeSupport.firePropertyChange("userAutenticacion", oldUserAutenticacion, userAutenticacion);
    }

    public String getPassAutenticacion() {
        return passAutenticacion;
    }

    public void setPassAutenticacion(String passAutenticacion) {
        String oldPassAutenticacion = this.passAutenticacion;
        this.passAutenticacion = passAutenticacion;
        changeSupport.firePropertyChange("passAutenticacion", oldPassAutenticacion, passAutenticacion);
    }

    public short getNivelAutenticacion() {
        return nivelAutenticacion;
    }

    public void setNivelAutenticacion(short nivelAutenticacion) {
        short oldNivelAutenticacion = this.nivelAutenticacion;
        this.nivelAutenticacion = nivelAutenticacion;
        changeSupport.firePropertyChange("nivelAutenticacion", oldNivelAutenticacion, nivelAutenticacion);
    }

    public Persona getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(Persona codigoPersona) {
        Persona oldCodigoPersona = this.codigoPersona;
        this.codigoPersona = codigoPersona;
        changeSupport.firePropertyChange("codigoPersona", oldCodigoPersona, codigoPersona);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAutenticacion != null ? userAutenticacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autenticacion)) {
            return false;
        }
        Autenticacion other = (Autenticacion) object;
        if ((this.userAutenticacion == null && other.userAutenticacion != null) || (this.userAutenticacion != null && !this.userAutenticacion.equals(other.userAutenticacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Autenticacion[ userAutenticacion=" + userAutenticacion + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
