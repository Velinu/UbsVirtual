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
	@Autowired
	UbsRepository  ubsRepository;

	@Autowired
	MedicoRepository medicoRepository;

	@Autowired
	PacienteRepository pacienteRepository;

	@Override
	public void run(String... args) throws CpfException {

		Medico medico1 = new Medico(3,
				"1234567",
				Especializacao.ANESTESIOLOGIA,
				"12766560920",
				"Matheus",
				LocalDate.of(2004, 4, 20),
				"F",
				TiposSanguineo.A_NEGATIVO,
				"Teste1");

		Paciente paciente1 = new Paciente(2, "12766560920", "Matheus", LocalDate.of(2004, 04, 20)
				, "M", TiposSanguineo.A_NEGATIVO, "Teste");
		paciente1.setUltima_consulta(LocalDate.of(2023, 04, 20));

		Ubs ubs = new Ubs(1, "UbsTeste", "12345678", 789, "Rua", "11111111111");
		medicoRepository.insert(medico1);
	}
}
