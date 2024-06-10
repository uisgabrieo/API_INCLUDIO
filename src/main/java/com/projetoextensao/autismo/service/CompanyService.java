package com.projetoextensao.autismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.company.CompanyFormDTO;
import com.projetoextensao.autismo.dto.company.CompanyPerfilDTO;
import com.projetoextensao.autismo.dto.employer.EmployerFormDTO;
import com.projetoextensao.autismo.model.entities.Company;
import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.model.util.ConvertionImgFromBase64;
import com.projetoextensao.autismo.respository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	private CompanyRepository repository;
	
	@Autowired
	private EmployerService employerService;

	public Company saveCompany(AccountFormDTO accountDTO, EmployerFormDTO employerDTO, CompanyFormDTO companyDTO) {
		Company company = dtoFromCompany(accountDTO, employerDTO, companyDTO);
		Company companySave = repository.save(company);
		return companySave;
	}

	public Company findById(String  id) {
		System.out.println(id);
		EmployerAccount employer = employerService.findById(id);
		System.out.println(employer);
		Optional<Company> company = repository.findByEmployer(employer);
		System.out.println(company.get());
		return company.get();
	}
	
	public CompanyPerfilDTO fromCompanyPerfil(Company obj) {
		CompanyPerfilDTO company = new CompanyPerfilDTO(
				employerService.fromPerfil(obj.getEmployer()),
				obj.getCreatedAt(),
				obj.getCompanyName(),
				obj.getLogo(),
				obj.getWebsite(),
				obj.getCountry(),
				obj.getState(),
				obj.getCity(),
				obj.getNumberPhone(), 
				obj.getCep(),
				obj.getDescription());
		System.out.println(company);
		return company;
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
