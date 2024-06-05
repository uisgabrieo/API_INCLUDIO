package com.projetoextensao.autismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.account.AccountLoginDTO;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;
import com.projetoextensao.autismo.service.AccountService;

import jakarta.servlet.http.HttpSession;

@Controller
@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@PostMapping
	public ResponseEntity<Void> registerAccount(@RequestBody AccountFormDTO accountDTO, HttpSession session) {
		System.out.println(accountDTO);
		
		if (accountDTO.account().equals(TypeAccount.EMPLOYEE)) {
			
			session.setAttribute("employeeData", accountDTO);
			return new ResponseEntity<>(HttpStatus.PERMANENT_REDIRECT);
		} else if (accountDTO.account().equals(TypeAccount.EMPLOYER)) {
			
			session.setAttribute("employerData", accountDTO);
			return new ResponseEntity<>(HttpStatus.PERMANENT_REDIRECT);
		}
		return null;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Boolean> loginAccount(@RequestBody AccountLoginDTO login) {
		
		System.out.println(login);
		Boolean loginValidation = service.valiation(login);
		
		if (loginValidation) {
			return new ResponseEntity<>(loginValidation, HttpStatus.OK);
		}
		return new ResponseEntity<>(loginValidation, HttpStatus.NOT_FOUND);	
		
	}
}
