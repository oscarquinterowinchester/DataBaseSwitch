package com.appchoferes.nomina.dtos;

import jakarta.persistence.*;

@Entity
public class Pais {

    @Id
    Long paisId;
    String nombre;

    public Long getPaisId() {
        return paisId;
    }
    public void setPaisId(Long paisId) {
        this.paisId = paisId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
