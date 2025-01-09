package com.appchoferes.nomina.modules.itinerario.modules.inspeccion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.modules.itinerario.modules.inspeccion.DTO.ListaInspeccionChoferDTO;

@Repository
public interface ListaInspeccionChoferRepository extends CrudRepository<ListaInspeccionChoferDTO,Long>{

    @Query(value = "CALL DM_getListaInspeccionItinerario(:itinerarioId);", nativeQuery = true)
    public <Optional>List<ListaInspeccionChoferDTO> getListaInspeccionByItinerario(int itinerarioId);

}
