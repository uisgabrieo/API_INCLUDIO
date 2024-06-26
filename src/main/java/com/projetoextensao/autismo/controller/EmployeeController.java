package com.projetoextensao.autismo.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.employee.EmployeeFormDTO;
import com.projetoextensao.autismo.dto.employee.EmployeePerfilDTO;
import com.projetoextensao.autismo.model.entities.EmployeeAccount;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;
import com.projetoextensao.autismo.respository.EmployeeRepository;
import com.projetoextensao.autismo.service.AccountService;
import com.projetoextensao.autismo.service.EmployeeService;

@Controller
@RestController
@RequestMapping("/api/account/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping(value = "/register")
	public ResponseEntity<EmployeeAccount> registerEmployee(
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
            @RequestParam("sector") String sector,
            @RequestParam("training") String training,
            @RequestParam("institution") String institution,
            @RequestParam("dateOfBirth") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate dateOfBirth,
            @RequestParam(required = false,value = "photograph") MultipartFile photograph,
			@RequestParam(required = false, value = "diagnostic") MultipartFile diagnostic,
            @RequestParam("gender") GenderUser gender) {
		
		if (!employeeRepository.findByEmail(email).isEmpty()) {
			System.out.println("Empty: " + employeeRepository.findByEmail(email).toString());
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		String encryptedPassword = new BCryptPasswordEncoder().encode(password);
		
		
		EmployeeFormDTO employeeDTO = new EmployeeFormDTO(country, state, city, cep, complement, cpf, numberPhone, sector, training, institution, dateOfBirth, gender, diagnostic, photograph);
        AccountFormDTO accountDTO = new AccountFormDTO(completeName, email, encryptedPassword, account);        
        
		service.saveEmployee(accountDTO, employeeDTO);
		accountService.saveAccount(accountDTO);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<EmployeePerfilDTO> findEmployee(@PathVariable String id) {
		
		EmployeePerfilDTO employee = service.findById(id);
		
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
}
