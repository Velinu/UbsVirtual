package com.ubsvirtual.UbsVirtual.models.pessoas;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class MedicoTests {

    @Test
    void testMedico() throws CpfException {
        Medico medico = new Medico(
                1,
                "sdf",
                Especializacao.ANESTESIOLOGIA,
                "12766560920",
                "Matheus",
                LocalDate.of(2004, 04, 20),
                "F",
                TiposSanguineo.A_NEGATIVO,
                "Teste1"
        );

        Assertions.assertEquals("sdf", medico.getCrm());
        Assertions.assertEquals(20, medico.getEspecializacao().getId_especializacao());
        Assertions.assertEquals("Anestesiologista", medico.getEspecializacao().getNome_especializacao());
    }

}
