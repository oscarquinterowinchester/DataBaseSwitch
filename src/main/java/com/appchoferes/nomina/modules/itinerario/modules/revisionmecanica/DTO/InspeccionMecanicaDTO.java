package com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspeccionMecanicaDTO {


    boolean defects;

    boolean satisfactory;

    boolean safety;

    String remark;
    
    @JsonProperty("ItinerarioID")
    int itinerarioId;

    @JsonProperty("ChoferID")
    int choferId;

    String firma;

    @JsonProperty("firma_mecanico")
    String firmaMecanico;

}
