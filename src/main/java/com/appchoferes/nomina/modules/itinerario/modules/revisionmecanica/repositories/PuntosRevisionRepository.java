package com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.DTO.PuntosRevisionDTO;

@Repository
public interface PuntosRevisionRepository extends CrudRepository<PuntosRevisionDTO,Long>{

    @Query(value = "CALL REV_getPuntoRevisicionCamion();", nativeQuery = true)
    public List<PuntosRevisionDTO> getPuntosRevision();

}
