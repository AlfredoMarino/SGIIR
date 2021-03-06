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
import sgiir.comboBox;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private Collection<Caracteristica> caracteristicaCollection;

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
        this.codigoArea = codigoArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public String getDescripcionArea() {
        return descripcionArea;
    }

    public void setDescripcionArea(String descripcionArea) {
        this.descripcionArea = descripcionArea;
    }

    @XmlTransient
    public Collection<Caracteristica> getCaracteristicaCollection() {
        return caracteristicaCollection;
    }

    public void setCaracteristicaCollection(Collection<Caracteristica> caracteristicaCollection) {
        this.caracteristicaCollection = caracteristicaCollection;
    }
    
    public comboBox getItemComboBox() {
        
        comboBox ItemCombo = new comboBox(codigoArea, (nombreArea + " (" + descripcionArea + ")"));
        
        return ItemCombo;
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
    
}
