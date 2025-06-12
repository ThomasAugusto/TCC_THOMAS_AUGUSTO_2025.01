package edu.senairs.api_requisicoes.entidades.teste.entidades;

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
