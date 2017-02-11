/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Vistas;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "cargo", catalog = "SGIIRDB", schema = "")
@NamedQueries({
    @NamedQuery(name = "Cargo.findAll", query = "SELECT c FROM Cargo c"),
    @NamedQuery(name = "Cargo.findByCodigoCargo", query = "SELECT c FROM Cargo c WHERE c.codigoCargo = :codigoCargo"),
    @NamedQuery(name = "Cargo.findByDescripcionCargo", query = "SELECT c FROM Cargo c WHERE c.descripcionCargo = :descripcionCargo"),
    @NamedQuery(name = "Cargo.findByCodigoInstitucion", query = "SELECT c FROM Cargo c WHERE c.codigoInstitucion = :codigoInstitucion"),
    @NamedQuery(name = "Cargo.findByInformeCargo", query = "SELECT c FROM Cargo c WHERE c.informeCargo = :informeCargo")})
public class Cargo implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

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
    @Column(name = "CodigoInstitucion")
    private int codigoInstitucion;
    @Basic(optional = false)
    @Column(name = "InformeCargo")
    private boolean informeCargo;

    public Cargo() {
    }

    public Cargo(Integer codigoCargo) {
        this.codigoCargo = codigoCargo;
    }

    public Cargo(Integer codigoCargo, String descripcionCargo, int codigoInstitucion, boolean informeCargo) {
        this.codigoCargo = codigoCargo;
        this.descripcionCargo = descripcionCargo;
        this.codigoInstitucion = codigoInstitucion;
        this.informeCargo = informeCargo;
    }

    public Integer getCodigoCargo() {
        return codigoCargo;
    }

    public void setCodigoCargo(Integer codigoCargo) {
        Integer oldCodigoCargo = this.codigoCargo;
        this.codigoCargo = codigoCargo;
        changeSupport.firePropertyChange("codigoCargo", oldCodigoCargo, codigoCargo);
    }

    public String getDescripcionCargo() {
        return descripcionCargo;
    }

    public void setDescripcionCargo(String descripcionCargo) {
        String oldDescripcionCargo = this.descripcionCargo;
        this.descripcionCargo = descripcionCargo;
        changeSupport.firePropertyChange("descripcionCargo", oldDescripcionCargo, descripcionCargo);
    }

    public int getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(int codigoInstitucion) {
        int oldCodigoInstitucion = this.codigoInstitucion;
        this.codigoInstitucion = codigoInstitucion;
        changeSupport.firePropertyChange("codigoInstitucion", oldCodigoInstitucion, codigoInstitucion);
    }

    public boolean getInformeCargo() {
        return informeCargo;
    }

    public void setInformeCargo(boolean informeCargo) {
        boolean oldInformeCargo = this.informeCargo;
        this.informeCargo = informeCargo;
        changeSupport.firePropertyChange("informeCargo", oldInformeCargo, informeCargo);
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
        return "sgiir.Vistas.Cargo[ codigoCargo=" + codigoCargo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
