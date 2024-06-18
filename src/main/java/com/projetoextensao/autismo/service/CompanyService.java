package com.projetoextensao.autismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.dto.company.CompanyFormDTO;
import com.projetoextensao.autismo.dto.company.CompanyPerfilDTO;
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

	public Company saveCompany(CompanyFormDTO companyDTO) {
		Company company = dtoFromCompany(companyDTO);
		Company companySave = repository.save(company);
		return companySave;
	}

	public CompanyPerfilDTO findById(String  id) {
		EmployerAccount employer = employerService.findById(id);
		Optional<Company> company = repository.findByEmployer(employer);
		CompanyPerfilDTO companyPerfil = fromCompanyPerfil(company.get());
		return companyPerfil;
	}
	
	public CompanyPerfilDTO fromCompanyPerfil(Company obj) {
		CompanyPerfilDTO company = new CompanyPerfilDTO(
				employerService.fromPerfil(obj.getEmployer()),
				obj.getCreatedAt(),
				obj.getCompanyName(),
				obj.getCompanyEmail(),
				ConvertionImgFromBase64.showImage(obj.getLogo()),
				obj.getWebsite(),
				obj.getCountry(),
				obj.getState(),
				obj.getCity(),
				obj.getNeighborhood(),
				obj.getStreet(),
				obj.getNumCompany(),
				obj.getNumberPhone(), 
				obj.getCep(),
				obj.getDescription());
		return company;
	}
	
	private Company dtoFromCompany(CompanyFormDTO companyDTO) {
		Company company = new Company(
				null, 
				companyDTO.employer(), 
				ConvertionImgFromBase64.convertFromBase64(companyDTO.logo()), 
				companyDTO.companyName(), 
				companyDTO.companyEmail(), 
				companyDTO.country(), 
				companyDTO.state(), 
				companyDTO.city(), 
				companyDTO.cep(), 
				companyDTO.neighborhood(),
				companyDTO.street(),
				companyDTO.numCompany(),
				companyDTO.createdAt(), 
				companyDTO.cnpj(), 
				companyDTO.website(),
				companyDTO.numberPhone(), 
				companyDTO.description());
		return company;	

	}

}
