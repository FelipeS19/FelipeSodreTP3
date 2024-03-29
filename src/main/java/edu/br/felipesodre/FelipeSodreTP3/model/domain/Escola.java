package edu.br.felipesodre.FelipeSodreTP3.model.domain;

import java.util.List;

public class Escola {
    private int id;
    private String nome;
    private List<Professor> professores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

