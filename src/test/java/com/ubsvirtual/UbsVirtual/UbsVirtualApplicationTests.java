package com.ubsvirtual.UbsVirtual;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.models.pessoas.Especializacao;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.models.pessoas.TiposSanguineo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class UbsVirtualApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testeLista() throws CpfException {
		Medico medico1 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Matheus",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico2 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Pedro",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico3 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Rubens",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		ListaLigada<Medico> listaMedico = new ListaLigada<>();
		listaMedico.adicionarFinal(medico1);
		listaMedico.adicionarFinal(medico2);
		listaMedico.adicionarFinal(medico3);
		Assertions.assertEquals("Matheus", listaMedico.getPrimeiro().getValor().getNome());
		Assertions.assertEquals("Rubens", listaMedico.getUltimo().getValor().getNome());
	}

	@Test
	void testeGetPorValor() throws CpfException {
		Medico medico1 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Matheus",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico2 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Pedro",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico3 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Rubens",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		ListaLigada<Medico> listaMedico = new ListaLigada<>();
		listaMedico.adicionarFinal(medico1);
		listaMedico.adicionarFinal(medico2);
		listaMedico.adicionarFinal(medico3);
		Assertions.assertEquals("Matheus", listaMedico.getPorValor(medico1).getValor().getNome());
	}

	@Test
	void adicionarInicioTeste() throws CpfException {
		Medico medico1 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Matheus",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico2 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Pedro",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico3 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Rubens",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		ListaLigada<Medico> listaMedico = new ListaLigada<>();
		listaMedico.adicionarInicio(medico1);
		listaMedico.adicionarInicio(medico2);
		listaMedico.adicionarFinal(medico3);
		Assertions.assertEquals("Pedro", listaMedico.getPrimeiro().getValor().getNome());
	}

	@Test
	void removerPrimeiroTeste() throws CpfException {
		Medico medico1 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Matheus",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico2 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Pedro",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico3 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Rubens",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		ListaLigada<Medico> listaMedico = new ListaLigada<>();

		listaMedico.adicionarInicio(medico1);
		listaMedico.adicionarInicio(medico2);
		listaMedico.adicionarFinal(medico3);
		listaMedico.removerPrimeiro();
		Assertions.assertEquals("Matheus", listaMedico.getPrimeiro().getValor().getNome());
		listaMedico.removerPrimeiro();
		listaMedico.removerPrimeiro();

		listaMedico.adicionarInicio(medico1);
		listaMedico.adicionarInicio(medico2);
		listaMedico.adicionarFinal(medico3);
		listaMedico.removerPrimeiro();
		listaMedico.removerPrimeiro();
		Assertions.assertEquals("Rubens", listaMedico.getPrimeiro().getValor().getNome());
		listaMedico.removerPrimeiro();

		listaMedico.adicionarInicio(medico1);
		listaMedico.adicionarInicio(medico2);
		listaMedico.adicionarFinal(medico3);
		listaMedico.removerPrimeiro();
		listaMedico.removerPrimeiro();
		listaMedico.removerPrimeiro();
		Assertions.assertEquals(null, listaMedico.getPrimeiro());
	}

	@Test
	void removerUltimoTeste() throws CpfException {
		Medico medico1 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Matheus",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico2 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Pedro",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico3 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Rubens",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		ListaLigada<Medico> listaMedico = new ListaLigada<>();

		listaMedico.adicionarInicio(medico1);
		listaMedico.adicionarInicio(medico2);
		listaMedico.adicionarFinal(medico3);
		listaMedico.removerUltimo();
		Assertions.assertEquals("Pedro", listaMedico.getPrimeiro().getValor().getNome());
		listaMedico.removerUltimo();
		listaMedico.removerUltimo();

		listaMedico.adicionarInicio(medico1);
		listaMedico.adicionarInicio(medico2);
		listaMedico.adicionarFinal(medico3);
		listaMedico.removerUltimo();
		listaMedico.removerUltimo();
		Assertions.assertEquals("Pedro", listaMedico.getPrimeiro().getValor().getNome());
		listaMedico.removerPrimeiro();

		listaMedico.adicionarInicio(medico1);
		listaMedico.adicionarInicio(medico2);
		listaMedico.adicionarFinal(medico3);
		listaMedico.removerUltimo();
		listaMedico.removerUltimo();
		listaMedico.removerUltimo();
		Assertions.assertEquals(null, listaMedico.getPrimeiro());
	}


	@Test
	public void DeveRemoverPorValor() throws CpfException{
		ListaLigada<Medico> listaMedico = new ListaLigada<>();
		Assertions.assertEquals(null, listaMedico.removerPorValor(new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Matheus",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1")));

		Medico medico1 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Matheus",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico2 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Pedro",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico3 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Rubens",
				LocalDate.of(2004,04,20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");

		listaMedico.adicionarInicio(medico1);
		listaMedico.adicionarInicio(medico2);
		listaMedico.adicionarFinal(medico3);

		Assertions.assertEquals(listaMedico.getPorValor(medico1), listaMedico.removerPorValor(medico1));
		listaMedico.removerPorValor(medico1);
		Assertions.assertNull(listaMedico.removerPorValor(medico3));
		listaMedico.removerPorValor(medico3);
		Assertions.assertNull(listaMedico.removerPorValor(medico2));

		Assertions.assertNull(listaMedico.getPorValor(medico1));

		listaMedico.adicionarInicio(medico1);
		listaMedico.adicionarFinal(medico3);

		Assertions.assertNull(listaMedico.removerPorValor(medico1));

	}


}
