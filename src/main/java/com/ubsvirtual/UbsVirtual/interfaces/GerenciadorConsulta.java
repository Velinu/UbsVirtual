package com.ubsvirtual.UbsVirtual.interfaces;

import com.ubsvirtual.UbsVirtual.models.consultas.ModalidadeConsulta;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;

import java.time.LocalDateTime;

public interface GerenciadorConsulta {


    void cancelar();

    void concluir();
}
