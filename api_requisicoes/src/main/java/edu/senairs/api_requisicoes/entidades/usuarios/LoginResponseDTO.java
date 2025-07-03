package edu.senairs.api_requisicoes.entidades.usuarios;

public record LoginResponseDTO(String token, String idUsuario, String nomeUsuario, String emailUsuario,
                               String tipoUsuario) {
}
