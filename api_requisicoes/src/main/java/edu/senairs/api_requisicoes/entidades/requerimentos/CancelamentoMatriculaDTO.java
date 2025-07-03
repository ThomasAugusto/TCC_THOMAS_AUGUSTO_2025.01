package edu.senairs.api_requisicoes.entidades.requerimentos;

public record CancelamentoMatriculaDTO(String tipoUsuario,
                                       String nomeAluno,
                                       String emailAluno,
                                       String telefoneAluno,
                                       String cpfAluno,
                                       String curso,
                                       String motivoCancelamento) {}