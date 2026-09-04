package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private String nome;
private String username;
@JsonIgnore
private String senha;
private String email;

public Usuario () {}


public Usuario(String nome, String username, String senha, String email) {
    this.nome = nome;
    this.username = username;
    this.senha = senha;
    this.email = email;
}
public Long getId() {
    return id;
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
public void setId(Long id) {
    this.id = id;
}

}
