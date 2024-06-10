package com.projetoextensao.autismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.account.AccountLoginDTO;
import com.projetoextensao.autismo.dto.account.AccountResponseDTO;
import com.projetoextensao.autismo.model.entities.Account;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;
import com.projetoextensao.autismo.respository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployerService employerService;
	
	public Account saveAccount(AccountFormDTO accountDTO) {
		Account account = dtoFromAccount(accountDTO);
		Account accountSave = repository.save(account);
		return accountSave;
	}
	
	public AccountResponseDTO valiation(AccountLoginDTO login) {
		System.out.println(login);
		Optional<Account> account = repository.findByEmail(login.email());
		System.out.println("account: " + account );
		if (account.get().getPassword().equals(login.password())) {
			AccountResponseDTO accountResponse = searchId(account.get());
			System.out.println(accountResponse);
			return accountResponse;
		}
		return null;
	}

	public AccountResponseDTO searchId(Account obj) {
		System.out.println("Antes do get: " + obj);
		String email = obj.getEmail();
		System.out.println("Email: " + email);
		if (obj.getAccount().equals(TypeAccount.EMPLOYEE)) {
			String id = employeeService.searchId(email);	
			System.out.println("id: " + id);
			AccountResponseDTO account = new AccountResponseDTO(id, obj.getAccount());
			return account;
		} else if (obj.getAccount().equals(TypeAccount.EMPLOYER)) {
			System.out.println("id Employer entrou ");
			String id = employerService.searchId(email);
			System.out.println("id: " + id );
			AccountResponseDTO account = new AccountResponseDTO(id, obj.getAccount());
			return account;
		}
		return null;
	}
	
	private Account dtoFromAccount(AccountFormDTO dto) {
		Account account = new Account(
				dto.completeName(), 
				dto.email(), 
				dto.password(), 
				dto.account()); 
		return account;
	}
	
}
