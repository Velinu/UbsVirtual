package com.ubsvirtual.UbsVirtual;

public class Node<Tipo> {
    private Tipo valor;
    private Node<Tipo> proximo;

    public Node(Tipo valor) {
        this.valor = valor;
    }

    public Tipo getValor() {
        return valor;
    }

    public void setValor(Tipo valor) {
        this.valor = valor;
    }

    public Node<Tipo> getProximo() {
        return proximo;
    }

    public void setProximo(Node<Tipo> proximo) {
        this.proximo = proximo;
    }
}
