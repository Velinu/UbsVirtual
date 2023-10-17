package com.ubsvirtual.UbsVirtual.models.pessoas;


public enum Roles {
    MEDICO("Medico"),
    PACIENTE("Paciente"),
    ADMINISTRADOR("Administrador");

    private final String nome;
    Roles(String nome){
        this.nome = nome;
    }

    private String getNome(){
        return nome;
    }
}
