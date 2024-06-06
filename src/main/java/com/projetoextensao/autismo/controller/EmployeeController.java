package com.projetoextensao.autismo.controller;

import java.time.LocalDate;
import java.util.List;

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

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.employee.EmployeeFormDTO;
import com.projetoextensao.autismo.model.entities.EmployeeAccount;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;
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
	
	@PostMapping(value = "/register")
	public ResponseEntity<EmployeeAccount> registerEmployee(
			@RequestParam("diagnostic") MultipartFile diagnostic,
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
            @RequestParam("account") TypeAccount account) {
		
		EmployeeFormDTO employeeDTO = new EmployeeFormDTO(dateOfBirth, cpf, country, state, city, cep, numberPhone, diagnostic, photograph, gender);
        AccountFormDTO accountDTO = new AccountFormDTO(completeName, email, password, account);

		System.out.println(employeeDTO);
		System.out.println(accountDTO);
		EmployeeAccount employeeSave = service.saveEmployee(accountDTO, employeeDTO);
		accountService.saveAccount(accountDTO);
		
		return new ResponseEntity<>(employeeSave, HttpStatus.OK);
	}
	
	
//	@GetMapping
//	public ResponseEntity<EmployeePerfil> findEmployee(@RequestParam("email") String email) {
//		
//		return null;
//	}
	
	@GetMapping
	public ResponseEntity<List<EmployeeAccount>> findAll() {
		List<EmployeeAccount> employeeAll = service.findAll();
		return new ResponseEntity<>(employeeAll, HttpStatus.OK);
	}
}
