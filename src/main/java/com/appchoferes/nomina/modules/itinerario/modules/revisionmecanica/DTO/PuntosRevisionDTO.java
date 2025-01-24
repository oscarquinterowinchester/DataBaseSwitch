package com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PuntosRevisionDTO {

    @Id
    private Long id;

    private String nombre;

    private int tipo;

    private boolean check;

}
