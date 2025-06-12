package edu.senairs.api_requisicoes.entidades.teste.entidades;

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
    public abstract void selecionarRequerimento();
    public abstract void arquivarRequerimento();
    public abstract void avancarRequerimento();
    public abstract void retrocederRequerimento();
    public abstract List<Processo> listarProcessos();
    public abstract void selecionarProcesso();
    public abstract void adicionarComentario();

}
