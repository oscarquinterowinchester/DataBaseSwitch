package com.appchoferes.nomina.modules.itinerario.modules.combustible.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.combustible.models.CargasDieselEntity;

@Repository
public interface CombustibleCargasDieselRepository extends JpaRepository<CargasDieselEntity, Long> {

    @Query(value = "call com_getCombustibleHistorial(:id, :tipo)", nativeQuery = true)
    List<Object []> getHistorialCargas(Long id, Integer tipo);

    @Query(value = "call com_getHistorialAnterior(:id, :fechaActual)", nativeQuery = true)
    List<Object []> getHistorialAnterior(Long id, String fechaActual);

    // @Query(value = "call com_insertarCargaDiesel(:cargaDiesel)", nativeQuery = true)
    // @Modifying 
    // @Transactional
    // void insertarCargaDiesel(@Param("cargaDiesel") CargasDieselEntity cargaDiesel);
}
