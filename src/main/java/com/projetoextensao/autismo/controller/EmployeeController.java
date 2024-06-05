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

import com.projetoextensao.autismo.dto.EmployeeFormDTO;
import com.projetoextensao.autismo.dto.RegistrationEmployeeDTO;
import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.model.entities.EmployeeAccount;
import com.projetoextensao.autismo.service.AccountService;
import com.projetoextensao.autismo.service.EmployeeService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping("/api/account/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<EmployeeAccount> registerEmployee(@Valid @RequestBody RegistrationEmployeeDTO fullRegister /*EmployeeFormDTO employeeDTO*/, HttpSession session) {
		//AccountFormDTO accountDTO = (AccountFormDTO) session.getAttribute("employeeData");
		EmployeeFormDTO employeeDTO = fullRegister.employeeDTO();
		AccountFormDTO accountDTO = fullRegister.accountDTO();
		
		EmployeeAccount employeeSave = service.saveEmployee(accountDTO, employeeDTO);
		accountService.saveAccount(accountDTO);
		
		return new ResponseEntity<>(employeeSave, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeAccount>> findAll() {
		List<EmployeeAccount> employeeAll = service.findAll();
		return new ResponseEntity<>(employeeAll, HttpStatus.OK);
	}
}
