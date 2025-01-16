package com.appchoferes.nomina.modules.itinerario.modules.sello.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.sello.models.SelloEntity;
@Repository
public interface SelloRepository extends CrudRepository<SelloEntity,Long>{


    public SelloEntity getSelloEntityBySelloId(Long selloID);

    @Query(value = "CALL SELLO_cargarSellosByItinerarioId(:itinerarioId);", nativeQuery = true)
    public List<SelloEntity> getSellosByItinerarioId(int itinerarioId);

    @Query(value = "SELECT SELLO_getClienteSelloByItinearioId(:itinerarioId);", nativeQuery = true)
    public int getClienteSelloByItinearioId(int itinerarioId);


}
