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
import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.model.Permissao;
import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.repository.PermissaoRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")

public class PermissaoController { 
    @Autowired
    private PermissaoRepository permissaoRepository;

    @GetMapping("/permissao")

    @Autowired
    public List<Permissao> getAllPermissao() {
        return permissaoRepository.findAll();
    }

    @PostMapping("/permissao")
    public Permissao createPermissao(@RequestBody Permissao permissao) {
        return permissaoRepository.save(permissao);
    }

    // READ — por id
    @GetMapping("/permissao/{id}")
    public Permissao getPermissaoById(@PathVariable Long id) {
        return permissaoRepository.findById(id).orElseThrow(() -> new RuntimeException("Permissão não encontrada"));
    }

    // UPDATE
    @PutMapping("/permissao/{id}")
    public Permissao updatePermissao(@PathVariable Long id, @RequestBody Permissao permissaoAtualizada) {
        Permissao permissao = permissaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Permissão não encontrada"));
        permissao.setNome(permissaoAtualizada.getNome());
        permissao.setDescricao(permissaoAtualizada.getDescricao());
        return permissaoRepository.save(permissao);
    }

    // DELETE
    @DeleteMapping("/permissao/{id}")
    public void deletePermissao(@PathVariable Long id) {
        permissaoRepository.deleteById(id);
    }
}