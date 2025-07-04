package edu.senairs.api_requisicoes.entidades.requerimentos;

import edu.senairs.api_requisicoes.entidades.usuarios.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "requerimentos")
public class MongoRequerimento {
    @Id
    private String id;
    private String protocolo;
    private boolean ativo;
    private EstadoProcesso estado;
    private LocalDateTime dataSolicitacao = LocalDateTime.now();
    private LocalDateTime dataConclusao;
    private Aluno aluno;
    private Secretaria secretaria;
    private Coordenacao coordenacao;
    private Biblioteca biblioteca;
    private Financeiro financeiro;
}
