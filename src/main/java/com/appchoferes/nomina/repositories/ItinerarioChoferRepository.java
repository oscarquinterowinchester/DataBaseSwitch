package com.appchoferes.nomina.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.appchoferes.nomina.dtos.ItinerarioChofer;

public interface ItinerarioChoferRepository extends CrudRepository<ItinerarioChofer,Long>{

    @Query(value = "CALL DM_getItinerarioChofer(:choferId);", nativeQuery = true)
    public List<ItinerarioChofer> getItinerarioChofer(String choferId);

    @Query(value = "CALL DM_setItinerarioAsVisto(:itinerarioId);", nativeQuery = true)
    public int setItinerarioAsVisto(String itinerarioId);


}
