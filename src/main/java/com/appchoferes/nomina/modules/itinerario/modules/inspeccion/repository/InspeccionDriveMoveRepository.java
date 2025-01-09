package com.appchoferes.nomina.modules.itinerario.modules.inspeccion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.models.InspeccionDriverMoveEntity;

@Repository
public interface InspeccionDriveMoveRepository extends CrudRepository<InspeccionDriverMoveEntity,Long>{


    public List<InspeccionDriverMoveEntity> getInspeccionDriverMoveDTOByItinerarioId(int itinerarioId);

    public InspeccionDriverMoveEntity getInspeccionDriverMoveEntityByInspeccionId(Long inspeccionId);

}
