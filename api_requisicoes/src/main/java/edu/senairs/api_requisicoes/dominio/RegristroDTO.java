package edu.senairs.api_requisicoes.dominio;

public record RegristroDTO(String nome,
                           String email,
                           String password,
                           TipoUsuario tipoUsuario) {}
