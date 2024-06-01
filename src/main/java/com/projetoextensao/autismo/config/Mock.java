package com.projetoextensao.autismo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projetoextensao.autismo.model.entities.Account;
import com.projetoextensao.autismo.model.entities.EmployeeAccount;
import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;
import com.projetoextensao.autismo.respository.AccountRepository;
import com.projetoextensao.autismo.respository.EmployeeRepository;
import com.projetoextensao.autismo.respository.EmployerRepository;

@Configuration
public class Mock implements CommandLineRunner{
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployerRepository employerRepository;

	@Override
	public void run(String... args) throws Exception {
		accountRepository.deleteAll();
		employeeRepository.deleteAll();
		employerRepository.deleteAll();
		
		Account af1 = new Account("Luis Gabriel", "luisgabriel@gamil.com", "123456", TypeAccount.EMPLOYEE);
		EmployeeAccount f1 = new EmployeeAccount(
				"Luis Gabriel", "luisgabriel@gamil.com", "123456", TypeAccount.EMPLOYEE, null, 
				LocalDate.parse("03/07/2004", fmt), "74797948353", "Brasil", "Piaui", "Teresina", "64000500", 
				"55 89994310337", "diagnostico", "fotoPerfil", GenderUser.MALE);
		
		Account ae1 = new Account("Ingrid", "ingrid@gmail.com", "12345", TypeAccount.EMPLOYER);
		EmployerAccount e1 = new EmployerAccount("Ingrid", "ingrid@gmail.com", "12345", TypeAccount.EMPLOYER,
				null, LocalDate.parse("16/05/2024", fmt), "includio", "51789452000137", "includio@gmail.com", "http://127.0.0.1:5500/index.html",
				"Brasil", "Piaui", "Teresina", "55 86994310377", "64099999", "Inclusão de autistas");
		
		accountRepository.save(af1);
		employeeRepository.save(f1);
		accountRepository.save(ae1);
		employerRepository.save(e1);
		
		
	}
	
}
