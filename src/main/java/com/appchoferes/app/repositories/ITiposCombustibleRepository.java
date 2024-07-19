package com.appchoferes.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appchoferes.app.dtos.TipoCombustible;

@Repository
public interface ITiposCombustibleRepository extends JpaRepository<TipoCombustible,Long> {

   @Query(value = "CALL `TIPO_COMBUSTIBLE_SP`();", nativeQuery = true)
   public List<TipoCombustible> getTipoCombustible();

}

