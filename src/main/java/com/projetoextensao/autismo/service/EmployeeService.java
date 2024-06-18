package com.projetoextensao.autismo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.employee.EmployeeFormDTO;
import com.projetoextensao.autismo.dto.employee.EmployeePerfilDTO;
import com.projetoextensao.autismo.model.entities.EmployeeAccount;
import com.projetoextensao.autismo.model.util.ConvertionImgFromBase64;
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
	
	public EmployeePerfilDTO findById(String id) {
		Optional<EmployeeAccount> account = repository.findById(id);
		EmployeePerfilDTO accountPerfil = fromPerfil(account.get());
		return accountPerfil;
		
	}
	

	public String searchId(String email) {
		System.out.println("Email: Search: " + email);
		Optional<EmployeeAccount> employee = repository.findByEmail(email);
		String id = employee.get().getId();
		return id;
	}
	
	private EmployeePerfilDTO fromPerfil(EmployeeAccount obj) {
		EmployeePerfilDTO perfil = new EmployeePerfilDTO(
				obj.getCompleteName(),
				obj.getPassword(),
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
	
	private EmployeeAccount dtoFromEmployeeAccount(AccountFormDTO accountDTO, EmployeeFormDTO employeeDTO) {
		EmployeeAccount employee = new EmployeeAccount(
				accountDTO.completeName(), 
				accountDTO.email(), 
				accountDTO.password(), 
				accountDTO.account(),
				null, 
				employeeDTO.country(), 
				employeeDTO.state(), 
				employeeDTO.city(), 
				employeeDTO.cep(), 
				employeeDTO.complement(),
				employeeDTO.cpf(), 
				employeeDTO.numberPhone(), 
				employeeDTO.sector(),
				employeeDTO.training(),
				employeeDTO.institution(),
				employeeDTO.dateOfBirth(), 
				employeeDTO.gender(), 
				ConvertionImgFromBase64.convertFromBase64(employeeDTO.diagnostic()), 
				ConvertionImgFromBase64.convertFromBase64(employeeDTO.photograph()));
		return employee;
	}
}
