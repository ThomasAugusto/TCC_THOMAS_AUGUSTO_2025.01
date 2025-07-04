package edu.senairs.api_requisicoes.entidades.processos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CancelamentoMatricula {
    private String processo = "Cancelamento de matrícula";
    private String curso;
    private String motivo;
}
