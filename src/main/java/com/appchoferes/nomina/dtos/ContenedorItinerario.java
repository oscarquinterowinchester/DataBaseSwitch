package com.appchoferes.nomina.dtos;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
@Entity
public class ContenedorItinerario {

    @Id
    private Long WContenedorID;

    private String FechaEntrega;

    private String cliente;

    private String Tamano;

    private String Contenedor;

    private String el;

}
