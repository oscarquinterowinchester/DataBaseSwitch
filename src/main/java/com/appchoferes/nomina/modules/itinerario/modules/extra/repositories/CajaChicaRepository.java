package com.appchoferes.nomina.modules.itinerario.modules.extra.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appchoferes.nomina.modules.itinerario.modules.extra.models.CajaChicaEntity;

public interface CajaChicaRepository extends JpaRepository<CajaChicaEntity, Integer> {

    @Query(value = "SELECT * FROM cajachica_tbl WHERE ItinerarioID = :itinerarioId AND status = true", nativeQuery = true)
    List<CajaChicaEntity> findByItinerarioId(@Param("itinerarioId") Integer itinerarioId);
    
    @Query(value = "CALL EXTRA_deleteCajaChica(:cajaId);", nativeQuery = true)
    public int deleteByCajaId(Integer cajaId);

    @Query(value = "SELECT getMonedaPagoExtraDin(:cajaId);", nativeQuery = true)
    public int getMonedaPagoExtraDin(int cajaId);

    @Query(value = "SELECT getPagoExtraDin(:cajaId);", nativeQuery = true)
    public float getPagoExtraDin(int cajaId);

    public CajaChicaEntity getCajaChicaEntityByCajaChicaId(int cajaChicaId);

    @Query(value = "SELECT CargoID as id, Nombre as nombre, ImporteBase as importe " +
                   "FROM conceptoscargoschoferes_tbl " +
                   "WHERE status = true", nativeQuery = true)
    List<Map<String, Object>> findConceptosActivos();





}
