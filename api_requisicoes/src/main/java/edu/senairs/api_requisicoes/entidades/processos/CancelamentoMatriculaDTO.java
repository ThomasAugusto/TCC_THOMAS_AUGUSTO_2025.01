package edu.senairs.api_requisicoes.entidades.processos;

import edu.senairs.api_requisicoes.entidades.usuarios.DadosAlunoDTO;

public record CancelamentoMatriculaDTO(String idUsuario,
                                       String curso,
                                       String motivo,
                                       DadosAlunoDTO dadosAluno) {}