package com.projetoextensao.autismo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projetoextensao.autismo.dto.company.CompanyFormDTO;
import com.projetoextensao.autismo.dto.company.CompanyPerfilDTO;
import com.projetoextensao.autismo.model.entities.Company;
import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.service.CompanyService;
import com.projetoextensao.autismo.service.EmployerService;


@Controller
@RestController
@RequestMapping("/api/account/company")
public class CompanyController {
	
	@Autowired
	private CompanyService service;
	
	@Autowired
	private EmployerService employerService;
	
	@PostMapping(value = "/register")
	public ResponseEntity<Company> registerEmployer(
			@RequestParam("idEmployer") String id,
            @RequestParam("logo") MultipartFile logo,
            @RequestParam("companyName") String companyName,
            @RequestParam("companyEmail") String companyEmail,
            @RequestParam("country") String countryCompany,
            @RequestParam("state") String stateCompany,
            @RequestParam("city") String cityCompany,
            @RequestParam("cep") String cepCompany,
            @RequestParam("neighborhood") String neighborhoodCompany,
            @RequestParam("street") String street,
            @RequestParam("numCompany") String numCompany,
            @RequestParam("createdAt") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate createdAt,
            @RequestParam("cnpj") String cnpj,
            @RequestParam("website") String website,
            @RequestParam("numberPhone") String numberPhoneCompany,
            @RequestParam("desciption") String description) {
		
		EmployerAccount employer = employerService.findById(id);
		CompanyFormDTO companyDTO = new CompanyFormDTO(employer, logo, companyName, companyEmail, countryCompany, stateCompany, cityCompany, cepCompany, neighborhoodCompany, street, numCompany, createdAt, cnpj, website, numberPhoneCompany, description);

		Company companySave	 = service.saveCompany(companyDTO);
		;
		return new ResponseEntity<>(companySave, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CompanyPerfilDTO> findById(@RequestParam String id) {

		CompanyPerfilDTO company = service.findById(id);
		
		return new ResponseEntity<>(company, HttpStatus.OK);
	}
	
}
