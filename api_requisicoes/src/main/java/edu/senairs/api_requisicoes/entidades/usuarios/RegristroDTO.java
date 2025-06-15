package edu.senairs.api_requisicoes.entidades.usuarios;

public record RegristroDTO(String nome,
                           String email,
                           String password,
                           TipoUsuario tipoUsuario) {}
