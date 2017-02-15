/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "caracteristica")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caracteristica.findAll", query = "SELECT c FROM Caracteristica c"),
    @NamedQuery(name = "Caracteristica.findByCodigoCaracteristica", query = "SELECT c FROM Caracteristica c WHERE c.caracteristicaPK.codigoCaracteristica = :codigoCaracteristica"),
    @NamedQuery(name = "Caracteristica.findByCodigoArea", query = "SELECT c FROM Caracteristica c WHERE c.caracteristicaPK.codigoArea = :codigoArea")})
public class Caracteristica implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CaracteristicaPK caracteristicaPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCaracteristica")
    private Collection<Tarea> tareaCollection;
    @JoinColumn(name = "CodigoArea", referencedColumnName = "CodigoArea", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Area area;

    public Caracteristica() {
    }

    public Caracteristica(CaracteristicaPK caracteristicaPK) {
        this.caracteristicaPK = caracteristicaPK;
    }

    public Caracteristica(int codigoCaracteristica, int codigoArea) {
        this.caracteristicaPK = new CaracteristicaPK(codigoCaracteristica, codigoArea);
    }

    public CaracteristicaPK getCaracteristicaPK() {
        return caracteristicaPK;
    }

    public void setCaracteristicaPK(CaracteristicaPK caracteristicaPK) {
        this.caracteristicaPK = caracteristicaPK;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
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
    
}
