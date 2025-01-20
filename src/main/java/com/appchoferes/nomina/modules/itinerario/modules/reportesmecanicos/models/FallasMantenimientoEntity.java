package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fallasMantenimiento_tbl")
public class FallasMantenimientoEntity {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "MantenimientoID")
private Long mantenimientoId;

@Column(name = "RequisicionID")
private int requisicionId;

@Column(name = "FallaID")
private int fallaId;

}
