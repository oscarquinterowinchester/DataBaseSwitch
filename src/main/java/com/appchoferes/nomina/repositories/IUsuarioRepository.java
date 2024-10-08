package com.appchoferes.nomina.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appchoferes.nomina.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Integer> {

}
