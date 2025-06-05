package edu.senairs.api_requisicoes.entidades.processos.trancamentoDeMatricula;

import edu.senairs.api_requisicoes.entidades.Cursos;

public class Teste {
    public static void main(String[] args) {
        TrancamentoMatricula processo = new TrancamentoMatricula(2,
                                    "Falta do pila", Cursos.TAI);
        System.out.println(processo);

        processo.complementarDados();
        System.out.println(processo);

        processo.processoSolicitado();
        System.out.println(processo);

        processo.deferirEmCoordenacao();
        System.out.println(processo);
    }
}
