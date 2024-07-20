package com.appchoferes.nomina.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.appchoferes.nomina.dtos.Estado;

@Repository
public interface IEstadosRepository extends JpaRepository<Estado,Long>{

    @Query(value = "CALL `ESTADOS_TBL_SP`();",nativeQuery = true)
    public List<Estado> getEstados();
}
