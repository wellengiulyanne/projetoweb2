package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
