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
	
	public Account saveAccount(AccountFormDTO accountDTO) {
		Account account = dtoFromAccount(accountDTO);
		Account accountSave = repository.save(account);
		return accountSave;
	}
	
	public Boolean valiation(AccountLoginDTO login) {
		Optional<Account> account = repository.findByEmail(login.email());
		
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
