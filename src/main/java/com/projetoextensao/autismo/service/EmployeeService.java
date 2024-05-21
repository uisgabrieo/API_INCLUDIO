package com.projetoextensao.autismo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public EmployeeAccount saveEmployee(EmployeeFormDTO employeeDTO) {
		EmployeeAccount employee = dtoFromEmployeeAccount(employeeDTO);
		EmployeeAccount employeeAccount = repository.save(employee);
		return employeeAccount;
	}
	
	
	private EmployeeAccount dtoFromEmployeeAccount(EmployeeFormDTO dto) {
		EmployeeAccount employee = new EmployeeAccount(
				null, dto.dateOfBirth(), dto.cpf(), dto.country(), dto.state(), 
				dto.city(), dto.cep(), dto.numberPhone()); 
		return employee;
	}
}
