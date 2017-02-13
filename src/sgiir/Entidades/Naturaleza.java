/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

import java.io.Serializable;
import java.util.List;
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
@Table(name = "naturaleza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Naturaleza.findAll", query = "SELECT n FROM Naturaleza n"),
    @NamedQuery(name = "Naturaleza.findByTipoNaturaleza", query = "SELECT n FROM Naturaleza n WHERE n.tipoNaturaleza = :tipoNaturaleza"),
    @NamedQuery(name = "Naturaleza.findByPrioridadNaturaleza", query = "SELECT n FROM Naturaleza n WHERE n.prioridadNaturaleza = :prioridadNaturaleza"),
    @NamedQuery(name = "Naturaleza.findByCodigoNaturaleza", query = "SELECT n FROM Naturaleza n WHERE n.codigoNaturaleza = :codigoNaturaleza")})
public class Naturaleza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "TipoNaturaleza")
    private boolean tipoNaturaleza;
    @Basic(optional = false)
    @Column(name = "PrioridadNaturaleza")
    private boolean prioridadNaturaleza;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoNaturaleza")
    private Integer codigoNaturaleza;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoNaturaleza")
    private List<Tarea> tareaList;
    @JoinColumn(name = "CodigoInstitucion", referencedColumnName = "CodigoInstitucion")
    @ManyToOne(optional = false)
    private Institucion codigoInstitucion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoNaturaleza")
    private List<Seguimiento> seguimientoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoNaturaleza")
    private List<Bitacora> bitacoraList;

    public Naturaleza() {
    }

    public Naturaleza(Integer codigoNaturaleza) {
        this.codigoNaturaleza = codigoNaturaleza;
    }

    public Naturaleza(Integer codigoNaturaleza, boolean tipoNaturaleza, boolean prioridadNaturaleza) {
        this.codigoNaturaleza = codigoNaturaleza;
        this.tipoNaturaleza = tipoNaturaleza;
        this.prioridadNaturaleza = prioridadNaturaleza;
    }

    public boolean getTipoNaturaleza() {
        return tipoNaturaleza;
    }

    public void setTipoNaturaleza(boolean tipoNaturaleza) {
        this.tipoNaturaleza = tipoNaturaleza;
    }

    public boolean getPrioridadNaturaleza() {
        return prioridadNaturaleza;
    }

    public void setPrioridadNaturaleza(boolean prioridadNaturaleza) {
        this.prioridadNaturaleza = prioridadNaturaleza;
    }

    public Integer getCodigoNaturaleza() {
        return codigoNaturaleza;
    }

    public void setCodigoNaturaleza(Integer codigoNaturaleza) {
        this.codigoNaturaleza = codigoNaturaleza;
    }

    @XmlTransient
    public List<Tarea> getTareaList() {
        return tareaList;
    }

    public void setTareaList(List<Tarea> tareaList) {
        this.tareaList = tareaList;
    }

    public Institucion getCodigoInstitucion() {
        return codigoInstitucion;
    }

    public void setCodigoInstitucion(Institucion codigoInstitucion) {
        this.codigoInstitucion = codigoInstitucion;
    }

    @XmlTransient
    public List<Seguimiento> getSeguimientoList() {
        return seguimientoList;
    }

    public void setSeguimientoList(List<Seguimiento> seguimientoList) {
        this.seguimientoList = seguimientoList;
    }

    @XmlTransient
    public List<Bitacora> getBitacoraList() {
        return bitacoraList;
    }

    public void setBitacoraList(List<Bitacora> bitacoraList) {
        this.bitacoraList = bitacoraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoNaturaleza != null ? codigoNaturaleza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Naturaleza)) {
            return false;
        }
        Naturaleza other = (Naturaleza) object;
        if ((this.codigoNaturaleza == null && other.codigoNaturaleza != null) || (this.codigoNaturaleza != null && !this.codigoNaturaleza.equals(other.codigoNaturaleza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Naturaleza[ codigoNaturaleza=" + codigoNaturaleza + " ]";
    }
    
}
