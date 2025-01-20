package com.appchoferes.nomina.modules.itinerario.modules.sello.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "sellosclientes_tbl")
public class SelloEntity {

    public SelloEntity(){

        this.status = true;
        this.enUso = true;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long selloId; 

    private int itinerarioId; 

    private int wcontId; 

    private int clienteId; 

    private String sello; 

    private boolean roto; 

    private boolean enUso; 

    private LocalDateTime fecha; 

    private boolean status; 

    private String nota; 

    private boolean selloAduana; 

    private String fotoSello; 

    private String fotoSelloLiga; 

    private int usuarioFk; 

    private int usuarioRompe; 

    private LocalDateTime fechaRompe; 

    private boolean adicionalPatio;
    
}
