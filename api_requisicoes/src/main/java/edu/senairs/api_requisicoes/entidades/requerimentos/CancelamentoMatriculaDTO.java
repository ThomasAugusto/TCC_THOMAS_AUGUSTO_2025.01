package edu.senairs.api_requisicoes.entidades.requerimentos;

public record CancelamentoMatriculaDTO(String nomeAluno,
                                       String emailAluno,
                                       String telefoneAluno,
                                       String cpfAluno,
                                       String motivoCancelamento) {}