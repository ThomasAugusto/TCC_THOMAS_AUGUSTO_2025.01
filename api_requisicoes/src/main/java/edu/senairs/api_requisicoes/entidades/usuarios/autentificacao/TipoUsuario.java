package edu.senairs.api_requisicoes.entidades.usuarios.autentificacao;

import lombok.Getter;

@Getter
public enum TipoUsuario {
    ALUNO("aluno"),
    BIBLIOTECA("biblioteca"),
    COORDENACAO("coordenacao"),
    FINANCEIRO("financeiro"),
    SECRETARIA("secretaria"),
    ADMINISTRADOR("administrador");

    private final String tipoUsuario;

    TipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }

    public static TipoUsuario getTipoUsuarioEnum(String tipoUsuario){
        for (TipoUsuario tipo : TipoUsuario.values()) {
            if (tipo.getTipoUsuario().equalsIgnoreCase(tipoUsuario)){
                return tipo;
            }
        }
        return null;
    }
}