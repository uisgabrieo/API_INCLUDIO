package com.projetoextensao.autismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.config.security.TokenService;
import com.projetoextensao.autismo.dto.account.AccountLoginDTO;
import com.projetoextensao.autismo.dto.account.AccountResponseDTO;
import com.projetoextensao.autismo.model.entities.Account;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<AccountResponseDTO> loginAccount(@RequestBody @Valid AccountLoginDTO login) {

		var loginUser = new UsernamePasswordAuthenticationToken(login.email(), login.password());
		var auth = authenticationManager.authenticate(loginUser);
		
		var token = tokenService.generateToken((Account)auth.getPrincipal());
		
		return new ResponseEntity<>(new AccountResponseDTO(token), HttpStatus.OK);

	}
	

}
