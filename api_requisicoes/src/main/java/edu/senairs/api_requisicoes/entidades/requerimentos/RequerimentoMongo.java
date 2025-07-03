package edu.senairs.api_requisicoes.entidades.requerimentos;

import com.fasterxml.jackson.annotation.JsonInclude;
import edu.senairs.api_requisicoes.entidades.usuarios.*;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "requerimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idRequerimento")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RequerimentoMongo {
    @Id
    private String idRequerimento;
    private String numeroProtocolo;
    private String estadoRequerimento;
    private boolean ativo;
    List<Entidades> entidades;

    public RequerimentoMongo(String protocolo, String estado, Entidades entidade) {
        this.numeroProtocolo = protocolo;
        this.estadoRequerimento = estado;
        this.ativo = true;
        this.entidades = List.of(entidade);
    }
}
