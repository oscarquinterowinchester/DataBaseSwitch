package com.appchoferes.nomina.modules.nomina.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.modules.nomina.models.NominaEntity;

@Repository
public interface NominaRepository extends JpaRepository<NominaEntity, Long>{

    @Query(value = "CALL `NOMINA_PAGO-SEMANAL_SP`(:week, :choferID);", nativeQuery = true)
    public List<NominaEntity> getNominas(String week, Long choferID);


    @Query(value = "CALL getDescuentoByChofer(:week, :choferID,:itinerarioId);", nativeQuery = true)
    public float getDescuento(String week, String choferID,String itinerarioId);

}
