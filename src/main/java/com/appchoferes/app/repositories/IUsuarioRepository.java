package com.appchoferes.app.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.app.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

}
