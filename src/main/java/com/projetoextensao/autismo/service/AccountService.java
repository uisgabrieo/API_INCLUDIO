package com.projetoextensao.autismo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.model.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.model.dto.account.AccountLoginDTO;
import com.projetoextensao.autismo.model.entities.Account;
import com.projetoextensao.autismo.respository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository repository;
	
	public Account saveAccount(AccountFormDTO accountDTO) {
		Account account = dtoFromAccount(accountDTO);
		Account accountSave = repository.save(account);
		return accountSave;
	}
	
	public Boolean valiation(AccountLoginDTO login) {
		System.out.println("Entrou na validação");
		System.out.println("Email: " + login.email());
		Optional<Account> account = repository.findByEmail(login.email());
		System.out.println(account);
		if (account.get().getPassword().equals(login.password())) {
			return true;
		}
		return false;
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
