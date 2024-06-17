package com.projetoextensao.autismo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.company.CompanyPerfilDTO;
import com.projetoextensao.autismo.dto.employer.EmployerFormDTO;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;
import com.projetoextensao.autismo.service.AccountService;
import com.projetoextensao.autismo.service.CompanyService;
import com.projetoextensao.autismo.service.EmployerService;

@Controller
@RestController
@RequestMapping("/api/account/employer")
public class EmployerController {
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private EmployerService service;
	
	@PostMapping(value = "/register")
	public ResponseEntity<String> saveEmployer(
			@RequestParam("completeName") String completeName,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("account") TypeAccount account,
			@RequestParam("country") String country,
			@RequestParam("state") String state,
			@RequestParam("city") String city,
			@RequestParam("cep") String cep,
			@RequestParam("complement") String complement,
			@RequestParam("cpf") String cpf,
			@RequestParam("numberPhone") String numberPhone,
			@RequestParam("jobTitle") String jobTitle,
            @RequestParam("dateOfBirth") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateOfBirth,
            @RequestParam("photograph") MultipartFile photograph,
            @RequestParam("gender") GenderUser gender) {
		
		AccountFormDTO accountDTO = new AccountFormDTO(completeName, email, password, account);
		EmployerFormDTO employerDTO = new EmployerFormDTO(null, country, state, city, cep, cpf, complement, numberPhone, jobTitle, dateOfBirth, photograph, gender);
			
		String idEmployer = service.saveEmployer(employerDTO, accountDTO);
		accountService.saveAccount(accountDTO);
		
		return new ResponseEntity<>(idEmployer, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<CompanyPerfilDTO> findEmployee(@PathVariable String id) {
		
		CompanyPerfilDTO companyPerfil = companyService.findById(id);
		
		return new ResponseEntity<>(companyPerfil, HttpStatus.OK);
	}
}
