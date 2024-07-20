package com.appchoferes.nomina.dtos;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CajaCarga {

    @Id
    Long cajaId;

    String noEconomico;

    String tanqueActual;

    public Long getcajaId() {
        return cajaId;
    }

    public void setcajaId(Long cajaId) {
        this.cajaId = cajaId;
    }

    public String getNoEconomico() {
        return noEconomico;
    }

    public void setNoEconomico(String noEconomico) {
        this.noEconomico = noEconomico;
    }

    public String getTanqueActual() {
        return tanqueActual;
    }

    public void setTanqueActual(String tanqueActual) {
        this.tanqueActual = tanqueActual;
    }
    

}
