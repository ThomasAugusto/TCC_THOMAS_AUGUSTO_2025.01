package edu.senairs.api_requisicoes.entidades.usuarios;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Secretaria {
    private String nome;
    private String email;
    private String observacao;
}
