package com.appchoferes.nomina.modules.itinerario.modules.extra.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CargoDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("importe")
    private float importe;

}
