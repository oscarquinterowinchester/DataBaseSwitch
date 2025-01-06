package com.appchoferes.nomina.modules.nomina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.modules.nomina.dto.SemanasNominaDTO;

@Repository
public interface SemanasNominaRepository extends CrudRepository<SemanasNominaDTO,Long> {

    @Query(value = "CALL nomina_semanasAnio();", nativeQuery = true)
    public List<SemanasNominaDTO> getSemanasNomina();

}
