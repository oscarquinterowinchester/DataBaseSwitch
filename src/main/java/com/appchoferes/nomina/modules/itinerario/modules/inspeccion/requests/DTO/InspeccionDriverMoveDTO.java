package com.appchoferes.nomina.modules.itinerario.modules.inspeccion.requests.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InspeccionDriverMoveDTO {

   private Long inspeccionId;

   private int itinerarioId;

   private boolean bien;

}
