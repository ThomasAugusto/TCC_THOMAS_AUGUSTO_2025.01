package edu.senairs.api_requisicoes.entidades.Exceptions;

public class ComportamentoInvalidoException extends RuntimeException{
    public ComportamentoInvalidoException() {
        super("Comportamento invalido de processo");
    }

    public ComportamentoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
