package com.appchoferes.nomina.modules.nomina.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SemanasNominaDTO {

    @Id
    private Long semanaId;

    private String semanaanio;

    private int semana;

    private  String fechaIni;

    private String fechaFin;


}
