package com.appchoferes.nomina.modules.itinerario.modules.inspeccion.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ListaInspeccionChoferDTO {

   @Id
   private Long id;

   private int ListadoID;

   private String concepto;

   private boolean Bien;

}
