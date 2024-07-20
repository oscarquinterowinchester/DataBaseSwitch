package com.appchoferes.nomina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.dtos.CajaCarga;
import com.appchoferes.nomina.dtos.CamionCarga;

@Repository
public interface ICajaCargaRepository extends JpaRepository<CajaCarga,Long>{
 @Query(value = "CALL `CAJAS_COMBUSTIBLE_SP`(:choferId);", nativeQuery = true)
    public CajaCarga getCajaCarga(String choferId);
}
