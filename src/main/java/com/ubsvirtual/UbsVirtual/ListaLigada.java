package com.ubsvirtual.UbsVirtual;

public class ListaLigada<Tipo> {
    private Node<Tipo> primeiro;
    private Node<Tipo> ultimo;
    private Integer tamanho;

    public ListaLigada() {
        this.tamanho = 0;
    }

    public Node<Tipo> getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Node<Tipo> primeiro) {
        this.primeiro = primeiro;
    }

    public Node<Tipo> getUltimo() {
        return ultimo;
    }

    public void setUltimo(Node<Tipo> ultimo) {
        this.ultimo = ultimo;
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public Node<Tipo> getPorValor(Tipo valor) {
        Node<Tipo> atual = this.primeiro;
        for (int i = 0; i<this.getTamanho(); i++){
            if (atual.getValor().equals(valor)){
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void adicionarFinal(Tipo valor){
        Node<Tipo> novo = new Node<Tipo>(valor);
        if(this.primeiro == null && this.ultimo == null){
            this.primeiro = novo;
            this.ultimo = novo;
        }else {
            this.ultimo.setProximo(novo);
            this.ultimo = novo;
        }
        this.tamanho++;
    }

    public void adicionarInicio(Tipo valor){
        Node<Tipo> novo = new Node<Tipo>(valor);
        if(this.primeiro == null && this.ultimo == null){
            this.primeiro = novo;
            this.ultimo = novo;
        }else {
            novo.setProximo(this.primeiro);
            this.primeiro = novo;
        }
        this.tamanho++;
    }

    public Node<Tipo> removerPorValor(Tipo valor){
        if (this.getTamanho() == 0){
            return null;
        }
        Node<Tipo> anterior = null;
        Node<Tipo> atual = this.primeiro;
        Node<Tipo> retorno = null;
        for(int i = 0; i<this.getTamanho(); i++){
            if(atual.getValor().equals(valor)){
                if (this.getTamanho() == 1){
                    this.primeiro = null;
                    this.ultimo = null;
                } else if (atual == primeiro){
                    this.primeiro = atual.getProximo();
                } else if (atual == ultimo) {
                    this.ultimo = anterior;
                    anterior.setProximo(null);
                } else {
                    retorno = atual;
                    anterior.setProximo(atual.getProximo());
                    atual = null;
                }
                this.tamanho --;
                return retorno;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return null;
    }

    public Node<Tipo> removerPrimeiro(){
        Node<Tipo> retorno = this.primeiro;
        if (this.getTamanho() == 0){
            return null;
        } else if (this.getTamanho() == 1) {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho --;
            return retorno;
        }
        this.primeiro = this.primeiro.getProximo();
        this.tamanho --;
        return retorno;
    }

    public Node<Tipo> removerUltimo(){
        Node<Tipo> retorno = this.ultimo;
        if (this.getTamanho() == 0){
            return null;
        }else if (this.getTamanho() == 1) {
            this.primeiro = null;
            this.ultimo = null;
            this.tamanho --;
            return retorno;
        }
        Node<Tipo> anterior = null;
        Node<Tipo> atual = this.primeiro;

        for(int i = 0; i<this.getTamanho(); i++) {
            if(atual.getValor().equals(this.ultimo.getValor())) {
                this.ultimo = anterior;
                anterior.setProximo(null);
                this.tamanho --;
            }
            anterior = atual;
            atual = atual.getProximo();
        }
        return retorno;
    }

}
