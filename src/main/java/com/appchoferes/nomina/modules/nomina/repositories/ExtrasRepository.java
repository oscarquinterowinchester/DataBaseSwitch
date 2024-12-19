package com.appchoferes.nomina.modules.nomina.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.appchoferes.nomina.modules.nomina.dto.ExtrasDTO;



public interface ExtrasRepository extends JpaRepository<ExtrasDTO, Long> {

    @Query(value = "CALL NOMINA_getExtraNomina(:itinerarioId);", nativeQuery = true)
    public List<ExtrasDTO> getExtras(Long itinerarioId);

}
