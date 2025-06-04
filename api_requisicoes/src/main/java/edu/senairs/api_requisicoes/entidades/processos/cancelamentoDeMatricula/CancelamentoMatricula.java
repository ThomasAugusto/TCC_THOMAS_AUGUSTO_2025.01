package edu.senairs.api_requisicoes.entidades.processos.cancelamentoDeMatricula;

import edu.senairs.api_requisicoes.entidades.Cursos;

public class CancelamentoMatricula {
    String nomeProcesso;
    String motivosCancelamento;
    Cursos curso;
    EstadoCDM estadoProcesso;

    public CancelamentoMatricula(String motivosCancelamento, Cursos curso, EstadoCDM estadoProcesso) {
        this.nomeProcesso = "Cancelamento de matrícula";
        this.motivosCancelamento = motivosCancelamento;
        this.curso = curso;
        this.estadoProcesso = new SolicitarCDM();
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    public String getMotivosCancelamento() {
        return motivosCancelamento;
    }

    public void setMotivosCancelamento(String motivosCancelamento) {
        this.motivosCancelamento = motivosCancelamento;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public EstadoCDM getEstadoProcesso() {
        return estadoProcesso;
    }

    public void setEstadoProcesso(EstadoCDM estadoProcesso) {
        this.estadoProcesso = estadoProcesso;
    }
}
