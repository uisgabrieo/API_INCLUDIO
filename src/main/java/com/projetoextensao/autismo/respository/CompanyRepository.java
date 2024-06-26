package com.projetoextensao.autismo.respository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetoextensao.autismo.model.entities.Company;
import com.projetoextensao.autismo.model.entities.EmployerAccount;



@Repository
public interface CompanyRepository extends MongoRepository<Company, String>{

	Optional<Company> findByEmployer(EmployerAccount employer);
	
	Optional<Company> findByCompanyEmail(String companyEmail);
	
}
