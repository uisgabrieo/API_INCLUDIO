package com.projetoextensao.autismo.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.dto.account.AccountLoginDTO;
import com.projetoextensao.autismo.dto.account.AccountResponseDTO;
import com.projetoextensao.autismo.model.entities.Account;
import com.projetoextensao.autismo.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private AccountService service;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<AccountResponseDTO> loginAccount(@RequestBody @Valid AccountLoginDTO login) {

		var loginUser = new UsernamePasswordAuthenticationToken(login.email(), login.password());
		var auth = authenticationManager.authenticate(loginUser);
		
		if(auth.isAuthenticated()) {
			var token = tokenService.generateToken((Account)auth.getPrincipal());
			
			AccountResponseDTO accountResponse = service.searchId(login, token);
			return new ResponseEntity<>(accountResponse, HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
