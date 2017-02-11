/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "bitacora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bitacora.findAll", query = "SELECT b FROM Bitacora b"),
    @NamedQuery(name = "Bitacora.findByCorrelativoBitacora", query = "SELECT b FROM Bitacora b WHERE b.correlativoBitacora = :correlativoBitacora"),
    @NamedQuery(name = "Bitacora.findByFechaBitacora", query = "SELECT b FROM Bitacora b WHERE b.fechaBitacora = :fechaBitacora"),
    @NamedQuery(name = "Bitacora.findByHoraBitacora", query = "SELECT b FROM Bitacora b WHERE b.horaBitacora = :horaBitacora")})
public class Bitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CorrelativoBitacora")
    private Integer correlativoBitacora;
    @Basic(optional = false)
    @Column(name = "FechaBitacora")
    @Temporal(TemporalType.DATE)
    private Date fechaBitacora;
    @Basic(optional = false)
    @Column(name = "HoraBitacora")
    @Temporal(TemporalType.TIME)
    private Date horaBitacora;
    @Basic(optional = false)
    @Lob
    @Column(name = "ObservacionBitacora")
    private String observacionBitacora;
    @JoinColumn(name = "CodigoTarea", referencedColumnName = "CodigoTarea")
    @ManyToOne(optional = false)
    private Tarea codigoTarea;
    @JoinColumn(name = "CodigoNaturaleza", referencedColumnName = "CodigoNaturaleza")
    @ManyToOne(optional = false)
    private Naturaleza codigoNaturaleza;
    @JoinColumn(name = "CodigoEstado", referencedColumnName = "CodigoEstado")
    @ManyToOne(optional = false)
    private Estado codigoEstado;

    public Bitacora() {
    }

    public Bitacora(Integer correlativoBitacora) {
        this.correlativoBitacora = correlativoBitacora;
    }

    public Bitacora(Integer correlativoBitacora, Date fechaBitacora, Date horaBitacora, String observacionBitacora) {
        this.correlativoBitacora = correlativoBitacora;
        this.fechaBitacora = fechaBitacora;
        this.horaBitacora = horaBitacora;
        this.observacionBitacora = observacionBitacora;
    }

    public Integer getCorrelativoBitacora() {
        return correlativoBitacora;
    }

    public void setCorrelativoBitacora(Integer correlativoBitacora) {
        this.correlativoBitacora = correlativoBitacora;
    }

    public Date getFechaBitacora() {
        return fechaBitacora;
    }

    public void setFechaBitacora(Date fechaBitacora) {
        this.fechaBitacora = fechaBitacora;
    }

    public Date getHoraBitacora() {
        return horaBitacora;
    }

    public void setHoraBitacora(Date horaBitacora) {
        this.horaBitacora = horaBitacora;
    }

    public String getObservacionBitacora() {
        return observacionBitacora;
    }

    public void setObservacionBitacora(String observacionBitacora) {
        this.observacionBitacora = observacionBitacora;
    }

    public Tarea getCodigoTarea() {
        return codigoTarea;
    }

    public void setCodigoTarea(Tarea codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public Naturaleza getCodigoNaturaleza() {
        return codigoNaturaleza;
    }

    public void setCodigoNaturaleza(Naturaleza codigoNaturaleza) {
        this.codigoNaturaleza = codigoNaturaleza;
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (correlativoBitacora != null ? correlativoBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.correlativoBitacora == null && other.correlativoBitacora != null) || (this.correlativoBitacora != null && !this.correlativoBitacora.equals(other.correlativoBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Bitacora[ correlativoBitacora=" + correlativoBitacora + " ]";
    }
    
}
