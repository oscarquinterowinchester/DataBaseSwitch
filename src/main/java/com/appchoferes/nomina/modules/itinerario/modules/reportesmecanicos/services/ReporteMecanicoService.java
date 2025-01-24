package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO.CategoriaDTO;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO.ReporteMecanicoDTO;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO.TipoFallaDTO;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO.UnidadReporteDTO;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.models.FallasMantenimientoEntity;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.models.RequisicionEntity;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.repositories.CategoriaRepository;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.repositories.FallasMantenimientoRepository;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.repositories.RequisicionRepository;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.repositories.TipoFallaRepository;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.repositories.UnidadReporteRepository;
import com.appchoferes.nomina.operaciones.Utils;
import com.appchoferes.nomina.validators.Validador;


@Service
public class ReporteMecanicoService {

    
    @Autowired
    RequisicionRepository reporteRepository;

    @Autowired
    FallasMantenimientoRepository fallasRepository;

    @Autowired
    Utils utils;

    @Autowired
    Validador validador;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    UnidadReporteRepository unidadReporteRepository;

    @Autowired
    TipoFallaRepository tipoFallaRepository;


    public List<TipoFallaDTO> getTipoFallasMecanicas(String dbType){

        utils.establecerBaseDatos(dbType);

       return tipoFallaRepository.getTiposFalla();

    }

    public List<UnidadReporteDTO> getUnidadesObjeto(int itinerarioId, int categoriaId,String dbType){

        utils.establecerBaseDatos(dbType);

       return unidadReporteRepository.getUnidadesByItinerarioId(itinerarioId,categoriaId);

    }

    public List<CategoriaDTO> getCategorias(String dbType){

        utils.establecerBaseDatos(dbType);

        return categoriaRepository.getCategorias();

    }

    public RequisicionEntity guardarReporteMecanico(ReporteMecanicoDTO reporte, String dbType)  {

        utils.establecerBaseDatos(dbType);

        if(validador.esObjetoInvalido(reporte)){

            return null;
        }
        
        RequisicionEntity requisicion = deserealizarDTO(reporte);

        RequisicionEntity requisicionSaved =  guardarRequisicion(requisicion,dbType);

        int tipoDeFalla = requisicionSaved.getTipo();
        int requisicionId = validador.toInt(requisicionSaved.getRequisicionId());

        procesarGuardadoFallaMantenimiento(tipoDeFalla,requisicionId,dbType);

        return requisicionSaved;

    }

    private void procesarGuardadoFallaMantenimiento(int fallaId, int requisicionId,String dbType){

        if(validador.esObjetoInvalido(fallaId) || validador.esObjetoInvalido(requisicionId)){

            return;
        }

        FallasMantenimientoEntity fallasMantenimiento = FallasMantenimientoEntity.builder()
        .fallaId(fallaId)
        .requisicionId(requisicionId)
        .build();

        guardarFallaMantenimiento(fallasMantenimiento,dbType);

    }

    private void guardarFallaMantenimiento(FallasMantenimientoEntity fallasMantenimiento,String dbType){

        if(validador.esObjetoInvalido(fallasMantenimiento)){

            return;
        }

        utils.establecerBaseDatos(dbType);

        fallasRepository.save(fallasMantenimiento);
    }

    private RequisicionEntity guardarRequisicion(RequisicionEntity requisicion,String dbType){

        utils.establecerBaseDatos(dbType);

        RequisicionEntity requisicionSaved =  reporteRepository.save(requisicion);

        return requisicionSaved;
    }

    private RequisicionEntity deserealizarDTO(ReporteMecanicoDTO reporte){

        return RequisicionEntity.builder()
        .camionId(reporte.getCamionId())
        .categoriaId(reporte.getCategoriaId())
        .choferId(reporte.getChoferId())
        .descripcion(reporte.getDescripcion())
        .odometro(reporte.getOdometro())
        .itinerarioId(reporte.getItinerarioId())
        .subtipo(reporte.getSubtipo())
        .tipo(reporte.getTipo())
        .status(true)
        .fecha(LocalDateTime.now().minusHours(8))
        .fechaRegistro(LocalDateTime.now().minusHours(8))
        .build();
    }



}
