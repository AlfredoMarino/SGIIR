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
public class CaracteristicaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "CodigoCaracteristica")
    private int codigoCaracteristica;
    @Basic(optional = false)
    @Column(name = "CodigoArea")
    private int codigoArea;

    public CaracteristicaPK() {
    }

    public CaracteristicaPK(int codigoCaracteristica, int codigoArea) {
        this.codigoCaracteristica = codigoCaracteristica;
        this.codigoArea = codigoArea;
    }

    public int getCodigoCaracteristica() {
        return codigoCaracteristica;
    }

    public void setCodigoCaracteristica(int codigoCaracteristica) {
        this.codigoCaracteristica = codigoCaracteristica;
    }

    public int getCodigoArea() {
        return codigoArea;
    }

    public void setCodigoArea(int codigoArea) {
        this.codigoArea = codigoArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCaracteristica;
        hash += (int) codigoArea;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaracteristicaPK)) {
            return false;
        }
        CaracteristicaPK other = (CaracteristicaPK) object;
        if (this.codigoCaracteristica != other.codigoCaracteristica) {
            return false;
        }
        if (this.codigoArea != other.codigoArea) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sgiir.Entidades.CaracteristicaPK[ codigoCaracteristica=" + codigoCaracteristica + ", codigoArea=" + codigoArea + " ]";
    }
    
}
