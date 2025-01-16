package com.appchoferes.nomina.modules.itinerario.modules.evidencia.requests.DTO;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class EvidenciasDTO {


    private int itinerarioId;

    private int wContId;

    private int evidenciaId;
   
    private String extension;

    ArrayList<String> fotos;


}
