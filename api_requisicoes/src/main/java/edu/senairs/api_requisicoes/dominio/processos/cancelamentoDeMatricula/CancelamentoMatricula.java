package edu.senairs.api_requisicoes.dominio.processos.cancelamentoDeMatricula;

import edu.senairs.api_requisicoes.test.entidades.Cursos;

public class CancelamentoMatricula {
    String nomeProcesso;
    String motivosCancelamento;
    Cursos curso;
    EstadoCDM estadoProcesso;

    // O CancelamentoMatricula podera ser instanciado pelas entidades Aluno ou Secretaria

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
}
