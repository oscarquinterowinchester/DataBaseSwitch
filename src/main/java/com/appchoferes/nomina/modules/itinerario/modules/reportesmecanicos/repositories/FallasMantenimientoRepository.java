package com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.modules.itinerario.modules.reportesmecanicos.models.FallasMantenimientoEntity;

@Repository
public interface FallasMantenimientoRepository extends CrudRepository<FallasMantenimientoEntity,Long>{

    

}
