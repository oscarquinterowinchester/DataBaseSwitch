package com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "revision_mecanica_tbl")
public class RevisionMecanicaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer itinerarioId;

    private Integer choferId;

    private String remark;

    private Boolean defects;

    private Boolean safety;

    private Boolean satisfactory;

    private String firma;

    @Column(name = "firma_mecanico")
    private String firmaMecanico;

    private LocalDateTime fecha;

}