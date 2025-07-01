package edu.senairs.api_requisicoes.dominio.usuarios;

import edu.senairs.api_requisicoes.dominio.Cursos;
import edu.senairs.api_requisicoes.dominio.Requerimento;
import edu.senairs.api_requisicoes.dominio.processos.cancelamentoDeMatricula.CancelamentoMatricula;
import edu.senairs.api_requisicoes.dominio.processos.trancamentoDeMatricula.TrancamentoMatricula;

import java.util.List;

public class Aluno extends Usuario {

    private String cpf;
    private String telefone;
    private Cursos curso;
    private int semestre;
    private String motivos;


    public Aluno(String nome, String email, String tipoUsuario, String cpf, String telefone,
                                                    Cursos curso, int semestre, String motivos) {
        super(nome, email, tipoUsuario);
        this.cpf = cpf;
        this.telefone = telefone;
        this.curso = curso;
        this.semestre = semestre;
        this.motivos = motivos;
    }

    public Aluno(String nome, String email, String curso) {
        super(nome, email, curso);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public String getMotivos() {
        return motivos;
    }

    public void setMotivos(String motivos) {
        this.motivos = motivos;
    }

    @Override
    public List<Requerimento> listarRequerimentos(String tipoUsuario) {
        return List.of();
    }

    @Override
    public void solicitarRequerimento() {
        TrancamentoMatricula tdm = new TrancamentoMatricula(2, getMotivos(), getCurso());
    }

    @Override
    public void arquivarRequerimento(String tipoUsuario) {

    }

    @Override
    public void avancarRequerimento(String tipoUsuario) {

    }

    @Override
    public void complementarDadosRequerimento(String tipoUsuario) {

    }

    @Override
    public void adicionarComentario() {

    }
}
