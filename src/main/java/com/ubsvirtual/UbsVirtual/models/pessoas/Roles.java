package com.ubsvirtual.UbsVirtual.models.pessoas;


public enum Roles {
    MEDICO("MEDIC"),
    PACIENTE("PACIENTE"),
    ADMIN("ADMIN");

    private final String nome;
    Roles(String nome){
        this.nome = nome;
    }

    private String getNome(){
        return nome;
    }
}
