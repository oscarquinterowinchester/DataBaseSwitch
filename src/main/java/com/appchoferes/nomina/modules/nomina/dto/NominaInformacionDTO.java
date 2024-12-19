package com.appchoferes.nomina.modules.nomina.dto;

import java.util.ArrayList;
import java.util.List;

import com.appchoferes.nomina.dtos.Nomina;
import com.appchoferes.nomina.dtos.Semana;
import com.appchoferes.nomina.modules.nomina.models.NominaEntity;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class NominaInformacionDTO {

  @Id
 private Long id;

@Embedded
 private SemanaDTO semanas;

 @ElementCollection
 private List<NominaEntity> viajes;

private int pendientes;

private int autorizados;

private float descuento;

private int total;


}
