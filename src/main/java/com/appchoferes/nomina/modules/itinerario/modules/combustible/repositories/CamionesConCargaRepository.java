package com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.modules.itinerario.modules.combustible.DTO.CamionesConCargaDTO;
// import com.appchoferes.nomina.modules.combustible.models.Camion;


@Repository
public interface CamionesConCargaRepository extends JpaRepository<CamionesConCargaDTO, Long> {

    // @Query(value = "call com_getCamionesTablaDiesel()", nativeQuery = true)
    // List<Object[]> getCamionesConCargasRaw();
    
    @Query(value = "call com_getCamion(:id)", nativeQuery = true)
    CamionesConCargaDTO getCamionRaw(@Param("id") Long id);

}
