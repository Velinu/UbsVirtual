package com.ubsvirtual.UbsVirtual;

import com.ubsvirtual.UbsVirtual.controllers.MedicoController;
import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.models.consultas.Consulta;
import com.ubsvirtual.UbsVirtual.models.consultas.ModalidadeConsulta;
import com.ubsvirtual.UbsVirtual.models.pessoas.Especializacao;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.models.pessoas.TiposSanguineo;
import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;
import com.ubsvirtual.UbsVirtual.services.ConsultaService;
import com.ubsvirtual.UbsVirtual.services.MedicoService;
import com.ubsvirtual.UbsVirtual.services.PacienteService;
import com.ubsvirtual.UbsVirtual.services.UbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UbsVirtualApplication implements CommandLineRunner {

    public UbsVirtualApplication() throws CpfException {
    }

    public static void main(String[] args) {
		SpringApplication.run(UbsVirtualApplication.class, args);
	}

	@Autowired
	MedicoService medicoService;
	@Autowired
	PacienteService pacienteService;
	@Autowired
	UbsService ubsService;
	@Autowired
	ConsultaService consultaService;

	@Autowired
	MedicoController medicoController;

	Medico medico = new Medico(1,"SP123",Especializacao.ANESTESIOLOGIA,"127.665.609-20",
			"Masqueico", LocalDate.of(2004,4,20),"Masculino", TiposSanguineo.AB_POSITIVO);

	Paciente paciente = new Paciente(1,"127.665.609-20", "Mamado",LocalDate.of(2004,4,20),
			"Masculino", TiposSanguineo.A_NEGATIVO);

	Ubs ubs = new Ubs(1,"Zona Sul", "123456789", 789, "Rua", "9987176360");
	List<Paciente> pacientes = new ArrayList<>();

	Consulta consulta = new Consulta(1,
			medico,
			paciente,
			ubs,
			ModalidadeConsulta.PRESENCIAL,
			LocalDateTime.now());

	Consulta consulta2 = new Consulta(2,
			medico,
			paciente,
			ubs,
			ModalidadeConsulta.PRESENCIAL,
			LocalDateTime.now());

	List<Medico> medicos = new ArrayList<Medico>();

	List<Ubs> ubss = new ArrayList<>();

	List<Consulta> consultas = new ArrayList<>();

	@Override
	public void run(String... args) throws Exception {
	/*
		pacientes.add(paciente);
		medicos.add(medico);
		consultas.add(consulta);
		ubss.add(ubs);
		consultas.add(consulta2);

		pacienteService.insert(pacientes);
		medicoService.insert(medicos);
		consultaService.insert(consultas);
		ubsService.insert(ubss);
	*/
	}
}
