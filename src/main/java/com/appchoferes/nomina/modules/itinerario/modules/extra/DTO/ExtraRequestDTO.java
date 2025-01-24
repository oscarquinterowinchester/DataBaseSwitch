package com.appchoferes.nomina.modules.itinerario.modules.extra.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExtraRequestDTO {

    @JsonProperty("CajachicaID")
    private int CajachicaID;

    @JsonProperty("Cantidad")
    private int cantidad;

    @JsonProperty("Descripcion")
    private String descripcion;

    @JsonProperty("foto")
    @JsonAlias("foto_nueva")
    private String foto;

    @JsonProperty("ItinerarioID")
    private int itinerarioId;

    @JsonProperty("ChoferID")
    private int choferId;

    @JsonProperty("Cargo")
    private CargoDTO cargo;

}
