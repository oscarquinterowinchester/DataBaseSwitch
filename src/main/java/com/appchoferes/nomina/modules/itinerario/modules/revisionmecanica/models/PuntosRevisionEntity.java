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
@Table(name = "revision_mecanica_checks_tbl")
@Entity
public class PuntosRevisionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_revision_mecanica")
    private int revisionMecanicaId;
   
    @Column(name = "id_revision_mecanica_puntos")
    private int revisionMecanicaPuntosId;

    @Column(name = "`check`")
    private boolean check;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    @Override
    public String toString() {
        return "PuntosRevisionEntity [id=" + id + ", revisionMecanicaId=" + revisionMecanicaId
                + ", revisionMecanicaPuntosId=" + revisionMecanicaPuntosId + ", check=" + check + ", fecha=" + fecha
                + "]";
    }

}
