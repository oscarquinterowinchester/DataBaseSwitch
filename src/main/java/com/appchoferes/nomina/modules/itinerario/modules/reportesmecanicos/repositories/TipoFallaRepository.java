package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO.TipoFallaDTO;

@Repository
public interface TipoFallaRepository extends CrudRepository<TipoFallaDTO,Long>{

    @Query(value = "CALL REP_MEC_getTipoFallas();", nativeQuery = true)
    public List<TipoFallaDTO> getTiposFalla();

}
