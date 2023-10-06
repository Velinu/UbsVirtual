package com.ubsvirtual.UbsVirtual.repositorys;

import com.ubsvirtual.UbsVirtual.models.ubs.Ubs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UbsRepository extends MongoRepository<Ubs, Integer> {
}
