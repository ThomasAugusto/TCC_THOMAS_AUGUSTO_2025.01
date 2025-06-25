package edu.senairs.api_requisicoes.entidades.processos;

import edu.senairs.api_requisicoes.entidades.usuarios.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "processos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idProcesso")
public class TrancamentoMatriculaMongoDb {
    @Id
    private String idProcesso;
    private String nomeProcesso = "Trancamento de Matrícula";
    private int tempoAfastamenteEmSemestres;
    private String motivoProcesso;
    private Aluno aluno;
    private Secretaria secretaria;
    private Coordenacao coordenacao;
    private Biblioteca biblioteca;
    private Financeiro financeiro;
}
