
package br.ueg.trindade.projetoweb2ueg_projeto_fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.model.Permissao;
import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.service.PermissaoService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class PermissaoController {

    @Autowired
    private PermissaoService permissaoService;

    @GetMapping("/permissao")
    public List<Permissao> getAllPermissao() {
        return permissaoService.listarTodos();
    }

    @PostMapping("/permissao")
    public Permissao createPermissao(@RequestBody Permissao permissao) {
        return permissaoService.criar(permissao);
    }

    @GetMapping("/permissao/{id}")
    public Permissao getPermissaoById(@PathVariable Long id) {
        return permissaoService.buscarPorId(id);
    }

    @PutMapping("/permissao/{id}")
    public Permissao updatePermissao(
            @PathVariable Long id,
            @RequestBody Permissao permissaoAtualizada) {
        return permissaoService.atualizar(id, permissaoAtualizada);
    }

    @DeleteMapping("/permissao/{id}")
    public void deletePermissao(@PathVariable Long id) {
        permissaoService.excluir(id);
    }
}
