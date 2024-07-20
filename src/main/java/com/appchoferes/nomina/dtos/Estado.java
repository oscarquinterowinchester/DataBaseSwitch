package com.appchoferes.nomina.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;

@Entity
public class Estado {

    @Id
    Long estadoId;
    String nombre;
    String paisId;

    public Long getEstadoId() {
        return estadoId;
    }
    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPaisId() {
        return paisId;
    }
    public void setPaisId(String paisId) {
        this.paisId = paisId;
    }

    

}
