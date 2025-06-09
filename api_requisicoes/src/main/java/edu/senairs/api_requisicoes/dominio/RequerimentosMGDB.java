package edu.senairs.api_requisicoes.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Getter
public class RequerimentosMGDB {
    private final UUID id;
    //private final ProtocolIdGenerate idProtocol;
    private final LocalDateTime creationDate;
    private LocalDateTime updateDate;

}
