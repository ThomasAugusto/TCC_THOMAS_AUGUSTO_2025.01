package edu.senairs.api_requisicoes.entidades.processos.trancamentoDeMatricula;

import edu.senairs.api_requisicoes.entidades.Exceptions.ComportamentoInvalidoException;

public class ComplementarDados implements EstadoTDM {
    @Override
    public void processoSolicitado(TrancamentoMatricula processo) {
        processo.setEstadoProcesso(new SolicitarTDM());
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
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void executarProcessosFinanceiros(TrancamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void arquivarProcesso(TrancamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }
}
