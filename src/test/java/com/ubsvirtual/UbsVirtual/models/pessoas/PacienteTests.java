package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

public class PacienteTests {

    @Test
    void testePaciente() throws CpfException {
        Paciente paciente = new Paciente(
                1,
                "12766560920",
                "Jonathan Joester",
                LocalDate.of(2003,05,19),
                "F",
                TiposSanguineo.A_NEGATIVO,
                "Teste1"
        );

        paciente.setUltima_consulta(LocalDate.of(2023,11,15));
        Assertions.assertEquals(LocalDate.of(2023,11,15), paciente.getUltima_consulta());

        paciente.active();
        paciente.delete();
    }

    @Test
    void testeCpf() throws CpfException {
        Paciente paciente1 = new Paciente(
                1,
                "1276656092",
                "Jonathan Joester",
                LocalDate.of(2003,05,19),
                "F",
                TiposSanguineo.A_NEGATIVO,
                "Teste1"
        );
    }
}
