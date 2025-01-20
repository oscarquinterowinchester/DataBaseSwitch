package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.models;

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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "requimant_tbl")
public class RequisicionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RequisicionID")
    private Long requisicionId;

    @Column(name = "ChoferID")
    private int choferId;

    @Column(name = "CategoriaID")
    private int categoriaId;

    @Column(name = "CamionID")
    private int camionId;

    @Column(name = "Status")
    private boolean status;

    @Column(name = "Odometro")
    private double odometro;

    @Column(name = "Tipo")
    private int tipo;

    @Column(name = "Subtipo")
    private int subtipo;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Fecha")
    private LocalDateTime fecha;

    @Column(name = "Prioridad")
    private int prioridad;

    @Column(name = "FechaI")
    private LocalDateTime fechaI;

    @Column(name = "FechaT")
    private LocalDateTime fechaT;

    @Column(name = "TReparacion")
    private int tReparacion;

    @Column(name = "descripcion2")
    private String descripcion2;

    @Column(name = "ProveedorID")
    private int proveedorId;

    @Column(name = "PrecioProv")
    private double precioProv;

    @Column(name = "Mecanico1")
    private int mecanico1;

    @Column(name = "Mecanico2")
    private int mecanico2;

    @Column(name = "ItinerarioID")
    private int itinerarioId;

    @Column(name = "FechaRegistro")
    private LocalDateTime fechaRegistro;

    @Column(name = "rev90")
    private boolean rev90;

    @Column(name = "onlyRequi")
    private boolean onlyRequi;

    @Column(name = "inirequi")
    private LocalDateTime iniRequi;

    @Column(name = "finrequi")
    private LocalDateTime finRequi;

    @Column(name = "tallerID")
    private int tallerId;

    @Column(name = "servicio")
    private boolean servicio;

    @Column(name = "servicio_tren")
    private boolean servicioTren;

    @Column(name = "servicio_post")
    private boolean servicioPost;

    @Column(name = "unidad_externa")
    private String unidadExterna;

    @Column(name = "departamentoID")
    private int departamentoId;

    @Column(name = "inspeccionanual")
    private boolean inspeccionAnual;

    @Column(name = "DescripcionTrabajoTrailer")
    private String descripcionTrabajoTrailer;

    @Column(name = "DescripcionTrabajoCamion")
    private String descripcionTrabajoCamion;

}
