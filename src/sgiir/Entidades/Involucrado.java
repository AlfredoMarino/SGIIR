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
@Table(name = "involucrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Involucrado.findAll", query = "SELECT i FROM Involucrado i"),
    @NamedQuery(name = "Involucrado.findByCodigoNaturaleza", query = "SELECT i FROM Involucrado i WHERE i.involucradoPK.codigoNaturaleza = :codigoNaturaleza"),
    @NamedQuery(name = "Involucrado.findByCodigoTarea", query = "SELECT i FROM Involucrado i WHERE i.involucradoPK.codigoTarea = :codigoTarea"),
    @NamedQuery(name = "Involucrado.findByCodigoInvolucrado", query = "SELECT i FROM Involucrado i WHERE i.involucradoPK.codigoInvolucrado = :codigoInvolucrado"),
    @NamedQuery(name = "Involucrado.findByCodigoPersona", query = "SELECT i FROM Involucrado i WHERE i.involucradoPK.codigoPersona = :codigoPersona")})
public class Involucrado implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvolucradoPK involucradoPK;
    @JoinColumn(name = "CodigoPersona", referencedColumnName = "CodigoPersona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "CodigoTarea", referencedColumnName = "CodigoTarea", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tarea tarea;
    @JoinColumn(name = "CodigoNaturaleza", referencedColumnName = "CodigoNaturaleza", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Naturaleza naturaleza;

    public Involucrado() {
    }

    public Involucrado(InvolucradoPK involucradoPK) {
        this.involucradoPK = involucradoPK;
    }

    public Involucrado(int codigoNaturaleza, int codigoTarea, int codigoInvolucrado, int codigoPersona) {
        this.involucradoPK = new InvolucradoPK(codigoNaturaleza, codigoTarea, codigoInvolucrado, codigoPersona);
    }

    public InvolucradoPK getInvolucradoPK() {
        return involucradoPK;
    }

    public void setInvolucradoPK(InvolucradoPK involucradoPK) {
        this.involucradoPK = involucradoPK;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        Persona oldPersona = this.persona;
        this.persona = persona;
        changeSupport.firePropertyChange("persona", oldPersona, persona);
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
        hash += (involucradoPK != null ? involucradoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Involucrado)) {
            return false;
        }
        Involucrado other = (Involucrado) object;
        if ((this.involucradoPK == null && other.involucradoPK != null) || (this.involucradoPK != null && !this.involucradoPK.equals(other.involucradoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.Involucrado[ involucradoPK=" + involucradoPK + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
