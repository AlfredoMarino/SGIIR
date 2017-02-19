/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "caracteristica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristica.findAll", query = "SELECT c FROM Caracteristica c"),
    @NamedQuery(name = "Caracteristica.findByCodigoNaturaleza", query = "SELECT c FROM Caracteristica c WHERE c.caracteristicaPK.codigoNaturaleza = :codigoNaturaleza"),
    @NamedQuery(name = "Caracteristica.findByCodigoTarea", query = "SELECT c FROM Caracteristica c WHERE c.caracteristicaPK.codigoTarea = :codigoTarea"),
    @NamedQuery(name = "Caracteristica.findByCodigoArea", query = "SELECT c FROM Caracteristica c WHERE c.caracteristicaPK.codigoArea = :codigoArea")})
public class Caracteristica implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CaracteristicaPK caracteristicaPK;
    @JoinColumn(name = "CodigoArea", referencedColumnName = "CodigoArea", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Area area;
    @JoinColumn(name = "CodigoTarea", referencedColumnName = "CodigoTarea", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tarea tarea;
    @JoinColumn(name = "CodigoNaturaleza", referencedColumnName = "CodigoNaturaleza", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Naturaleza naturaleza;

    public Caracteristica() {
    }

    public Caracteristica(CaracteristicaPK caracteristicaPK) {
        this.caracteristicaPK = caracteristicaPK;
    }

    public Caracteristica(int codigoNaturaleza, int codigoTarea, int codigoArea) {
        this.caracteristicaPK = new CaracteristicaPK(codigoNaturaleza, codigoTarea, codigoArea);
    }

    public CaracteristicaPK getCaracteristicaPK() {
        return caracteristicaPK;
    }

    public void setCaracteristicaPK(CaracteristicaPK caracteristicaPK) {
        this.caracteristicaPK = caracteristicaPK;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        Area oldArea = this.area;
        this.area = area;
        changeSupport.firePropertyChange("area", oldArea, area);
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        Tarea oldTarea = this.tarea;
        this.tarea = tarea;
        changeSupport.firePropertyChange("tarea", oldTarea, tarea);
    }

    public Naturaleza getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(Naturaleza naturaleza) {
        Naturaleza oldNaturaleza = this.naturaleza;
        this.naturaleza = naturaleza;
        changeSupport.firePropertyChange("naturaleza", oldNaturaleza, naturaleza);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caracteristicaPK != null ? caracteristicaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caracteristica)) {
            return false;
        }
        Caracteristica other = (Caracteristica) object;
        if ((this.caracteristicaPK == null && other.caracteristicaPK != null) || (this.caracteristicaPK != null && !this.caracteristicaPK.equals(other.caracteristicaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Caracteristica[ caracteristicaPK=" + caracteristicaPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
