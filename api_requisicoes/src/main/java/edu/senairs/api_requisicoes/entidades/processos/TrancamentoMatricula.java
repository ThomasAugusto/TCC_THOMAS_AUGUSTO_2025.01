package edu.senairs.api_requisicoes.entidades.processos;

import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter
public class TrancamentoMatricula {
    private String processo = "Trancamento de matrícula";
    private String curso;
    private String motivo;
    private int semestreAtual;
    private int semestresAfastados;

    public TrancamentoMatricula(String curso, String motivo, int semestreAtual, int semestresAfastados) {
        this.curso = curso;
        this.motivo = motivo;
        this.semestreAtual = semestreAtual;
        this.semestresAfastados = semestresAfastados;
        tempoLimiteAfastado();
        tempoMininoParaTrancar();
    }

    public void tempoLimiteAfastado(){
        int TEMPO_LIMITE_SEMESTRES = 10;
        if (semestreAtual + semestresAfastados > TEMPO_LIMITE_SEMESTRES){
            throw new IllegalArgumentException("Tempo limite de afastamento excedido");
        }
    }

    public void tempoMininoParaTrancar(){
        int TEMPO_MINIMO_TRANCAMENTO = 2;
        if (semestreAtual < TEMPO_MINIMO_TRANCAMENTO){
            throw new IllegalArgumentException("Tempo minimo para trancamento excedido");
        }
    }
}
