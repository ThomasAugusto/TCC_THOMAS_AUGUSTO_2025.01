package edu.senairs.api_requisicoes.entidades.processos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CancelamentoMatricula {
    private String processo = "Cancelamento de matrícula";
    private String curso;
    private String motivo;

    public CancelamentoMatricula(String curso, String motivo) {
        this.curso = curso;
        this.motivo = motivo;
    }
}