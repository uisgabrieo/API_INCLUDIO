package com.projetoextensao.autismo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetoextensao.autismo.model.entities.EmployeeAccount;

@Repository
public interface EmployeeRepository extends MongoRepository<EmployeeAccount, String>{

}
