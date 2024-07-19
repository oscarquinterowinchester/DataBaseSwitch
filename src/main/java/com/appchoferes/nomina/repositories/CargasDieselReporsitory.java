package com.appchoferes.nomina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.CargasDieselEntity;
import java.util.List;


@Repository
public interface CargasDieselReporsitory extends JpaRepository<CargasDieselEntity,Long> {
    public  List<CargasDieselEntity> findByCargaId(Integer cargaId);

    
}
