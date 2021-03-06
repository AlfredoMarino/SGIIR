/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
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
    @NamedQuery(name = "Bitacora.findByCodigoNaturaleza", query = "SELECT b FROM Bitacora b WHERE b.bitacoraPK.codigoNaturaleza = :codigoNaturaleza"),
    @NamedQuery(name = "Bitacora.findByCodigoTarea", query = "SELECT b FROM Bitacora b WHERE b.bitacoraPK.codigoTarea = :codigoTarea"),
    @NamedQuery(name = "Bitacora.findByCorrelativoBitacora", query = "SELECT b FROM Bitacora b WHERE b.bitacoraPK.correlativoBitacora = :correlativoBitacora"),
    @NamedQuery(name = "Bitacora.findByCodigoInvolucrado", query = "SELECT b FROM Bitacora b WHERE b.codigoInvolucrado = :codigoInvolucrado"),
    @NamedQuery(name = "Bitacora.findByFechaBitacora", query = "SELECT b FROM Bitacora b WHERE b.fechaBitacora = :fechaBitacora"),
    @NamedQuery(name = "Bitacora.findByHoraBitacora", query = "SELECT b FROM Bitacora b WHERE b.horaBitacora = :horaBitacora")})
public class Bitacora implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BitacoraPK bitacoraPK;
    @Basic(optional = false)
    @Column(name = "CodigoInvolucrado")
    private int codigoInvolucrado;
    @Basic(optional = false)
    @Lob
    @Column(name = "ObservacionBitacora")
    private String observacionBitacora;
    @Basic(optional = false)
    @Column(name = "FechaBitacora")
    @Temporal(TemporalType.DATE)
    private Date fechaBitacora;
    @Basic(optional = false)
    @Column(name = "HoraBitacora")
    @Temporal(TemporalType.TIME)
    private Date horaBitacora;
    @JoinColumn(name = "CodigoNaturaleza", referencedColumnName = "CodigoNaturaleza", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Naturaleza naturaleza;
    @JoinColumn(name = "CodigoTarea", referencedColumnName = "CodigoTarea", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tarea tarea;
    @JoinColumn(name = "CodigoEstado", referencedColumnName = "CodigoEstado")
    @ManyToOne(optional = false)
    private Estado codigoEstado;

    public Bitacora() {
    }

    public Bitacora(BitacoraPK bitacoraPK) {
        this.bitacoraPK = bitacoraPK;
    }

    public Bitacora(BitacoraPK bitacoraPK, int codigoInvolucrado, String observacionBitacora, Date fechaBitacora, Date horaBitacora) {
        this.bitacoraPK = bitacoraPK;
        this.codigoInvolucrado = codigoInvolucrado;
        this.observacionBitacora = observacionBitacora;
        this.fechaBitacora = fechaBitacora;
        this.horaBitacora = horaBitacora;
    }

    public Bitacora(int codigoNaturaleza, int codigoTarea, int correlativoBitacora) {
        this.bitacoraPK = new BitacoraPK(codigoNaturaleza, codigoTarea, correlativoBitacora);
    }

    public BitacoraPK getBitacoraPK() {
        return bitacoraPK;
    }

    public void setBitacoraPK(BitacoraPK bitacoraPK) {
        this.bitacoraPK = bitacoraPK;
    }

    public int getCodigoInvolucrado() {
        return codigoInvolucrado;
    }

    public void setCodigoInvolucrado(int codigoInvolucrado) {
        int oldCodigoInvolucrado = this.codigoInvolucrado;
        this.codigoInvolucrado = codigoInvolucrado;
        changeSupport.firePropertyChange("codigoInvolucrado", oldCodigoInvolucrado, codigoInvolucrado);
    }

    public String getObservacionBitacora() {
        return observacionBitacora;
    }

    public void setObservacionBitacora(String observacionBitacora) {
        String oldObservacionBitacora = this.observacionBitacora;
        this.observacionBitacora = observacionBitacora;
        changeSupport.firePropertyChange("observacionBitacora", oldObservacionBitacora, observacionBitacora);
    }

    public Date getFechaBitacora() {
        return fechaBitacora;
    }

    public void setFechaBitacora(Date fechaBitacora) {
        Date oldFechaBitacora = this.fechaBitacora;
        this.fechaBitacora = fechaBitacora;
        changeSupport.firePropertyChange("fechaBitacora", oldFechaBitacora, fechaBitacora);
    }

    public Date getHoraBitacora() {
        return horaBitacora;
    }

    public void setHoraBitacora(Date horaBitacora) {
        Date oldHoraBitacora = this.horaBitacora;
        this.horaBitacora = horaBitacora;
        changeSupport.firePropertyChange("horaBitacora", oldHoraBitacora, horaBitacora);
    }

    public Naturaleza getNaturaleza() {
        return naturaleza;
    }

    public void setNaturaleza(Naturaleza naturaleza) {
        Naturaleza oldNaturaleza = this.naturaleza;
        this.naturaleza = naturaleza;
        changeSupport.firePropertyChange("naturaleza", oldNaturaleza, naturaleza);
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        Tarea oldTarea = this.tarea;
        this.tarea = tarea;
        changeSupport.firePropertyChange("tarea", oldTarea, tarea);
    }

    public Estado getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(Estado codigoEstado) {
        Estado oldCodigoEstado = this.codigoEstado;
        this.codigoEstado = codigoEstado;
        changeSupport.firePropertyChange("codigoEstado", oldCodigoEstado, codigoEstado);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bitacoraPK != null ? bitacoraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bitacora)) {
            return false;
        }
        Bitacora other = (Bitacora) object;
        if ((this.bitacoraPK == null && other.bitacoraPK != null) || (this.bitacoraPK != null && !this.bitacoraPK.equals(other.bitacoraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Bitacora[ bitacoraPK=" + bitacoraPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
