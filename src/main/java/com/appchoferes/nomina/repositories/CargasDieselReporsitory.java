package com.appchoferes.nomina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.CargasDieselEntity;
import java.util.List;


@Repository
public interface CargasDieselReporsitory extends JpaRepository<CargasDieselEntity,Long> {
    public  CargasDieselEntity findByCargaId(Integer cargaId);

    @Query(value = "SELECT obtenerUltimoOdometroCarga(:unidadId, :tipoUnidad, :tipoOperacion) FROM dual", nativeQuery = true)
    public String obtenerUltimoOdometro(String unidadId, Integer tipoUnidad, Integer tipoOperacion);
    //TipoOperacion 0 para insert, 1 para update

    @Query(value = "SELECT obtenerUltimaFechaCargaCombustible(:unidadId, :tipoUnidad, :tipoOperacion) FROM dual", nativeQuery = true)
    public String obtenerUltimaFecha(String unidadId, int tipoUnidad, int tipoOperacion);

    @Query(value = "SELECT esPrimerRegistro_Combustible(:unidadId, :tipo) FROM dual", nativeQuery = true)
    public boolean esPrimerRegistro(Integer unidadId, Integer tipo);
    
}
