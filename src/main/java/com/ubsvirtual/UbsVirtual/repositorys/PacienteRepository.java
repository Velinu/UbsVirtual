package com.ubsvirtual.UbsVirtual.repositorys;

import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, Integer> {
}
