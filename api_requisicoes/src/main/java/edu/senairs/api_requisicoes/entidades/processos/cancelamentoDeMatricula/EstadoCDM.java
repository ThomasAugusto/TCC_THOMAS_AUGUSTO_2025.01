package edu.senairs.api_requisicoes.entidades.processos.cancelamentoDeMatricula;

public interface EstadoCDM {
    void processoSolicitado(CancelamentoMatricula processo);
    void complementarDados(CancelamentoMatricula processo);
    void deferirEmCoordenacao(CancelamentoMatricula processo);
    void verificarPendenciasBiblioteca(CancelamentoMatricula processo);
    void executarProcessosFinanceiros(CancelamentoMatricula processo);
    void arquivarProcesso(CancelamentoMatricula processo);
}
