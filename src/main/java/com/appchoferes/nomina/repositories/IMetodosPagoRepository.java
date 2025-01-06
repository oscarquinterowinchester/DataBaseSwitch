package com.appchoferes.nomina.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.dtos.MetodoPago;


@Repository
public interface IMetodosPagoRepository extends CrudRepository<MetodoPago,Long>{
    @Query(value = "CALL `com_getMetodosPago`();",nativeQuery = true)
    public List<MetodoPago> getMetodosPago();
}
