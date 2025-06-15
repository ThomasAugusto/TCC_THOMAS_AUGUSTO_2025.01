package edu.senairs.api_requisicoes.dominio.processos.cancelamentoDeMatricula;

import edu.senairs.api_requisicoes.entidades.Exceptions.ComportamentoInvalidoException;

public class SolicitarCDM implements EstadoCDM {
    @Override
    public void processoSolicitado(CancelamentoMatricula processo) {
        throw new ComportamentoInvalidoException("Processo só pode ser solicitado uma vez");
    }

    @Override
    public void complementarDados(CancelamentoMatricula processo) {
        processo.setEstadoProcesso(new ComplementarDados());
    }

    @Override
    public void deferirEmCoordenacao(CancelamentoMatricula processo) {
        processo.setEstadoProcesso(new DeferirEmCoordenacao());
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
        processo.setEstadoProcesso(new ArquivarCDM());
    }
}
