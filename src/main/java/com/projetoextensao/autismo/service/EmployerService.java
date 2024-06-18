package com.projetoextensao.autismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.employer.EmployerFormDTO;
import com.projetoextensao.autismo.dto.employer.EmployerPerfilDTO;
import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.model.util.ConvertionImgFromBase64;
import com.projetoextensao.autismo.respository.EmployerRepository;

@Service
public class EmployerService {

	@Autowired
	private EmployerRepository repository;
	
	public EmployerAccount saveEmployer(EmployerFormDTO employerDTO) {
		EmployerAccount employer = dtoFromEmployer(employerDTO);
		EmployerAccount employerSave = repository.save(employer);
		
		return employerSave;
	}
	
	public String saveEmployer(EmployerFormDTO employerDTO, AccountFormDTO accountFormDTO) {
		EmployerAccount employer = dtoFromEmployer(employerDTO, accountFormDTO);
		EmployerAccount employerSave = repository.save(employer);
		String id = employerSave.getId();
		return id;
	}
	
	
	
	public EmployerAccount findById(String id) {	
		Optional<EmployerAccount> account = repository.findById(id);
		
		return account.get();
	}
	
	public String searchId(String email) {
		Optional<EmployerAccount> employer = repository.findByEmail(email);
		System.out.println(employer);
		String id = employer.get().getId();
		return id;
	}
	
	public EmployerPerfilDTO fromPerfil(EmployerAccount obj) {
		EmployerPerfilDTO perfil = new EmployerPerfilDTO(
				obj.getCompleteName(),
				obj.getEmail(),
				obj.getDateOfBirth(),
				obj.getCountry(), 
				obj.getState(), 
				obj.getCity(), 
				obj.getCep(), 
				obj.getComplement(),
				obj.getNumberPhone(), 
				ConvertionImgFromBase64.showImage(obj.getPhotograph()), 
				obj.getGender());

		return perfil;
	}
	
	private EmployerAccount dtoFromEmployer(EmployerFormDTO obj) {
		EmployerAccount employer = new EmployerAccount(
				obj.id(),
				obj.country(),
				obj.state(),
				obj.city(),
				obj.cep(),
				obj.complement(),
				obj.cpf(),
				obj.numberPhone(),
				obj.jobTitle(),
				obj.dateOfBirth(),
				ConvertionImgFromBase64.convertFromBase64(obj.photograph()),
				obj.gender());
		return employer;
	}
	private EmployerAccount dtoFromEmployer(EmployerFormDTO obj, AccountFormDTO acc) {
		EmployerAccount employer = new EmployerAccount(
				acc.completeName(), 
				acc.email(), 
				acc.password(), 
				acc.account(),
				obj.id(),
				obj.country(),
				obj.state(),
				obj.city(),
				obj.cep(),
				obj.complement(),
				obj.cpf(),
				obj.numberPhone(),
				obj.jobTitle(),
				obj.dateOfBirth(),
				ConvertionImgFromBase64.convertFromBase64(obj.photograph()),
				obj.gender());
		return employer;
	}
}
