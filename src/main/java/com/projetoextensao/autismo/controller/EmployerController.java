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
import com.projetoextensao.autismo.model.dto.EmployerFormDTO;
import com.projetoextensao.autismo.model.dto.RegistrationEmployerDTO;
import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.service.AccountService;
import com.projetoextensao.autismo.service.EmployerService;

import jakarta.servlet.http.HttpSession;

@Controller
@RestController
@RequestMapping("/api/account/employer")
public class EmployerController {
	
	@Autowired
	private EmployerService service;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<EmployerAccount> registerEmployer(@RequestBody RegistrationEmployerDTO fullRegister, HttpSession session) {
		AccountFormDTO accountDTO = fullRegister.accountDTO();
		EmployerFormDTO employerDTO = fullRegister.employerDTO();
		
		System.out.println(accountDTO);
		System.out.println(employerDTO);
		EmployerAccount employerSave = service.saveEmployer(accountDTO, employerDTO);
		System.out.println(employerDTO);
		accountService.saveAccount(accountDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(employerSave);
	}
	
	@GetMapping
	public ResponseEntity<List<EmployerAccount>> findAll() {
		List<EmployerAccount> employerAll = service.findAll();
		return new ResponseEntity<>(employerAll, HttpStatus.OK);
	}
}
