package com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItinerariosHistorialDTO {

    @Id
    private Long ItinerarioID;

    private String estadocarga;

    private double km;

    private String ruta;

    private double rendimientoCamion;

    private String chofer;

    private int camion;

    private String caja;

    private String fechaLlegada;

    private double OdometroS;

    private double OdometroR;

    private double recorrido;

}
