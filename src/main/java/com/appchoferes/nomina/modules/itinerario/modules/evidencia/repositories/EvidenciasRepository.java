package com.appchoferes.nomina.modules.itinerario.modules.evidencia.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.evidencia.models.EvidenciasEntity;

@Repository
public interface EvidenciasRepository extends CrudRepository<EvidenciasEntity,Long>{

    public <Optional>EvidenciasEntity getEvidenciasEntityByFileId(Long fileId);


    // @Query(value = "SELECT DM_getWContIdByItinerarioId(:itinerarioId);", nativeQuery = true)
    // public List<EvidenciasEntity> getEvidenciasEntityByItinerinerioId();

    @Query(value = "CALL getExtrasByItinerarioId(:itinerarioId);", nativeQuery = true)
    public List<EvidenciasEntity> getEvidenciasByItinerarioId(int itinerarioId);

    @Query(value = "SELECT DM_getWContIdByItinerarioId(:itinerarioId);", nativeQuery = true)
    public int getWContIdByItinerarioId(int itinerarioId);

}
