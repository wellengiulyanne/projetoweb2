package br.ueg.trindade.projetoweb2ueg_projeto_fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.model.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long> {
}
