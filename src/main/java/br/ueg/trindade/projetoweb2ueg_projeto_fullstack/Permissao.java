package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;

public class Permissao {
Long id;
String nome;
String descricao;

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
