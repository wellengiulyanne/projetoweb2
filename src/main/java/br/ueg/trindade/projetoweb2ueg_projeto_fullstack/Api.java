package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;

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

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class Api {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/usuarios")
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // READ — por id
    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id)

                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    }

    // UPDATE
    @PutMapping("/usuarios/{id}")
    public Usuario updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
        Usuario usuario = usuarioRepository.findById(id)

                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setUsername(usuarioAtualizado.getUsername());
        usuario.setEmail(usuarioAtualizado.getEmail());
        return usuarioRepository.save(usuario);
    }

    // DELETE
    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }

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
