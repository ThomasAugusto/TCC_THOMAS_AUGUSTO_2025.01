package edu.senairs.api_requisicoes.entidades.requerimentos;

import edu.senairs.api_requisicoes.entidades.usuarios.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "requerimentos")
public class MongoRequerimento<T> {
    @Id
    private String id;
    private String protocolo;
    private boolean ativo = true;
    private String estado = EstadoProcesso.ENVIAR_SECRETARIA.getDescricao();
    private LocalDateTime dataSolicitacao = LocalDateTime.now();
    private LocalDateTime dataConclusao;
    private T processo;
    private Aluno aluno;
    private Secretaria secretaria;
    private Coordenacao coordenacao;
    private Biblioteca biblioteca;
    private Financeiro financeiro;

    public MongoRequerimento(T processo, String protocolo, Aluno aluno) {
        this.processo = processo;
        this.aluno = aluno;
        this.protocolo = protocolo;
    }
}
