package com.appchoferes.nomina.modules.itinerario.modules.evidencia.repositories;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.evidencia.models.EvidenciasEntity;

@Repository
public interface EvidenciasRepository extends CrudRepository<EvidenciasEntity,Long>{



    // public List<EvidenciasEntity> getAllEvidenciasEntity();

    public <Optional>EvidenciasEntity getEvidenciasEntityByFileId(Long fileId);

    @Query(value = "SELECT DM_getWContIdByItinerarioId(:itinerarioId);", nativeQuery = true)
    public int getWContIdByItinerarioId(int itinerarioId);

    

}
