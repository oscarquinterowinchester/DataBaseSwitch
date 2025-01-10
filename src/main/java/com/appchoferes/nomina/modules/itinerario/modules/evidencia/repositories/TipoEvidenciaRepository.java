package com.appchoferes.nomina.modules.itinerario.modules.evidencia.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.evidencia.DTO.TipoEvidenciaDTO;

@Repository
public interface TipoEvidenciaRepository extends CrudRepository<TipoEvidenciaDTO,Long>
{

    @Query(value = "CALL DM_getTipoEvidencias();", nativeQuery = true)
    public List<TipoEvidenciaDTO> getTipoEvidencias();

}
