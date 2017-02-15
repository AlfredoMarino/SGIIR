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
public class BitacoraPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CodigoNaturaleza")
    private int codigoNaturaleza;
    @Basic(optional = false)
    @Column(name = "CodigoTarea")
    private int codigoTarea;
    @Basic(optional = false)
    @Column(name = "CorrelativoBitacora")
    private int correlativoBitacora;

    public BitacoraPK() {
    }

    public BitacoraPK(int codigoNaturaleza, int codigoTarea, int correlativoBitacora) {
        this.codigoNaturaleza = codigoNaturaleza;
        this.codigoTarea = codigoTarea;
        this.correlativoBitacora = correlativoBitacora;
    }

    public int getCodigoNaturaleza() {
        return codigoNaturaleza;
    }

    public void setCodigoNaturaleza(int codigoNaturaleza) {
        this.codigoNaturaleza = codigoNaturaleza;
    }

    public int getCodigoTarea() {
        return codigoTarea;
    }

    public void setCodigoTarea(int codigoTarea) {
        this.codigoTarea = codigoTarea;
    }

    public int getCorrelativoBitacora() {
        return correlativoBitacora;
    }

    public void setCorrelativoBitacora(int correlativoBitacora) {
        this.correlativoBitacora = correlativoBitacora;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoNaturaleza;
        hash += (int) codigoTarea;
        hash += (int) correlativoBitacora;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BitacoraPK)) {
            return false;
        }
        BitacoraPK other = (BitacoraPK) object;
        if (this.codigoNaturaleza != other.codigoNaturaleza) {
            return false;
        }
        if (this.codigoTarea != other.codigoTarea) {
            return false;
        }
        if (this.correlativoBitacora != other.correlativoBitacora) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.BitacoraPK[ codigoNaturaleza=" + codigoNaturaleza + ", codigoTarea=" + codigoTarea + ", correlativoBitacora=" + correlativoBitacora + " ]";
    }
    
}
