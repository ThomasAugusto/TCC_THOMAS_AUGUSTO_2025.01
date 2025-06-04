package edu.senairs.api_requisicoes.entidades.processos.trancamentoDeMatricula;

public interface EstadoTDM {
    void processoSolicitado(TrancamentoMatricula processo);
    void complementarDados(TrancamentoMatricula processo);
    void deferirEmCoordenacao(TrancamentoMatricula processo);
    void verificarPendenciasBiblioteca(TrancamentoMatricula processo);
    void executarProcessosFinanceiros(TrancamentoMatricula processo);
    void arquivarProcesso(TrancamentoMatricula processo);
    }
