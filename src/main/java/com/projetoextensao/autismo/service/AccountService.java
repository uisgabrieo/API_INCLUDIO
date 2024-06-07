package com.projetoextensao.autismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.account.AccountLoginDTO;
import com.projetoextensao.autismo.model.entities.Account;
import com.projetoextensao.autismo.respository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	@Autowired
	private EmployeeService employeeService;
	
	public Account saveAccount(AccountFormDTO accountDTO) {
		Account account = dtoFromAccount(accountDTO);
		Account accountSave = repository.save(account);
		return accountSave;
	}
	
	public String valiation(AccountLoginDTO login) {
		System.out.println("SERVICE");
		Optional<Account> account = repository.findByEmail(login.email());
		System.out.println("SERVICE:" + account.get());
		if (account.get().getPassword().equals(login.password())) {
			String id = searchId(account.get());
			System.out.println("true");
			return id;
		}
		System.out.println("false");
		return null;
	}
//	public Boolean valiation(AccountLoginDTO login) {
//		System.out.println("SERVICE");
//		Optional<Account> account = repository.findByEmail(login.email());
//		System.out.println("SERVICE:" + account.get());
//		if (account.get().getPassword().equals(login.password())) {
//			System.out.println("true");
//			return true;
//		}
//		System.out.println("false");
//		return false;
//	}
	public String searchId(Account obj) {
		
		String email = obj.getEmail();
		String id = employeeService.searchId(email);
		
		return id;
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
