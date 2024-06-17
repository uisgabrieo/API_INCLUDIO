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
		Optional<Account> account = repository.findByEmail(login.email());
		if (account.get().getPassword().equals(login.password())) {
			AccountResponseDTO accountResponse = searchId(account.get());
			return accountResponse;
		}
		return null;
	}

	public AccountResponseDTO searchId(Account obj) {
		String email = obj.getEmail();
		if (obj.getAccount().equals(TypeAccount.EMPLOYEE)) {
			String id = employeeService.searchId(email);	
			AccountResponseDTO account = new AccountResponseDTO(id, obj.getAccount());
			return account;
		} else if (obj.getAccount().equals(TypeAccount.EMPLOYER)) {
			String id = employerService.searchId(email);
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
