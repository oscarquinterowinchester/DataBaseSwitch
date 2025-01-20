package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO.CategoriaDTO;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaDTO,Long>{

    @Query(value = "CALL REP_MEC_getCategorias();", nativeQuery = true)
    public List<CategoriaDTO> getCategorias();

}
