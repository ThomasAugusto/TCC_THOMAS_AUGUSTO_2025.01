package edu.senairs.api_requisicoes.dominio.processos.trancamentoDeMatricula;

import edu.senairs.api_requisicoes.dominio.Cursos;

public class TrancamentoMatricula {
    String nomeProcesso;
    Integer numeroSemestresAfastado;
    String motivosAfastamento;
    Cursos curso;
    EstadoTDM estadoProcesso;
//    Aluno aluno;
//    Secretaria secretaria;
//    Coordenacao coordenacao;
//    Biblioteca biblioteca;
//    Financeiro financeiro;

    // O TrancamentoMatricula podera ser instanciado pelas entidades Aluno ou Secretaria

    public TrancamentoMatricula(Integer numeroSemestresAfastado, String motivosAfastamento,
                                Cursos curso) {
        this.nomeProcesso = "Trancamento de matrícula";
        this.numeroSemestresAfastado = numeroSemestresAfastado;
        this.motivosAfastamento = motivosAfastamento;
        this.curso = Cursos.valueOf(curso.getDescricao());
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

    /* Este metodo e invocado quando ha a necessidade do Aluno complementar dados, apos a complementacao devolve o
    processo a Secretaria */
    public void processoSolicitado(){
        estadoProcesso.processoSolicitado(this);
    }

    /* Este metodo e invocado quando a Secretaria verifica inconsistencias nos dados do Aluno e solicita a
     complementacao dos dados */
    public void complementarDados(){
        estadoProcesso.complementarDados(this);
    }

    /* Este metodo e invocado quando a Secretaria conclui a verificacao dos dados do Aluno e o processo e repassado a
   Coordenacao */
    public void deferirEmCoordenacao() {
        estadoProcesso.deferirEmCoordenacao(this);
    }

    /* Este metodo e invocado quando a Coordenacao defere a solicitacao do Aluno e o processo e repassado para
    Biblioteca */
    public void verificarPendenciasBiblioteca() {
        estadoProcesso.verificarPendenciasBiblioteca(this);
    }

    /* Este metodo e invocado quando a Biblioteca conclui seus procedimento internos e repasas o processo para
    o Financeiro */
    public void executarProcessosFinanceiros() {
        estadoProcesso.executarProcessosFinanceiros(this);
    }

    /* Qualquer processo que chegue ao final de vida deve ser arquivado pelo sistema, mesmo que incompleto
        Este metodo deve ser invocado nas seguintes situacoes:
            * Aluno pode cancelar a solicitacao antes de chegar na Coordenacao
            * Secretaria pode arquivar a solicitacao
            * Coordenardor pode arquivar a solicitacao ao nao deferir o processo
            * Financeiro arquiva o processo no fim de vida do mesmo*/
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
