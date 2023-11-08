package com.ubsvirtual.UbsVirtual;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.models.pessoas.Especializacao;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.models.pessoas.TiposSanguineo;
import com.ubsvirtual.UbsVirtual.repositorys.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class UbsVirtualApplication implements CommandLineRunner {

    public UbsVirtualApplication() {
    }

    public static void main(String[] args) {
		SpringApplication.run(UbsVirtualApplication.class, args);
	}

	@Autowired
	MedicoRepository medicoRepository;

	@Override
	public void run(String... args) throws CpfException {



		Medico medico1 = new Medico(1,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Matheus",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico2 = new Medico(2,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Pedro",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");
		Medico medico3 = new Medico(3,
				"sdf",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Rubens",
				LocalDate.of(2004, 04, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");

		//medicoRepository.insert(medico1);
		//medicoRepository.insert(medico2);
		//medicoRepository.insert(medico3);

		ListaLigada<Medico> listaMedicos = new ListaLigada<>();
		for (Medico medico : medicoRepository.findAll()){
			listaMedicos.adicionarFinal(medico);
			System.out.println(listaMedicos.getUltimo().getValor().getCpf());
		}
		
	}
}
