package com.ubsvirtual.UbsVirtual.models.ubs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UbsTest {

    @Test
    void ubs(){
        Ubs ubs = new Ubs(
                1,
                "Maringa",
                "87080460",
                33,
                "Rua Choma do Pix",
                "44999996969"
        );

        ubs.ativar();
        Assertions.assertEquals(true, ubs.getAtivo());
        ubs.desativar();
        Assertions.assertEquals(false, ubs.getAtivo());

        Assertions.assertEquals(1,ubs.getId());
        Assertions.assertEquals("Maringa",ubs.getNome());
        ubs.setNome("Maringay");
        Assertions.assertEquals("Maringay",ubs.getNome());
        Assertions.assertEquals("87080460",ubs.getCep());
        Assertions.assertEquals(33,ubs.getNumero());
        Assertions.assertEquals("Rua Choma do Pix",ubs.getLogradouro());
        Assertions.assertEquals("44999996969",ubs.getTelefone());
        ubs.setTelefone("4");
        Assertions.assertEquals("4",ubs.getTelefone());
    }
}
