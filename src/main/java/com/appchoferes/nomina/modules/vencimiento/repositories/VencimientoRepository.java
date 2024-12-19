package com.appchoferes.nomina.modules.vencimiento.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.modules.vencimiento.models.VencimientoEntity;

@Repository
public interface VencimientoRepository extends CrudRepository<VencimientoEntity,Long>{

    @Query(value = "CALL `VEN_VENCIMIENTOS_SP`(:choferID);", nativeQuery = true)
    public List<VencimientoEntity> getVencimientos(String choferID);

} 
