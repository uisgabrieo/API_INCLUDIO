package com.projetoextensao.autismo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetoextensao.autismo.model.entities.EmployerAccount;

@Repository
public interface EmployerRepository extends MongoRepository<EmployerAccount, String>{

}
