package com.appchoferes.nomina.dtos;

import java.util.ArrayList;
import java.util.Map;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class NominaPago {

 @Id
 private Long id;

@Embedded
 private Semana semanas;

 private ArrayList<Nomina> viajes;

private int pendientes;

private int autorizados;

private float descuento;

private int total;

 
    
}
