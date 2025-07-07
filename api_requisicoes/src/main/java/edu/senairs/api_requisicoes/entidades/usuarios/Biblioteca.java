package edu.senairs.api_requisicoes.entidades.usuarios;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Biblioteca {
    private String nome;
    private String email;
    private String observacao;
}