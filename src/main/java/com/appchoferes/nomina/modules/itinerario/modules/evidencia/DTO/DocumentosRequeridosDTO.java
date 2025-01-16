package com.appchoferes.nomina.modules.itinerario.modules.evidencia.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DocumentosRequeridosDTO {

    @Id
   private Long evidenciaItiId;

   private String nombre;

}
