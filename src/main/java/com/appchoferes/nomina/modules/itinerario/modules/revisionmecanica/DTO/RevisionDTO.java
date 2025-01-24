package com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RevisionDTO {


    @JsonProperty("puntos")
    List<PuntosRevisionDTO> puntosRevision;

    @JsonProperty("revision")
    @ElementCollection
    InspeccionMecanicaDTO revision;

}
