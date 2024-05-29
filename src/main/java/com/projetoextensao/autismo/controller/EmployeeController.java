package com.projetoextensao.autismo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.model.dto.AccountFormDTO;
import com.projetoextensao.autismo.model.dto.EmployeeFormDTO;
import com.projetoextensao.autismo.model.dto.RegistrationEmployeeDTO;
import com.projetoextensao.autismo.model.entities.EmployeeAccount;
import com.projetoextensao.autismo.service.AccountService;
import com.projetoextensao.autismo.service.EmployeeService;	

import jakarta.servlet.http.HttpSession;

@Controller
@RestController
@RequestMapping("/api/account/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/register")	
	public ResponseEntity<EmployeeAccount> registerEmployee(@RequestBody RegistrationEmployeeDTO fullRegister, HttpSession session) {
		//AccountFormDTO accountDTO = (AccountFormDTO) session.getAttribute("employeeData");
		EmployeeFormDTO employeeDTO = fullRegister.employeeDTO();
		AccountFormDTO accountDTO = fullRegister.accountDTO();
		
		System.out.println(employeeDTO); 
		System.out.println(accountDTO);
		
		EmployeeAccount employeeSave = service.saveEmployee(accountDTO, employeeDTO);
		System.out.println(employeeSave);
		accountService.saveAccount(accountDTO);
		
		return new ResponseEntity<>(employeeSave, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeAccount>> findAll() {
		List<EmployeeAccount> employeeAll = service.findAll();
		return new ResponseEntity<>(employeeAll, HttpStatus.OK);
	}
}
