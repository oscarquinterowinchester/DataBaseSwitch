package com.appchoferes.nomina.modules.itinerario.modules.extra.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cajachica_tbl")
public class CajaChicaEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CajachicaID")
    private Integer cajaChicaId;

    @Column(name = "CargoID")
    private Integer cargoId;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Unitario")
    private Float unitario;

    @Column(name = "Importe")
    private Float importe;

    @Column(name = "Moneda")
    private int moneda;

    @Column(name = "mn")
    private Float mn;

    @Column(name = "dlls")
    private Float dlls;

    @Column(name = "Movimiento")
    private Integer movimiento;

    @Column(name = "UsuarioID")
    private Integer usuarioId;

    @Column(name = "Fecha")
    private LocalDateTime fecha;

    @Column(name = "ItinerarioID")
    private Integer itinerarioId;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Referencia")
    private String referencia;

    @Column(name = "ViaticoID")
    private Integer viaticoId;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "BonoAntiguedad")
    private Boolean bonoAntiguedad;

    @Column(name = "cargoclienteid")
    private Integer cargoClienteId;

    @Column(name = "pathfile")
    private String pathFile;

    @Column(name = "ImporteOriginal")
    private Float importeOriginal;

    @Column(name = "fechaval")
    private LocalDateTime fechaVal;

    @Column(name = "usuarioval")
    private Integer usuarioVal;

    @Column(name = "seleccion")
    private Boolean seleccion;

    @Column(name = "fechaNomina")
    private LocalDateTime fechaNomina;

    @Column(name = "statusNomina")
    private Integer statusNomina;


}
