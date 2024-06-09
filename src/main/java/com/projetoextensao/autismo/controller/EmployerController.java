package com.projetoextensao.autismo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projetoextensao.autismo.dto.CompanyFormDTO;
import com.projetoextensao.autismo.dto.EmployerFormDTO;
import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.model.entities.Company;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;
import com.projetoextensao.autismo.service.AccountService;
import com.projetoextensao.autismo.service.CompanyService;

@Controller
@RestController
@RequestMapping("/api/account/employer")
public class EmployerController {
	
	@Autowired
	private CompanyService service;
	
	@Autowired
	private AccountService accountService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Company> registerEmployer(
            @RequestParam("dateOfBirth") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateOfBirth,
            @RequestParam("cpf") String cpf,
            @RequestParam("country") String country,
            @RequestParam("state") String state,
            @RequestParam("city") String city,
            @RequestParam("cep") String cep,
            @RequestParam("numberPhone") String numberPhone,
            @RequestParam("photograph") MultipartFile photograph,
            @RequestParam("gender") GenderUser gender,
            @RequestParam("completeName") String completeName,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("account") TypeAccount account,
            @RequestParam("createdAt") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate createdAt,
            @RequestParam("companyName") String companyName,
            @RequestParam("cnpj") String cnpj,
            @RequestParam("logo") String logo,
            @RequestParam("companyName") String companyEmail,
            @RequestParam("website") String website,
            @RequestParam("countryCompany") String countryCompany,
            @RequestParam("stateCompany") String stateCompany,
            @RequestParam("cityCompany") String cityCompany,
            @RequestParam("numberPhoneCompany") String numberPhoneCompany,
            @RequestParam("cepCompany") String cepCompany,
            @RequestParam("desciption") String description) {
		
		EmployerFormDTO employerDTO = new EmployerFormDTO(dateOfBirth, cpf, country, state, city, cep, numberPhone, photograph, gender);
		AccountFormDTO accountDTO = new AccountFormDTO(completeName, companyEmail, password, account);
		CompanyFormDTO companyDTO = new CompanyFormDTO(null, dateOfBirth, password, cpf, completeName, email, email, country, state, city, numberPhone, cep, password);

		Company companySave	 = service.saveCompany(accountDTO, employerDTO, companyDTO);
		
		accountService.saveAccount(accountDTO);
		return new ResponseEntity<>(companySave, HttpStatus.OK);
	}
	
}
