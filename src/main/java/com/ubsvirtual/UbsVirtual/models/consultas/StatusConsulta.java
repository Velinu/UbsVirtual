package com.ubsvirtual.UbsVirtual.models.consultas;

public enum StatusConsulta {
    PENDENTE("Pendente"),
    CONCLUIDA("Concluída"),
    CANCELADA("Cancelada");

    private String status;

    StatusConsulta(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
