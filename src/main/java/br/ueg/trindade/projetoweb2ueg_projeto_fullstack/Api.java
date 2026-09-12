package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class Api {
    
@Autowired
private UsuarioRepository usuarioRepository;


@GetMapping("/usuarios")
public List<Usuario> getAllUsuarios() {
return usuarioRepository.findAll();
}
@PostMapping("/usuarios")
public Usuario createUsuario(@RequestBody Usuario usuario) {
return usuarioRepository.save(usuario);
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
}



