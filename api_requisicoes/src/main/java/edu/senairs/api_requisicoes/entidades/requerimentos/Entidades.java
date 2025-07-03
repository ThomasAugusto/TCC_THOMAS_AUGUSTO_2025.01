package edu.senairs.api_requisicoes.entidades.requerimentos;

public class Entidades<T> {
    private T entidade;

    public Entidades(T entidade) {
        this.entidade = entidade;
    }

    public T getEntidade() {
        return entidade;
    }

    public void setEntidade(T entidade) {
        this.entidade = entidade;
    }
}

