package edu.senairs.api_requisicoes.entidades.requerimentos;

import lombok.Getter;

@Getter
public enum EstadoProcesso {
    ENVIAR_SECRETARIA("Processo solicitado"),
    ENVIAR_COORDENACAO("O processo encontra-se em análise na Coordenação"),
    ENVIAR_BIBLIOTECA("Em análise na Biblioteca quanto a eventuais pendências de livros"),
    ENVIAR_FINANCEIRO("Aguardando finalização no Setor Financeiro"),
    ENVIAR_ALUNO("Solicita-se ao aluno a conferência dos dados pessoais"),
    CONCLUIDO("Processo concluído");

    private final String descricao;
    EstadoProcesso(String descricao) {
        this.descricao = descricao;
    }

}