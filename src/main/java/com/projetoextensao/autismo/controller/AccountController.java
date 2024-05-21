package com.projetoextensao.autismo.controller;

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
	public void registerAccount(@RequestBody AccountFormDTO accountDTO, HttpSession session) {
		if (accountDTO.account().equals(TypeAccount.EMPLOYEE)) {
			
			session.setAttribute("employeeData", accountDTO);
		} else if (accountDTO.account().equals(TypeAccount.EMPLOYER)) {
			
			session.setAttribute("employerData", accountDTO);
		}
	}
}
