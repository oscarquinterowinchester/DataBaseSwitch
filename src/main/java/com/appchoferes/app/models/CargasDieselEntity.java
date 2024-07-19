package com.appchoferes.app.models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cargasDiesel_tbl")
public class CargasDieselEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CargaID")
    private Integer cargaId;

    @Column(name = "Tipo")
    private Integer tipo;

    @Column(name = "UnidadID")
    private Integer unidadId;

    @Column(name = "ChoferID")
    private Integer choferId;

    @Column(name = "Litros")
    private Float litros;

    @Column(name = "LitrosECM")
    private Float litrosECM;

    @Column(name = "Fecha")
    private Date fecha;

    @Column(name = "Hora")
    private Date hora;

    @Column(name = "FechayHora")
    private Date fechayHora;

    @Column(name = "Folio")
    private String folio;

    @Column(name = "Nota")
    private String nota;

    @Column(name = "FechaRegistro")
    private Date fechaRegistro;

    @Column(name = "Status")
    private Boolean status;

    @Column(name = "AjusteOdometro")
    private Boolean ajusteOdometro;

    @Column(name = "ProveedorID")
    private Integer proveedorId;

    @Column(name = "FacturaID")
    private Integer facturaId;

    @Column(name = "CantidadActual")
    private Float cantidadActual;

    @Column(name = "MetodoPago")
    private Integer metodoPago;

    @Column(name = "SerieBomba")
    private String serieBomba;

    @Column(name = "RendimientoCarga")
    private Double rendimientoCarga;

    @Column(name = "RendimientoECM")
    private Double rendimientoECM;

    @Column(name = "RendimientoRutas")
    private Double rendimientoRutas;

    @Column(name = "OdometroCarga")
    private Float odometroCarga;

    @Column(name = "OdometroECM")
    private Float odometroECM;

    @Column(name = "RecorridoCarga")
    private Float recorridoCarga;

    @Column(name = "RecorridoECM")
    private Float recorridoECM;

    @Column(name = "Sellos")
    private String sellos;

    @Column(name = "FotoSello")
    private String fotoSello;

    @Column(name = "Sellos2")
    private String sellos2;

    @Column(name = "FotoSello2")
    private String fotoSello2;

    @Column(name = "PrecioTotal")
    private Float precioTotal;

    @Column(name = "MonedaCarga")
    private Integer monedaCarga;

    @Column(name = "FotoOdometro")
    private String fotoOdometro;

    @Column(name = "Firma")
    private String firma;

    @Column(name = "FotoTanque1")
    private String fotoTanque1;

    @Column(name = "FotoTanque2")
    private String fotoTanque2;

    @Column(name = "UsuarioID")
    private Integer usuarioId;

    @Column(name = "FromWS")
    private Boolean fromWS;

    @Column(name = "RecorridoRutas")
    private Float recorridoRutas;

    @Column(name = "OdometroAjustado")
    private Float odometroAjustado;

    @Column(name = "UsuarioAjuste")
    private Integer usuarioAjuste;

    @Column(name = "FechaAjuste")
    private Date fechaAjuste;

    @Column(name = "MotivoAjuste")
    private String motivoAjuste;

    @Column(name = "EstadoID")
    private Integer estadoId;

    @Column(name = "segundoSello")
    private String segundoSello;

    @Column(name = "tipoCombustible")
    private Integer tipoCombustible;

    @Column(name = "esChofer")
    private Boolean esChofer;

    public Integer getCargaId() {
        return cargaId;
    }

    public void setCargaId(Integer cargaId) {
        this.cargaId = cargaId;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getUnidadId() {
        return unidadId;
    }

    public void setUnidadId(Integer unidadId) {
        this.unidadId = unidadId;
    }

    public Integer getChoferId() {
        return choferId;
    }

    public void setChoferId(Integer choferId) {
        this.choferId = choferId;
    }

    public Float getLitros() {
        return litros;
    }

    public void setLitros(Float litros) {
        this.litros = litros;
    }

    public Float getLitrosECM() {
        return litrosECM;
    }

    public void setLitrosECM(Float litrosECM) {
        this.litrosECM = litrosECM;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public Date getFechayHora() {
        return fechayHora;
    }

    public void setFechayHora(Date fechayHora) {
        this.fechayHora = fechayHora;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Boolean getAjusteOdometro() {
        return ajusteOdometro;
    }

    public void setAjusteOdometro(Boolean ajusteOdometro) {
        this.ajusteOdometro = ajusteOdometro;
    }

    public Integer getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(Integer proveedorId) {
        this.proveedorId = proveedorId;
    }

    public Integer getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(Integer facturaId) {
        this.facturaId = facturaId;
    }

    public Float getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(Float cantidadActual) {
        this.cantidadActual = cantidadActual;
    }

    public Integer getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(Integer metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getSerieBomba() {
        return serieBomba;
    }

    public void setSerieBomba(String serieBomba) {
        this.serieBomba = serieBomba;
    }

    public Double getRendimientoCarga() {
        return rendimientoCarga;
    }

    public void setRendimientoCarga(Double rendimientoCarga) {
        this.rendimientoCarga = rendimientoCarga;
    }

    public Double getRendimientoECM() {
        return rendimientoECM;
    }

    public void setRendimientoECM(Double rendimientoECM) {
        this.rendimientoECM = rendimientoECM;
    }

    public Double getRendimientoRutas() {
        return rendimientoRutas;
    }

    public void setRendimientoRutas(Double rendimientoRutas) {
        this.rendimientoRutas = rendimientoRutas;
    }

    public Float getOdometroCarga() {
        return odometroCarga;
    }

    public void setOdometroCarga(Float odometroCarga) {
        this.odometroCarga = odometroCarga;
    }

    public Float getOdometroECM() {
        return odometroECM;
    }

    public void setOdometroECM(Float odometroECM) {
        this.odometroECM = odometroECM;
    }

    public Float getRecorridoCarga() {
        return recorridoCarga;
    }

    public void setRecorridoCarga(Float recorridoCarga) {
        this.recorridoCarga = recorridoCarga;
    }

    public Float getRecorridoECM() {
        return recorridoECM;
    }

    public void setRecorridoECM(Float recorridoECM) {
        this.recorridoECM = recorridoECM;
    }

    public String getSellos() {
        return sellos;
    }

    public void setSellos(String sellos) {
        this.sellos = sellos;
    }

    public String getFotoSello() {
        return fotoSello;
    }

    public void setFotoSello(String fotoSello) {
        this.fotoSello = fotoSello;
    }

    public String getSellos2() {
        return sellos2;
    }

    public void setSellos2(String sellos2) {
        this.sellos2 = sellos2;
    }

    public String getFotoSello2() {
        return fotoSello2;
    }

    public void setFotoSello2(String fotoSello2) {
        this.fotoSello2 = fotoSello2;
    }

    public Float getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Float precioTotal) {
        this.precioTotal = precioTotal;
    }

    public Integer getMonedaCarga() {
        return monedaCarga;
    }

    public void setMonedaCarga(Integer monedaCarga) {
        this.monedaCarga = monedaCarga;
    }

    public String getFotoOdometro() {
        return fotoOdometro;
    }

    public void setFotoOdometro(String fotoOdometro) {
        this.fotoOdometro = fotoOdometro;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getFotoTanque1() {
        return fotoTanque1;
    }

    public void setFotoTanque1(String fotoTanque1) {
        this.fotoTanque1 = fotoTanque1;
    }

    public String getFotoTanque2() {
        return fotoTanque2;
    }

    public void setFotoTanque2(String fotoTanque2) {
        this.fotoTanque2 = fotoTanque2;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Boolean getFromWS() {
        return fromWS;
    }

    public void setFromWS(Boolean fromWS) {
        this.fromWS = fromWS;
    }

    public Float getRecorridoRutas() {
        return recorridoRutas;
    }

    public void setRecorridoRutas(Float recorridoRutas) {
        this.recorridoRutas = recorridoRutas;
    }

    public Float getOdometroAjustado() {
        return odometroAjustado;
    }

    public void setOdometroAjustado(Float odometroAjustado) {
        this.odometroAjustado = odometroAjustado;
    }

    public Integer getUsuarioAjuste() {
        return usuarioAjuste;
    }

    public void setUsuarioAjuste(Integer usuarioAjuste) {
        this.usuarioAjuste = usuarioAjuste;
    }

    public Date getFechaAjuste() {
        return fechaAjuste;
    }

    public void setFechaAjuste(Date fechaAjuste) {
        this.fechaAjuste = fechaAjuste;
    }

    public String getMotivoAjuste() {
        return motivoAjuste;
    }

    public void setMotivoAjuste(String motivoAjuste) {
        this.motivoAjuste = motivoAjuste;
    }

    public Integer getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Integer estadoId) {
        this.estadoId = estadoId;
    }

    public String getSegundoSello() {
        return segundoSello;
    }

    public void setSegundoSello(String segundoSello) {
        this.segundoSello = segundoSello;
    }

    public Integer getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(Integer tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public Boolean getEsChofer() {
        return esChofer;
    }

    public void setEsChofer(Boolean esChofer) {
        this.esChofer = esChofer;
    }

    
}
