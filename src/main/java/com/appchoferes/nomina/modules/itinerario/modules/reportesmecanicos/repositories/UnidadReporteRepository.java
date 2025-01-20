package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.DTO.UnidadReporteDTO;

@Repository
public interface UnidadReporteRepository extends CrudRepository<UnidadReporteDTO,Long>{

    @Query(value = "CALL REP_MEC_getUnidadByItinerarioId(:itinerarioId,:categoriaId);", nativeQuery = true)
    public List<UnidadReporteDTO> getUnidadesByItinerarioId(int itinerarioId, int categoriaId);

}
