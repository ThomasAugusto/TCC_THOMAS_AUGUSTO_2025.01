package edu.senairs.api_requisicoes.entidades.requerimentos;

import lombok.Getter;

@Getter
public enum EstadoProcesso {
    ENVIAR_SECRETARIA("Processo solicitado"),
    ENVIAR_COORDENACAO("Processo em análise"),
    ENVIAR_BIBLIOTECA("Processo em análise"),
    ENVIAR_FINANCEIRO("Processo em análise"),
    ENVIAR_ALUNO("Confirmar dados pessoais"),
    CONCLUIDO("Processo concluído");

    private final String descricao;
    EstadoProcesso(String descricao) {
        this.descricao = descricao;
    }

}