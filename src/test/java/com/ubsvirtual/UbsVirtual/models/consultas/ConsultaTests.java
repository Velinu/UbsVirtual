package com.ubsvirtual.UbsVirtual.models.consultas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.models.pessoas.Especializacao;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.models.pessoas.TiposSanguineo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

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

        //Consulta consulta = new Consulta(1, medico, paciente, ubs)
    }

}
