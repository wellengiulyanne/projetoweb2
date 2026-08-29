package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Usuario {
private String nome;
private String username;
@JsonIgnore
private String senha;
private String email;




public Usuario(String nome, String username, String senha, String email) {
    this.nome = nome;
    this.username = username;
    this.senha = senha;
    this.email = email;
}
public String getNome() {
    return nome;
}
public String getUsername() {
    return username;
}
public String getSenha() {
    return senha;
}
public String getEmail() {
    return email;
}
public void setNome(String nome) {
    this.nome = nome;
}
public void setUsername(String username) {
    this.username = username;
}
public void setSenha(String senha) {
    this.senha = senha;
}
public void setEmail(String email) {
    this.email = email;
}
}
