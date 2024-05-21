package com.projetoextensao.autismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.respository.EmployerRepository;

public class EmployerService {
	
	@Autowired
	private EmployerRepository repository;
	
	public List<EmployerAccount> findAll() {
		List<EmployerAccount> employerList = repository.findAll();
		return employerList;
	}
	
	public Boolean saveEmployer(EmployerAccount employer) {
		
		EmployerAccount employerAccount = repository.save(employer);
		
		if(!employerAccount.equals(null)) {
			return true;
		}
		return false;
	}
	
}
