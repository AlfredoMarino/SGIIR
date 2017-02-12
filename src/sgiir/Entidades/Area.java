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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByCodigoArea", query = "SELECT a FROM Area a WHERE a.codigoArea = :codigoArea"),
    @NamedQuery(name = "Area.findByNombreArea", query = "SELECT a FROM Area a WHERE a.nombreArea = :nombreArea"),
    @NamedQuery(name = "Area.findByDescripcionArea", query = "SELECT a FROM Area a WHERE a.descripcionArea = :descripcionArea")})
public class Area implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoArea")
    private Integer codigoArea;
    @Basic(optional = false)
    @Column(name = "NombreArea")
    private String nombreArea;
    @Basic(optional = false)
    @Column(name = "DescripcionArea")
    private String descripcionArea;

    public Area() {
    }

    public Area(Integer codigoArea) {
        this.codigoArea = codigoArea;
    }

    public Area(Integer codigoArea, String nombreArea, String descripcionArea) {
        this.codigoArea = codigoArea;
        this.nombreArea = nombreArea;
        this.descripcionArea = descripcionArea;
    }

    public Integer getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(Integer codigoArea) {
        Integer oldCodigoArea = this.codigoArea;
        this.codigoArea = codigoArea;
        changeSupport.firePropertyChange("codigoArea", oldCodigoArea, codigoArea);
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        String oldNombreArea = this.nombreArea;
        this.nombreArea = nombreArea;
        changeSupport.firePropertyChange("nombreArea", oldNombreArea, nombreArea);
    }

    public String getDescripcionArea() {
        return descripcionArea;
    }

    public void setDescripcionArea(String descripcionArea) {
        String oldDescripcionArea = this.descripcionArea;
        this.descripcionArea = descripcionArea;
        changeSupport.firePropertyChange("descripcionArea", oldDescripcionArea, descripcionArea);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoArea != null ? codigoArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.codigoArea == null && other.codigoArea != null) || (this.codigoArea != null && !this.codigoArea.equals(other.codigoArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Area[ codigoArea=" + codigoArea + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
