package com.projetoextensao.autismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.model.dto.AccountFormDTO;
import com.projetoextensao.autismo.model.dto.EmployeeFormDTO;
import com.projetoextensao.autismo.model.entities.EmployeeAccount;
import com.projetoextensao.autismo.respository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	public List<EmployeeAccount> findAll() {
		List<EmployeeAccount> employeeList = repository.findAll();
		return employeeList;
	}
	
	public EmployeeAccount saveEmployee(AccountFormDTO accountDTO, EmployeeFormDTO employeeDTO) {
		EmployeeAccount employee = dtoFromEmployeeAccount(accountDTO, employeeDTO);
		EmployeeAccount employeeAccount = repository.save(employee);
		return employeeAccount;
	}
	
	
	private EmployeeAccount dtoFromEmployeeAccount(AccountFormDTO accountDTO, EmployeeFormDTO employeeDTO) {
		EmployeeAccount employee = new EmployeeAccount(
				accountDTO.firstName(), accountDTO.lastName(), accountDTO.email(), accountDTO.password(), accountDTO.account(),
				null, employeeDTO.dateOfBirth(), employeeDTO.cpf(), employeeDTO.country(), employeeDTO.state(), 
				employeeDTO.city(), employeeDTO.cep(), employeeDTO.numberPhone()); 
		return employee;
	}
}