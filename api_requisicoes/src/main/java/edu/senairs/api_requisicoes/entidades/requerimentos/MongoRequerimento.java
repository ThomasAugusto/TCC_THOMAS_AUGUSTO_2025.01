package edu.senairs.api_requisicoes.entidades.requerimentos;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "requerimentos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idRequerimento")
public class MongoRequerimento<T> {
    @Id
    String idRequerimento;
    String protocoloRequerimento;
    T processo;
    LocalDateTime dataSolicitacaoRequerimento;
    LocalDateTime dataEncerramentoRequerimento;
}
