package com.appchoferes.nomina.modules.itinerario.modules.evidencia.models;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "workcfiles_tbl")
public class EvidenciasEntity {

    public EvidenciasEntity(){

        fuente = 1;
        status = true;
        fecha = LocalDateTime.now().minusHours(8);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId; 

    private int facturaId; 

    private int workOId; 

    private int wContId; 

    private int itinerarioId; 

    private int evidenciaId; 

    private String nombre; 

    private String archivo; 

    private String extension; 

    private boolean paraFactura; 

    private boolean status; 

    private LocalDateTime fecha; 

    private boolean tempdel; 

    private int fuente; 

    private String aPath; 

    private int usuarioId; 

    private int usuarioEliminaId;

    private ZonedDateTime fechaElimina; 

    private String oldPath;

    private boolean validado;


}
