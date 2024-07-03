package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import models.Usuario;
import services.UsuarioService;

import java.util.List;
import java.util.Optional;


@RestController 
@RequestMapping("/")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping()
    public String mensaje1(@RequestParam String dbType) {
        return "Hola mundoooooo";
    }
    @GetMapping("/hola")
    static public String mensaje(@RequestParam String dbType) {
        return "Hola mundo: " + dbType;
    }

    @GetMapping
    public List<Usuario> getAllUsuarios(@RequestParam String dbType) {
        return usuarioService.findAll(dbType);
    }

    @GetMapping("/{id}")
    public Optional<Usuario> getUsuarioById(@PathVariable Integer id, @RequestParam String dbType) {
        return usuarioService.findById(id, dbType);
    }

    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario, @RequestParam String dbType) {
        return usuarioService.save(usuario, dbType);
    }

    @PutMapping("/{id}")
    public Usuario updateUsuario(@PathVariable Integer id, @RequestBody Usuario usuario, @RequestParam String dbType) {
        usuario.setUsuarioId(id);
        return usuarioService.save(usuario, dbType);
    }

}