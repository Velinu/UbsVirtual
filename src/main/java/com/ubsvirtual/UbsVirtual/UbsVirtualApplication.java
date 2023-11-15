package com.ubsvirtual.UbsVirtual;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.models.pessoas.Especializacao;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.models.pessoas.TiposSanguineo;
import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;
import com.ubsvirtual.UbsVirtual.repositorys.MedicoRepository;
import com.ubsvirtual.UbsVirtual.repositorys.PacienteRepository;
import com.ubsvirtual.UbsVirtual.repositorys.UbsRepository;
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

	@Override
	public void run(String... args) throws CpfException {

<<<<<<< HEAD
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
		}
		
=======
>>>>>>> e2dffd1ad8d77ac7089737bc89e2194d3d669778
	}
}
