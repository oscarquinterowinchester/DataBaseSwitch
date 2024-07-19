package com.appchoferes.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appchoferes.app.config.DatabaseContextHolder;
import com.appchoferes.app.models.Usuario;
import com.appchoferes.app.repositories.IUsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public List<Usuario> findAll(String dbType) {
        DatabaseContextHolder.setDatabaseType(dbType);
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> findById(Integer id, String dbType) {
        DatabaseContextHolder.setDatabaseType(dbType);
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario, String dbType) {
        DatabaseContextHolder.setDatabaseType(dbType);
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Integer id, String dbType) {
        DatabaseContextHolder.setDatabaseType(dbType);
        usuarioRepository.deleteById(id);
    }

    // Otros métodos de servicio
}