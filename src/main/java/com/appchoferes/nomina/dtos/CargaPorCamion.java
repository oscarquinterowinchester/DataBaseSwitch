package com.appchoferes.nomina.dtos;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CargaPorCamion {
@Id
Long cargaId;
String fecha;
Double rendimientoCarga;
Double rendimientoEsperado;
String sellos;
String segundoSellos;



}
