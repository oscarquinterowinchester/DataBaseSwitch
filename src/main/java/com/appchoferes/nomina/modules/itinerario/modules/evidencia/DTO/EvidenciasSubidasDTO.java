package com.appchoferes.nomina.modules.itinerario.modules.evidencia.DTO;

import java.util.ArrayList;
import java.util.List;

import com.appchoferes.nomina.modules.itinerario.modules.evidencia.models.EvidenciasEntity;

import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvidenciasSubidasDTO {

    ArrayList<DocumentosRequeridosDTO> obligatorias;

    @ElementCollection
    List<EvidenciasEntity> extras;


}
