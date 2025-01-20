package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteMecanicoDTO {

    @JsonProperty("CamionID")
    private int camionId;

    @JsonProperty("CategoriaID")
    private int categoriaId;

    @JsonProperty("ChoferID")
    private int choferId;

    @JsonProperty("Descripcion")
    private String descripcion;

    @JsonProperty("ItinerarioID")
    private int itinerarioId;

    @JsonProperty("Odometro")
    private double odometro;

    @JsonProperty("Subtipo")
    private int subtipo;

    @JsonProperty("Tipo")
    private int tipo;


}
