
package br.ueg.trindade.projetoweb2ueg_projeto_fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.model.Perfil;
import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.service.PerfilService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class PerfilController {

    @Autowired
    private PerfilService perfilService;

    @GetMapping("/perfil")
    public List<Perfil> getAllPerfil() {
        return perfilService.listarTodos();
    }

    @PostMapping("/perfil")
    public Perfil createPerfil(@RequestBody Perfil perfil) {
        return perfilService.criar(perfil);
    }

    @GetMapping("/perfil/{id}")
    public Perfil getPerfilById(@PathVariable Long id) {
        return perfilService.buscarPorId(id);
    }

    @PutMapping("/perfil/{id}")
    public Perfil updatePerfil(
            @PathVariable Long id,
            @RequestBody Perfil perfilAtualizado) {
        return perfilService.atualizar(id, perfilAtualizado);
    }

    @DeleteMapping("/perfil/{id}")
    public void deletePerfil(@PathVariable Long id) {
        perfilService.excluir(id);
    }
}
