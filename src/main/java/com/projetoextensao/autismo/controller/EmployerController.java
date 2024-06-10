package com.projetoextensao.autismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.dto.company.CompanyPerfilDTO;
import com.projetoextensao.autismo.model.entities.Company;
import com.projetoextensao.autismo.service.CompanyService;

@Controller
@RestController
@RequestMapping("/api/account/employer")
public class EmployerController {
	
	@Autowired
	private CompanyService companyService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<CompanyPerfilDTO> findEmployee(@PathVariable String id) {
		
		Company company = companyService.findById(id);
		CompanyPerfilDTO companyPerfil = companyService.fromCompanyPerfil(company);
		
		return new ResponseEntity<>(companyPerfil, HttpStatus.OK);
	}
}
