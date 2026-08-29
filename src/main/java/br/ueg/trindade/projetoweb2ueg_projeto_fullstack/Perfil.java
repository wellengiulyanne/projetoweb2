package br.ueg.trindade.projetoweb2ueg_projeto_fullstack;

public class Perfil {

    private Long id;
    private String nome;

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