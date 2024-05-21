package com.projetoextensao.autismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.model.dto.AccountFormDTO;
import com.projetoextensao.autismo.model.dto.EmployerFormDTO;
import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.respository.EmployerRepository;

@Service
public class EmployerService {

	@Autowired
	private EmployerRepository repository;

	public List<EmployerAccount> findAll() {
		List<EmployerAccount> employerList = repository.findAll();
		return employerList;
	}

	public EmployerAccount saveEmployer(AccountFormDTO accountDTO, EmployerFormDTO employerDTO) {
		EmployerAccount employer = dtoFromEmployerAccount(accountDTO, employerDTO);
		EmployerAccount employerAccount = repository.save(employer);
		return employerAccount;
	}

	private EmployerAccount dtoFromEmployerAccount(AccountFormDTO accountDTO, EmployerFormDTO employerDTO) {
		EmployerAccount employer = new EmployerAccount(accountDTO.firstName(), accountDTO.lastName(),
				accountDTO.email(), accountDTO.password(), accountDTO.account(), null, employerDTO.createdAt(),
				employerDTO.companyName(), employerDTO.cnpj(), employerDTO.companyEmail(), employerDTO.website(),
				employerDTO.country(), employerDTO.state(), employerDTO.city(), employerDTO.numberPhone(),
				employerDTO.cep(), employerDTO.description());
		return employer;

	}

}
