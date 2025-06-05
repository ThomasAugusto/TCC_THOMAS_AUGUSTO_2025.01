package edu.senairs.api_requisicoes.entidades.processos.trancamentoDeMatricula;

import edu.senairs.api_requisicoes.entidades.Cursos;

public class TrancamentoMatricula {
    String nomeProcesso;
    Integer numeroSemestresAfastado;
    String motivosAfastamento;
    Cursos curso;
    EstadoTDM estadoProcesso;

    public TrancamentoMatricula(Integer numeroSemestresAfastado, String motivosAfastamento,
                                Cursos curso) {
        this.nomeProcesso = "Trancamento de matrícula";
        this.numeroSemestresAfastado = numeroSemestresAfastado;
        this.motivosAfastamento = motivosAfastamento;
        this.curso = curso;
        this.estadoProcesso = new SolicitarTDM();
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    public Integer getNumeroSemestresAfastado() {
        return numeroSemestresAfastado;
    }

    public void setNumeroSemestresAfastado(Integer numeroSemestresAfastado) {
        this.numeroSemestresAfastado = numeroSemestresAfastado;
    }

    public String getMotivosAfastamento() {
        return motivosAfastamento;
    }

    public void setMotivosAfastamento(String motivosAfastamento) {
        this.motivosAfastamento = motivosAfastamento;
    }

    public Cursos getCurso() {
        return curso;
    }

    public void setCurso(Cursos curso) {
        this.curso = curso;
    }

    public EstadoTDM getEstadoProcesso() {
        return estadoProcesso;
    }

    public void setEstadoProcesso(EstadoTDM estadoProcesso) {
        this.estadoProcesso = estadoProcesso;
    }

    // metodos de transição de estado
    public void processoSolicitado(){
        estadoProcesso.processoSolicitado(this);
    }
    public void complementarDados(){
        estadoProcesso.complementarDados(this);
    }
    public void deferirEmCoordenacao() {
        estadoProcesso.deferirEmCoordenacao(this);
    }

    public void verificarPendenciasBiblioteca() {
        estadoProcesso.verificarPendenciasBiblioteca(this);
    }

    public void executarProcessosFinanceiros() {
        estadoProcesso.executarProcessosFinanceiros(this);
    }

    public void arquivarProcesso() {
        estadoProcesso.arquivarProcesso(this);
    }

    @Override
    public String toString() {
        return "TrancamentoMatricula\n{" +
                "nomeProcesso='" + nomeProcesso + '\'' +
                ",\n numeroSemestresAfastado=" + numeroSemestresAfastado +
                ",\n motivosAfastamento='" + motivosAfastamento + '\'' +
                ",\n curso=" + curso.getDescricao() +
                ",\n estadoProcesso=" + estadoProcesso.getClass().getSimpleName() +
                '}';
    }
}
