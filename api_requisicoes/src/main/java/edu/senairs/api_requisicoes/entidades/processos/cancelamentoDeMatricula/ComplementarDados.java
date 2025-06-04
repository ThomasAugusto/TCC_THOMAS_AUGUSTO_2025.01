package edu.senairs.api_requisicoes.entidades.processos.cancelamentoDeMatricula;

import edu.senairs.api_requisicoes.entidades.Exceptions.ComportamentoInvalidoException;

public class ComplementarDados implements EstadoCDM {
    @Override
    public void processoSolicitado(CancelamentoMatricula processo) {
        processo.setEstadoProcesso(new SolicitarCDM());
    }

    @Override
    public void complementarDados(CancelamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void deferirEmCoordenacao(CancelamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void verificarPendenciasBiblioteca(CancelamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void executarProcessosFinanceiros(CancelamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }

    @Override
    public void arquivarProcesso(CancelamentoMatricula processo) {
        throw new ComportamentoInvalidoException();
    }
}
