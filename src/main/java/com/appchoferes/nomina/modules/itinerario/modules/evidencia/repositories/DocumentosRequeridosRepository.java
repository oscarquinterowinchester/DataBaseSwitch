package com.appchoferes.nomina.modules.itinerario.modules.evidencia.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.modules.itinerario.modules.evidencia.DTO.DocumentosRequeridosDTO;

@Repository
public interface DocumentosRequeridosRepository extends CrudRepository<DocumentosRequeridosDTO,Long>{

    @Query(value = "SELECT getDocsObligatoriosIti(:itinerarioId)", nativeQuery = true)
   public String getDocumentosRequeridos(int itinerarioId);
   
   
}
