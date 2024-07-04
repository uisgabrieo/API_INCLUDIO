package com.projetoextensao.autismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.config.util.ConvertionImgFromBase64;
import com.projetoextensao.autismo.dto.company.CompanyFormDTO;
import com.projetoextensao.autismo.dto.company.CompanyPerfilDTO;
import com.projetoextensao.autismo.dto.employer.EmployerEditPerfil;
import com.projetoextensao.autismo.model.entities.Company;
import com.projetoextensao.autismo.model.entities.EmployerAccount;
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
	
	public Company update(CompanyFormDTO objCompany, EmployerEditPerfil objEmployer, String email) {
		EmployerAccount employer = employerService.findByEmail(email);
		Company company = repository.findByEmployer(employer).get();
		update(objCompany, objEmployer, employer, company);
		
		return repository.save(company);
	}
	
	private Company update(CompanyFormDTO objCompany, EmployerEditPerfil objEmployer, EmployerAccount employer, Company company) {
		return updateCompany(updateEmployer(employer, objEmployer), company, objCompany);
	}
	
	private EmployerAccount updateEmployer(EmployerAccount emp, EmployerEditPerfil obj) {
		if (obj.country() != null) emp.setCountry(obj.country());
		if (obj.state() != null)  emp.setState(obj.state());
		if (obj.city() != null) emp.setCity(obj.city());
		if (obj.complement() != null) emp.setComplement(obj.complement());
		if (obj.cep() != null) emp.setCep(obj.cep());
		if (obj.completeName() != null) emp.setCompleteName(obj.completeName());
		if (obj.numberPhone() != null) emp.setNumberPhone(obj.numberPhone());
		if (obj.gende() != null) emp.setGender(obj.gende());
		if (obj.photograph() != null) emp.setPhotograph(ConvertionImgFromBase64.convertFromBase64(obj.photograph()));
		if (obj.jobTitle() != null) emp.setJobTitle(obj.jobTitle());
		return employerService.saveEmployer(emp);
	}
	
	private Company updateCompany (EmployerAccount emp, Company comp, CompanyFormDTO obj) {
		comp.setEmployer(emp);
		if (obj.companyName() != null) comp.setCompanyName(obj.companyName());
		if (obj.website() != null) comp.setWebsite(obj.website());
		if (obj.country() != null) comp.setCountry(obj.country());
		if (obj.state() != null) comp.setState(obj.state());
		if (obj.city() != null) comp.setCity(obj.city());
		if (obj.neighborhood() != null) comp.setNeighborhood(obj.neighborhood());
		if (obj.street() != null) comp.setStreet(obj.street());
		if (obj.numCompany() != null) comp.setNumCompany(obj.numCompany());
		if (obj.cep() != null) comp.setCep(obj.companyName());
		if (obj.numberPhone() != null) comp.setNumberPhone(obj.numberPhone());
		if (obj.description() != null) comp.setDescription(obj.description());
		
		return comp;
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
