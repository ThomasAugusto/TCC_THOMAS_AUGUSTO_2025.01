package edu.senairs.api_requisicoes.entidades.usuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Aluno {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private String curso;
    private int semestre;
}
