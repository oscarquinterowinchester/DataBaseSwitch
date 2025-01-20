package com.appchoferes.nomina.modules.itinerario.modules.sello.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SelloRotoDTO {
    
    @JsonProperty("itinerario")
    private String itinerario; 

    @JsonProperty("chofer")
    private int chofer; 

    @JsonProperty("sello")
    private int selloId; 

}
