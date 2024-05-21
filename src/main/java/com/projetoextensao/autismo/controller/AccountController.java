package com.projetoextensao.autismo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.model.dto.AccountDTO;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

@Controller
@RestController
@RequestMapping("/api/account")
public class AccountController {

	@PostMapping
	public ResponseEntity<?> registerAccount(@RequestBody AccountDTO accountDTO) {
		if (accountDTO.account().equals(TypeAccount.EMPLOYEE)) {
			System.out.println(accountDTO.toString());
			System.out.println("Controller Account");
			return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
					.header(HttpHeaders.LOCATION, "/api/account/employee/register").build();
		} else if (accountDTO.account().equals(TypeAccount.EMPLOYER)) {
			return ResponseEntity.status(HttpStatus.PERMANENT_REDIRECT)
					.header(HttpHeaders.LOCATION, "/api/account/employer/register").build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Type Account Invalid");
	}
}
