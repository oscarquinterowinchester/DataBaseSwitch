package com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.modules.itinerario.modules.revisionmecanica.models.PuntosRevisionEntity;

@Repository
public interface PuntosRevisionMecanicaRepository extends CrudRepository<PuntosRevisionEntity,Long>{



}
