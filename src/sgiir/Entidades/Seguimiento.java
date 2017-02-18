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
import sgiir.comboBox;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "seguimiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Seguimiento.findAll", query = "SELECT s FROM Seguimiento s"),
    @NamedQuery(name = "Seguimiento.findByCodigoSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.codigoSeguimiento = :codigoSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByDescripcionSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.descripcionSeguimiento = :descripcionSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByDiasSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.diasSeguimiento = :diasSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByHorasSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.horasSeguimiento = :horasSeguimiento"),
    @NamedQuery(name = "Seguimiento.findByMaximoSeguimiento", query = "SELECT s FROM Seguimiento s WHERE s.maximoSeguimiento = :maximoSeguimiento")})
public class Seguimiento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CodigoSeguimiento")
    private Integer codigoSeguimiento;
    @Basic(optional = false)
    @Column(name = "DescripcionSeguimiento")
    private String descripcionSeguimiento;
    @Basic(optional = false)
    @Column(name = "DiasSeguimiento")
    private int diasSeguimiento;
    @Basic(optional = false)
    @Column(name = "HorasSeguimiento")
    private int horasSeguimiento;
    @Basic(optional = false)
    @Column(name = "MaximoSeguimiento")
    private int maximoSeguimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoSeguimiento")
    private Collection<Tarea> tareaCollection;
    @JoinColumn(name = "CodigoNaturaleza", referencedColumnName = "CodigoNaturaleza")
    @ManyToOne(optional = false)
    private Naturaleza codigoNaturaleza;

    public Seguimiento() {
    }

    public Seguimiento(Integer codigoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
    }

    public Seguimiento(Integer codigoSeguimiento, String descripcionSeguimiento, int diasSeguimiento, int horasSeguimiento, int maximoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
        this.descripcionSeguimiento = descripcionSeguimiento;
        this.diasSeguimiento = diasSeguimiento;
        this.horasSeguimiento = horasSeguimiento;
        this.maximoSeguimiento = maximoSeguimiento;
    }

    public Integer getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public void setCodigoSeguimiento(Integer codigoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
    }

    public String getDescripcionSeguimiento() {
        return descripcionSeguimiento;
    }

    public void setDescripcionSeguimiento(String descripcionSeguimiento) {
        this.descripcionSeguimiento = descripcionSeguimiento;
    }

    public int getDiasSeguimiento() {
        return diasSeguimiento;
    }

    public void setDiasSeguimiento(int diasSeguimiento) {
        this.diasSeguimiento = diasSeguimiento;
    }

    public int getHorasSeguimiento() {
        return horasSeguimiento;
    }

    public void setHorasSeguimiento(int horasSeguimiento) {
        this.horasSeguimiento = horasSeguimiento;
    }

    public int getMaximoSeguimiento() {
        return maximoSeguimiento;
    }

    public void setMaximoSeguimiento(int maximoSeguimiento) {
        this.maximoSeguimiento = maximoSeguimiento;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    public Naturaleza getCodigoNaturaleza() {
        return codigoNaturaleza;
    }

    public void setCodigoNaturaleza(Naturaleza codigoNaturaleza) {
        this.codigoNaturaleza = codigoNaturaleza;
    }
    
    public comboBox getItemComboBox() {
        
        comboBox ItemCombo = new comboBox(codigoSeguimiento, (descripcionSeguimiento + " (" + codigoSeguimiento.toString() + ")"));
        
        return ItemCombo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoSeguimiento != null ? codigoSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Seguimiento)) {
            return false;
        }
        Seguimiento other = (Seguimiento) object;
        if ((this.codigoSeguimiento == null && other.codigoSeguimiento != null) || (this.codigoSeguimiento != null && !this.codigoSeguimiento.equals(other.codigoSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Seguimiento[ codigoSeguimiento=" + codigoSeguimiento + " ]";
    }
    
}
