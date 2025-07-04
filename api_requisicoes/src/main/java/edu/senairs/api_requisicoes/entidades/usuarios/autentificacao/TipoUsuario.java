package edu.senairs.api_requisicoes.entidades.usuarios.autentificacao;

public enum TipoUsuario {
    ALUNO("aluno"),
    BIBLIOTECA("biblioteca"),
    COORDENACAO("coordenacao"),
    FINANCEIRO("financeiro"),
    SECRETARIA("secretaria"),
    ADMINISTRADOR("administrador");

    private String tipoUsuario;

    TipoUsuario(String tipoUsuario){
        this.tipoUsuario = tipoUsuario;
    }

    public String getTipoUsuario(){
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}