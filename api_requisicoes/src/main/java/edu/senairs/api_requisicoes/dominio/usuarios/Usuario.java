package edu.senairs.api_requisicoes.dominio.usuarios;

import edu.senairs.api_requisicoes.dominio.Requerimento;

import java.util.List;

public abstract class Usuario {
    String nome;
    String email;
    String tipoUsuario;

    public Usuario(String nome, String email,  String tipoUsuario) {
        this.nome = nome;
        this.email = email;
        this.tipoUsuario = tipoUsuario;
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

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public abstract List<Requerimento> listarRequerimentos(String tipoUsuario);
    public abstract void solicitarRequerimento();
    public abstract void arquivarRequerimento(String tipoUsuario);
    public abstract void avancarRequerimento(String tipoUsuario);
    public abstract void complementarDadosRequerimento(String tipoUsuario);
    public abstract void adicionarComentario();

}
