package com.ubsvirtual.UbsVirtual.repositorys;

import com.ubsvirtual.UbsVirtual.models.pessoas.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends MongoRepository<Paciente, Integer> {
    UserDetails findByCpf(String cpf);
}
