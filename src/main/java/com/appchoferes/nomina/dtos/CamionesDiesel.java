package com.appchoferes.nomina.dtos;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CamionesDiesel {

    @Id
    Long camionId;
    String noEconomico;
    String tanqueActual;


}
