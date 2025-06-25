package edu.senairs.api_requisicoes.dominio;

import java.util.List;

public abstract class Usuario {
    String nome;
    String email;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract List<Requerimento> listarRequerimentos();
    public abstract void solicitarRequerimento();
    public abstract void arquivarRequerimento();
    public abstract void avancarRequerimento();
    public abstract void retrocederRequerimento();
    public abstract void adicionarComentario();

}
