package com.ubsvirtual.UbsVirtual.models.consultas;

public enum ModalidadeConsulta {
    PRESENCIAL("Presencial"),
    ONLINE("Online");

    private int id;
    private String tipo;

    ModalidadeConsulta(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
