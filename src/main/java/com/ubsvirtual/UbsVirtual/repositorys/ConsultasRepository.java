package com.ubsvirtual.UbsVirtual.repositorys;

import com.ubsvirtual.UbsVirtual.models.consultas.Consulta;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultasRepository extends MongoRepository<Consulta, Integer> {
}
