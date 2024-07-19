package com.appchoferes.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.app.models.CargasDieselEntity;
import java.util.List;


@Repository
public interface ICargaDiesel extends JpaRepository<CargasDieselEntity,Long> {

    public List<CargasDieselEntity> findByCargaId(Integer cargaId);

}
