package com.appchoferes.nomina.modules.itinerario.modules.fechas.models;

import java.time.LocalDate;
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
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "eventoswc_tbl")
public class EventosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EventoWCID")
    private Long eventoWCId;

    @Column(name = "WContFK")
    private int wContFk;

    @Column(name = "ItinerarioFK")
    private int itinerarioFk;

    @Column(name = "OrdenWC")
    private int ordenWc;

    @Column(name = "EventoID")
    private int eventoId;

    @Column(name = "Concepto")
    private String concepto;

    @Column(name = "FechaEvento")
    private LocalDateTime fechaEvento;

    @Column(name = "FechaEventoRojo")
    private LocalDateTime fechaEventoRojo;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "Fecha")
    private LocalDateTime fecha;

    @Column(name = "UsuarioFK")
    private int usuarioFk;

    @Column(name = "locacionfk")
    private int locacionfk;

    @Column(name = "cpid")
    private int cpid;



}
