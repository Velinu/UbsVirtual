package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class MedicoTests {

    @Test
    public void testMedico() throws CpfException {
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

        Assertions.assertEquals("1234567", medico.getCrm());
        Assertions.assertEquals(Especializacao.ANESTESIOLOGIA, medico.getEspecializacao());
    }

}
