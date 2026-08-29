package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api")
public class Api {
    
@GetMapping("/usuarios")
public List<Usuario> getAllUsuariosWithClass() {
List<Usuario> users = new ArrayList<>();
users.add(new Usuario("João","joao123","senha123","joao@example.com"));

users.add(new Usuario("Maria","maria456","senha456","maria@example.com"));

return users;
}

@GetMapping("/permissao")
public List<Permissao> listarPermissao() {
    return Arrays.asList(
        new Permissao(1L, "ADMIN", "Administrador"),
        new Permissao(2L, "USUARIO", "Usuário comum")
    );
}

@GetMapping("/perfis")
public List<Perfil> listarPerfis() {
    return Arrays.asList(
        new Perfil(1L, "Administrador"),
        new Perfil(2L, "Usuário")
    );
}  
}



