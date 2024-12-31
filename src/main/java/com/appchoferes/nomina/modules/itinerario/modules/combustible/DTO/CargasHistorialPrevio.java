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
public class CargasHistorialPrevio {

    @Id
    @Column(name = "CargaID")
    private Long cargaId;

    @Column(name = "Litros")
    private double litros;

    @Column(name = "RendimientoCarga")
    private double rendimientoCarga;

    @Column(name = "Sellos")
    private String sellos;

    @Column(name = "FotoSello")
    private String fotoSello;

    @Column(name = "historial_Nota")
    private String nota;

    @Column(name = "Fecha")
    private String fechayHora;

    @Column(name = "Folio")
    private String folio;

    @Column(name = "proveedor")
    private String nombreProveedor;

    @Column(name = "RendimientoECM")
    private double rendimientoECM;

    @Column(name = "RendimientoRutas")
    private double rendimientoRutas;

}
