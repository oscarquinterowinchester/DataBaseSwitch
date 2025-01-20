package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UnidadReporteDTO {

    @Id
    Long id;

    String nombre;

}
