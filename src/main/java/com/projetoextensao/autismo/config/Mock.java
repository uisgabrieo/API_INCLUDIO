package com.projetoextensao.autismo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.projetoextensao.autismo.dto.AuthorDTO;
import com.projetoextensao.autismo.model.entities.Account;
import com.projetoextensao.autismo.model.entities.EmployeeAccount;
import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.model.entities.Post;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.JobType;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;
import com.projetoextensao.autismo.respository.AccountRepository;
import com.projetoextensao.autismo.respository.EmployeeRepository;
import com.projetoextensao.autismo.respository.EmployerRepository;
import com.projetoextensao.autismo.respository.PostRepository;

@Configuration
public class Mock implements CommandLineRunner{
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployerRepository employerRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		accountRepository.deleteAll();
		employeeRepository.deleteAll();
		employerRepository.deleteAll();
		postRepository.deleteAll();
		
		Account af1 = new Account("Luis Gabriel", "luisgabriel@gmail.com", "123456", TypeAccount.EMPLOYEE);
		EmployeeAccount f1 = new EmployeeAccount(
				"Luis Gabriel", "luisgabriel@gmail.com", "123456", TypeAccount.EMPLOYEE, null, 
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
		
		Post p1 = new Post(null, "Dev back-end", JobType.REMOTE, LocalDate.now(), "Vaga para desenvolvedor back-end", "Saber Spring, Java 8+", new AuthorDTO(e1));
		Post p2 = new Post(null, "Secretário(a)", JobType.IN_PRESON, LocalDate.now(), "Vaga para secretário(a) de clínica psiquiatrica", "Habilidade com o público", new AuthorDTO(e1));

		p1.getField().addAll(Arrays.asList("Tecnologia", "Contabiliades"));
		p2.getField().addAll(Arrays.asList("Livre"));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
		
		e1.getPosts().addAll(Arrays.asList(p1, p2));
		
		employerRepository.save(e1);
		
	}
	
}
