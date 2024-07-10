package com.appchoferes.nomina.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.Nomina;

@Repository
public interface INominaRepository extends JpaRepository<Nomina, Long>{
    @Query(value = "CALL `NOMINA_PAGO-SEMANAL_SP`(:week, :choferID);", nativeQuery = true)
    public List<Nomina> getNominas(String week, Long choferID);
}
