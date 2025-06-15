package edu.senairs.api_requisicoes.dominio.processos.trancamentoDeMatricula;

import edu.senairs.api_requisicoes.entidades.Exceptions.ComportamentoInvalidoException;

public class SolicitarTDM implements EstadoTDM {
    @Override
    public void processoSolicitado(TrancamentoMatricula processo) {
        throw new ComportamentoInvalidoException("Processo só pode ser solicitado uma vez");
    }

    @Override
    public void complementarDados(TrancamentoMatricula processo) {
        processo.setEstadoProcesso(new ComplementarDados());
    }

    @Override
    public void deferirEmCoordenacao(TrancamentoMatricula processo) {
        processo.setEstadoProcesso(new DeferirEmCoordenacao());
    }

    @Override
    public void verificarPendenciasBiblioteca(TrancamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void executarProcessosFinanceiros(TrancamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void arquivarProcesso(TrancamentoMatricula processo) {
        processo.setEstadoProcesso(new ArquivarTDM());
    }
}
