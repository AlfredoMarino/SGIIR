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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alfredo Mariño
 */
@Entity
@Table(name = "involucrado")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Involucrado.findAll", query = "SELECT i FROM Involucrado i"),
    @NamedQuery(name = "Involucrado.findByCodigoInvolucrado", query = "SELECT i FROM Involucrado i WHERE i.involucradoPK.codigoInvolucrado = :codigoInvolucrado"),
    @NamedQuery(name = "Involucrado.findByCodigoPersona", query = "SELECT i FROM Involucrado i WHERE i.involucradoPK.codigoPersona = :codigoPersona")})
public class Involucrado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvolucradoPK involucradoPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoInvolucrado")
    private Collection<Tarea> tareaCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "codigoInvolucrado")
    private Bitacora bitacora;
    @JoinColumn(name = "CodigoPersona", referencedColumnName = "CodigoPersona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public Involucrado() {
    }

    public Involucrado(InvolucradoPK involucradoPK) {
        this.involucradoPK = involucradoPK;
    }

    public Involucrado(int codigoInvolucrado, int codigoPersona) {
        this.involucradoPK = new InvolucradoPK(codigoInvolucrado, codigoPersona);
    }

    public InvolucradoPK getInvolucradoPK() {
        return involucradoPK;
    }

    public void setInvolucradoPK(InvolucradoPK involucradoPK) {
        this.involucradoPK = involucradoPK;
    }

    @XmlTransient
    public Collection<Tarea> getTareaCollection() {
        return tareaCollection;
    }

    public void setTareaCollection(Collection<Tarea> tareaCollection) {
        this.tareaCollection = tareaCollection;
    }

    public Bitacora getBitacora() {
        return bitacora;
    }

    public void setBitacora(Bitacora bitacora) {
        this.bitacora = bitacora;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
    
}
