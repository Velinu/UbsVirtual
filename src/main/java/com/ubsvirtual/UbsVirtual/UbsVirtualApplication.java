package com.ubsvirtual.UbsVirtual;

import com.ubsvirtual.UbsVirtual.exceptions.CpfException;
import com.ubsvirtual.UbsVirtual.models.consultas.Consulta;
import com.ubsvirtual.UbsVirtual.models.consultas.ModalidadeConsulta;
import com.ubsvirtual.UbsVirtual.models.pessoas.Especializacao;
import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import com.ubsvirtual.UbsVirtual.models.pessoas.TiposSanguineo;
import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;
import com.ubsvirtual.UbsVirtual.repositorys.ConsultasRepository;
import com.ubsvirtual.UbsVirtual.repositorys.MedicoRepository;
import com.ubsvirtual.UbsVirtual.repositorys.PacienteRepository;
import com.ubsvirtual.UbsVirtual.repositorys.UbsRepository;
import org.bson.assertions.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
public class UbsVirtualApplication implements CommandLineRunner {

    public UbsVirtualApplication() {


    }
    public static void main(String[] args) {


	}



	@Override
	public void run(String... args) throws CpfException {


	}
}
