package com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CamionesConCargaDTO {

    @Id
    private Long id;

    @Column(name = "NoEconomico")
    private String noEconomico;

    @Column(name = "rendimiento_camion")
    private double rendimientoCamion;

    @Column(name = "tanque_porcentaje_lleno")
    private double tanquePorcentajeLleno;

    @Column(name = "tanque_capacidad")
    private double tanqueCapacidad;

    @Column(name = "TanqueActual")
    private double tanqueActual;

}
