package com.projetoextensao.autismo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.dto.CompanyFormDTO;
import com.projetoextensao.autismo.dto.EmployerFormDTO;
import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.model.entities.Company;
import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.model.util.ConvertionImgFromBase64;
import com.projetoextensao.autismo.respository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;

	public Company saveCompany(AccountFormDTO accountDTO, EmployerFormDTO employerDTO, CompanyFormDTO companyDTO) {
		Company company = dtoFromCompany(accountDTO, employerDTO, companyDTO);
		Company companySave = repository.save(company);
		return companySave;
	}

	private Company dtoFromCompany(AccountFormDTO accountDTO, EmployerFormDTO employerDTO, CompanyFormDTO companyDTO) {
		EmployerAccount employer = new EmployerAccount(
				accountDTO.completeName(), 
				accountDTO.email(), 
				accountDTO.password(), 
				accountDTO.account(),
				null, 
				employerDTO.dateOfBirth(), 
				employerDTO.cpf(), 
				employerDTO.country(), 
				employerDTO.state(), 
				employerDTO.city(), 
				employerDTO.cep(), 
				employerDTO.numberPhone(),  
				ConvertionImgFromBase64.convertFromBase64(employerDTO.photograph()), 
				employerDTO.gender()
				);
		Company company = new Company(
				null, 
				employer, 
				companyDTO.createdAt(), 
				companyDTO.companyName(), 
				companyDTO.cnpj(), 
				companyDTO.logo(), 
				companyDTO.companyEmail(), 
				companyDTO.website(),
				companyDTO.country(), 
				companyDTO.state(), 
				companyDTO.city(), 
				companyDTO.numberPhone(), 
				companyDTO.cep(), 
				companyDTO.description());
		return company;

	}

}
