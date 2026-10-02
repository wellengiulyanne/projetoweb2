package br.ueg.trindade.projetoweb2ueg_projeto_fullstack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.model.Perfil;
import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.repository.PerfilRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")

public class PerfilController {
      @Autowired
    private PerfilRepository perfilRepository;

    @GetMapping("/perfil")
    public List<Perfil> getAllPerfil() {
        return perfilRepository.findAll();
    }

    @PostMapping("/perfil")
    public Perfil createPerfil(@RequestBody Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    // READ — por id
    @GetMapping("/perfil/{id}")
    public Perfil getPerfilById(@PathVariable Long id) {
        return perfilRepository.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
    }

    // // UPDATE
    @PutMapping("/perfil/{id}")
    public Perfil updatePerfil(@PathVariable Long id, @RequestBody Perfil perfilAtualizado) {
        Perfil perfil = perfilRepository.findById(id).orElseThrow(() -> new RuntimeException("Perfil não encontrado"));
        perfil.setNome(perfilAtualizado.getNome());
        return perfilRepository.save(perfil);
    }

    // DELETE
    @DeleteMapping("/perfil/{id}")
    public void deletePerfil(@PathVariable Long id) {
        perfilRepository.deleteById(id);
    }
}

    

