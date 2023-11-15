package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
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
    }

}
