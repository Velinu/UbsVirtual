package com.ubsvirtual.UbsVirtual.models.consultas;

import com.ubsvirtual.UbsVirtual.interfaces.GerenciadorConsulta;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "Consultas")
public class Consulta implements GerenciadorConsulta {

    @Id
    private Integer id;

    private Medico medico;
    private Paciente paciente;
    private Ubs ubs;
    private ModalidadeConsulta modalidade;
    private LocalDateTime horaInicio; //conferir depois
    private LocalDateTime horaFinal; //conferir depois
    private String anotacoes;
    private StatusConsulta statusConsulta;

    public Consulta(Integer id, Medico medico, Paciente paciente, Ubs ubs, ModalidadeConsulta modalidade, LocalDateTime horaInicio) {
        this.id = id;
        this.medico = medico;
        this.paciente = paciente;
        this.ubs = ubs;
        this.modalidade = modalidade;
        this.horaInicio = horaInicio;
        this.horaFinal = horaInicio.plusMinutes(30);
        this.statusConsulta = StatusConsulta.PENDENTE;
        this.anotacoes = "";
    }

    public Integer getId() {
        return id;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Ubs getUbs() {
        return ubs;
    }

    public ModalidadeConsulta getModalidade() {
        return modalidade;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public LocalDateTime getHoraFinal() {
        return horaFinal;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public StatusConsulta getStatusConsulta() {
        return statusConsulta;
    }

    //métodos do gerenciador

    @Override
    public void cancelar() {
        this.statusConsulta = StatusConsulta.CANCELADA;
    }

    @Override
    public void concluir() {
        this.statusConsulta = StatusConsulta.CONCLUIDA;
    }

    public void setAnotattion(String anottation) {this.anotacoes = anottation;}
}
