package com.projetoextensao.autismo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.model.dto.AccountFormDTO;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

import jakarta.servlet.http.HttpSession;

@Controller
@RestController
@RequestMapping("/api/account")
public class AccountController {
	
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
}
