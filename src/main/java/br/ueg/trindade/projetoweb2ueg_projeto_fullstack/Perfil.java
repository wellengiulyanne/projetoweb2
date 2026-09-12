package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Perfil {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

public Perfil () {}

    public Perfil(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}