package edu.senairs.api_requisicoes.entidades.processos;

import edu.senairs.api_requisicoes.entidades.usuarios.DadosAlunoDTO;

public record TrancamentoMatriculaDTO(String idUsuario,
                                      String curso,
                                      String motivo,
                                      int semestreAtual,
                                      int semestresAfastados,
                                      DadosAlunoDTO dadosAluno) {}