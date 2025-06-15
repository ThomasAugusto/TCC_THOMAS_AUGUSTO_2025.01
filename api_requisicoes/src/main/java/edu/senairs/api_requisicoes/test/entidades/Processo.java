package edu.senairs.api_requisicoes.test.entidades;

import java.util.List;

public class Processo {
    Processos nomeProcesso;
    List <Campo> camposProcesso;
    List<Object> entidadesProcesso;

    public Processo(Processos nomeProcesso, List<Campo> camposProcesso, List<Object> entidadesProcesso) {
        this.nomeProcesso = nomeProcesso;
        this.camposProcesso = camposProcesso;
        this.entidadesProcesso = entidadesProcesso;
    }
}
