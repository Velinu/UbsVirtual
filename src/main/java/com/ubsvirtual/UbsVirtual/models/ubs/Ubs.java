package com.ubsvirtual.UbsVirtual.models.ubs;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Ubs's")
public class Ubs {

    @Id
    private Integer id;

    private String nome;
    private String cep;
    private Integer numero;
    private String logradouro;
    private String telefone;
    private boolean ativo;

    public Ubs(Integer id, String nome, String cep, Integer numero, String logradouro, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cep = cep;
        this.numero = numero;
        this.logradouro = logradouro;
        this.telefone = telefone;
        this.ativo = true;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCep() {
        return cep;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean getAtivo(){
        return ativo;
    }

    public void desativar(){
        this.ativo = false;
    }

    public void ativar(){
        this.ativo = true;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
