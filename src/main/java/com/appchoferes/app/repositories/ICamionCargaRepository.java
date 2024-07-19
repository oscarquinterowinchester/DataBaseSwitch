package com.appchoferes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.app.dtos.CamionCarga;

@Repository
public interface ICamionCargaRepository extends JpaRepository<CamionCarga,Long> {
    @Query(value = "CALL `VISTA_CAMIONCARGA`(:choferId);", nativeQuery = true)
    public CamionCarga getCamionCarga(String choferId);
}
