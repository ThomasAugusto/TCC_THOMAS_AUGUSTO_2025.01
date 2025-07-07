package edu.senairs.api_requisicoes.entidades.usuarios;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Aluno {
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
}
