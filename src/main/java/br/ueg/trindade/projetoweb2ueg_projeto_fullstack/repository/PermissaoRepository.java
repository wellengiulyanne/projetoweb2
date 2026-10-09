package br.ueg.trindade.projetoweb2ueg_projeto_fullstack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ueg.trindade.projetoweb2ueg_projeto_fullstack.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
