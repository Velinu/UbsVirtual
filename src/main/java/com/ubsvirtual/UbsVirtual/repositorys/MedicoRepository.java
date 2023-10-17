package com.ubsvirtual.UbsVirtual.repositorys;

import com.ubsvirtual.UbsVirtual.models.pessoas.Medico;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, Integer> {
    UserDetails findByCrm(String crm);

    UserDetails findByCpf(String crm);
}
