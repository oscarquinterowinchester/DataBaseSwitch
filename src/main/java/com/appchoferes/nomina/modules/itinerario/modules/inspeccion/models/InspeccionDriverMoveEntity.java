package com.appchoferes.nomina.modules.itinerario.modules.inspeccion.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inspecciones_tbl")
public class InspeccionDriverMoveEntity {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long inspeccionId;

   private int itinerarioId;

   private int listadoId;

   private LocalDateTime fecha;

   private boolean bien;
 
   private boolean bien2;


}
