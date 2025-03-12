package br.uniesp.si.techback.controller;

import br.uniesp.si.techback.model.Usuario;
import br.uniesp.si.techback.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioservice;

    @PostMapping
    public Usuario incluir(Usuario usuario) {
        return usuarioservice.cadastrar(usuario);
    }
    @GetMapping
    public List<Usuario> listar() {
        return usuarioservice.listar();
    }

    @PutMapping
    public Usuario alterar (Usuario usuario) {
        return usuarioservice.alterar(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(Integer id) {
        usuarioservice.excluir(id);
        return ResponseEntity.ok().build();

    }
}