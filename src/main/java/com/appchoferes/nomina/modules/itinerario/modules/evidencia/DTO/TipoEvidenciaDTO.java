package com.appchoferes.nomina.modules.itinerario.modules.evidencia.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class TipoEvidenciaDTO {

    @Id
    private Long id;
    private String nombre;

}
