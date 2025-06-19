package edu.senairs.api_requisicoes.test.entidades;

import edu.senairs.api_requisicoes.test.entidades.teste.Requerimento;

import java.util.List;

public class Aluno extends Usuario{
    public Aluno(String nome, String email) {
        super(nome, email);
    }

    @Override
    public List<Requerimento> listarRequerimentos() {
        return List.of();
    }

    @Override
    public void solicitarRequerimento() {

    }

    @Override
    public void arquivarRequerimento() {

    }

    @Override
    public void avancarRequerimento() {

    }

    @Override
    public void retrocederRequerimento() {

    }

    @Override
    public void adicionarComentario() {

    }
}
