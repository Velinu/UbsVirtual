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
        Assertions.assertEquals("12766560920",paciente.getCpf());
        Assertions.assertEquals("Jonathan Joester",paciente.getNome());
        paciente.setNome("Marcos");
        Assertions.assertEquals("Marcos",paciente.getNome());
        Assertions.assertEquals("F",paciente.getSexo());
        paciente.setSexo("M");
        Assertions.assertEquals("M",paciente.getSexo());
        Assertions.assertEquals("Teste1",paciente.getSenha());
        paciente.setSenha("teste2");
        Assertions.assertEquals("teste2",paciente.getSenha());
        Assertions.assertEquals(1,paciente.getId());
        Assertions.assertEquals(1,paciente.getId());
        Assertions.assertEquals(LocalDate.of(2003,05,19),paciente.getNascimento());
        Assertions.assertEquals(TiposSanguineo.A_NEGATIVO,paciente.getTipo_sanguineo());
        Assertions.assertEquals(TiposSanguineo.A_NEGATIVO,paciente.getTipo_sanguineo());
    }

    @Test
    void testeCpf() throws CpfException {

        Assertions.assertThrows(CpfException.class, () -> new Paciente(
                1,
                "1276656092",
                "Jonathan Joester",
                LocalDate.of(2003,05,19),
                "F",
                TiposSanguineo.A_NEGATIVO,
                "Teste1"
        ));
        Assertions.assertThrows(CpfException.class, () -> new Paciente(
                1,
                "12345678900",
                "Jonathan Joester",
                LocalDate.of(2003,05,19),
                "F",
                TiposSanguineo.A_NEGATIVO,
                "Teste1"
        ));
    }
}
