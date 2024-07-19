package com.appchoferes.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.app.dtos.Vencimiento;

@Repository
public interface IVencimientoRepository extends JpaRepository<Vencimiento,Long>{

    @Query(value = "CALL `VENCIMIENTOS_SP`(:choferID);", nativeQuery = true)
    public List<Vencimiento> getVencimientos(String choferID);
} 
