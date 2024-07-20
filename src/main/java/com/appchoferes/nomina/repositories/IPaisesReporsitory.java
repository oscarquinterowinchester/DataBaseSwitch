package com.appchoferes.nomina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.Pais;
@Repository
public interface IPaisesReporsitory extends JpaRepository<Pais,Long>{
    @Query(value = "CALL `PAISES_TBL_SP`();",nativeQuery = true)
    public List<Pais> getPaises();
}


