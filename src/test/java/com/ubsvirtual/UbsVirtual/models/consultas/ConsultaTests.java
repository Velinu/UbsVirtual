package com.ubsvirtual.UbsVirtual.models.consultas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.models.pessoas.Especializacao;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.models.pessoas.TiposSanguineo;
import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class ConsultaTests {

    @Test
    void testeConsulta() throws CpfException {
        Paciente paciente = new Paciente(
                1,
                "12766560920",
                "Jonathan Joester",
                LocalDate.of(2003,05,19),
                "F",
                TiposSanguineo.A_NEGATIVO,
                "Teste1"
        );
        Medico medico = new Medico(
                2,
                "1234567",
                Especializacao.ANESTESIOLOGIA,
                "12766560920",
                "Matheus",
                LocalDate.of(2004, 4, 20),
                "F",
                TiposSanguineo.A_NEGATIVO,
                "Teste1"
        );

        Ubs ubs = new Ubs(
                1,
                "Maringa",
                "87080460",
                33,
                "Rua Choma do Pix",
                "44999996969"
        );

        Consulta consulta = new Consulta(
                1,
                medico,
                paciente,
                ubs,
                ModalidadeConsulta.PRESENCIAL,
                LocalDateTime.of(2023,5,20,12,30)
        );

        Assertions.assertEquals(1,consulta.getId());
        Assertions.assertEquals(medico,consulta.getMedico());
        Assertions.assertEquals(paciente,consulta.getPaciente());
        Assertions.assertEquals(ubs,consulta.getUbs());
        Assertions.assertEquals(ModalidadeConsulta.PRESENCIAL,consulta.getModalidade());
        Assertions.assertEquals(LocalDateTime.of(2023,5,20,12,30),consulta.getHoraInicio());
        Assertions.assertEquals(LocalDateTime.of(2023,5,20,13,00),consulta.getHoraFinal());
        Assertions.assertEquals("",consulta.getAnotacoes());
        Assertions.assertEquals(StatusConsulta.PENDENTE,consulta.getStatusConsulta());

        consulta.setAnotattion("Paciente veio");

        consulta.concluir();
        consulta.cancelar();

    }

}
