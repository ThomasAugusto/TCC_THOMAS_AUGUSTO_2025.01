package edu.senairs.api_requisicoes.domain;

public record StudentRequestDTO(String name,
                                String email,
                                String password,
                                String cpf,
                                String phoneNumber){
}
