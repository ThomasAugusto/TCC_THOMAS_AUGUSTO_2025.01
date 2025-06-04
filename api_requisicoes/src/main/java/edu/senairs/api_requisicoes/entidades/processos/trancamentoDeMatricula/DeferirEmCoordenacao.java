package edu.senairs.api_requisicoes.entidades.processos.trancamentoDeMatricula;

import edu.senairs.api_requisicoes.entidades.Exceptions.ComportamentoInvalidoException;

public class DeferirEmCoordenacao implements EstadoTDM {
    @Override
    public void processoSolicitado(TrancamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void complementarDados(TrancamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void deferirEmCoordenacao(TrancamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void verificarPendenciasBiblioteca(TrancamentoMatricula processo) {
        processo.setEstadoProcesso(new VerificarPendenciasBiblioteca());
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
