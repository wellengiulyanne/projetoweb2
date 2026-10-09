
package br.ueg.trindade.projetoweb2ueg_projeto_fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.model.Usuario;
import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.service.UsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criar(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.listarTodos();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.buscarPorId(id);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario updateUsuario(
            @PathVariable Long id,
            @RequestBody Usuario usuarioAtualizado) {
        return usuarioService.atualizar(id, usuarioAtualizado);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.excluir(id);
    }
}
