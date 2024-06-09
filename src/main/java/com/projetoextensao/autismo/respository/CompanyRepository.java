package com.projetoextensao.autismo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetoextensao.autismo.model.entities.Company;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String>{

}
