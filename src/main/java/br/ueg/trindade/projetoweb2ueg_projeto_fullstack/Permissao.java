package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Permissao {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
Long id;

String nome;
String descricao;

public Permissao () {}


public Permissao(Long id, String nome, String descricao) {
    this.id = id;
    this.nome = nome;
    this.descricao = descricao;
}

public void setId(Long id) {
    this.id = id;
}

public void setNome(String nome) {
    this.nome = nome;
}

public void setDescricao(String descricao) {
    this.descricao = descricao;
}

public Long getId() {
    return id;
}

public String getNome() {
    return nome;
}

public String getDescricao() {
    return descricao;
}
}
