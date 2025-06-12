package edu.senairs.api_requisicoes.entidades.teste.entidades;

public class Campo {
    String campo;
    String string;

    public Campo(String campo, String string) {
        this.campo = campo;
        this.string = string;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
