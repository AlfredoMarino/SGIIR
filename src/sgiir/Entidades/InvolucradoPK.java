/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgiir.Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Alfredo Mariño
 */
@Embeddable
public class InvolucradoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CodigoInvolucrado")
    private int codigoInvolucrado;
    @Basic(optional = false)
    @Column(name = "CodigoPersona")
    private int codigoPersona;

    public InvolucradoPK() {
    }

    public InvolucradoPK(int codigoInvolucrado, int codigoPersona) {
        this.codigoInvolucrado = codigoInvolucrado;
        this.codigoPersona = codigoPersona;
    }

    public int getCodigoInvolucrado() {
        return codigoInvolucrado;
    }

    public void setCodigoInvolucrado(int codigoInvolucrado) {
        this.codigoInvolucrado = codigoInvolucrado;
    }

    public int getCodigoPersona() {
        return codigoPersona;
    }

    public void setCodigoPersona(int codigoPersona) {
        this.codigoPersona = codigoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoInvolucrado;
        hash += (int) codigoPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvolucradoPK)) {
            return false;
        }
        InvolucradoPK other = (InvolucradoPK) object;
        if (this.codigoInvolucrado != other.codigoInvolucrado) {
            return false;
        }
        if (this.codigoPersona != other.codigoPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.InvolucradoPK[ codigoInvolucrado=" + codigoInvolucrado + ", codigoPersona=" + codigoPersona + " ]";
    }
    
}
