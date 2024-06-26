package com.projetoextensao.autismo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.account.AccountLoginDTO;
import com.projetoextensao.autismo.dto.account.AccountResponseDTO;
import com.projetoextensao.autismo.model.entities.Account;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;
import com.projetoextensao.autismo.respository.AccountRepository;

@Service
public class AccountService implements UserDetailsService{

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

	public AccountResponseDTO searchId(AccountLoginDTO obj, String token) {
		String email = obj.email();
		UserDetails user = repository.findByEmail(email);
		
		Account account = (Account) user;
		if (account.getAccount().equals(TypeAccount.EMPLOYEE)) {
			String id = employeeService.searchId(email);	
			AccountResponseDTO accountResponse = new AccountResponseDTO(id, token, account.getAccount());
			return accountResponse;
		} else if (account.getAccount().equals(TypeAccount.EMPLOYER)) {
			String id = employerService.searchId(email);
			AccountResponseDTO accountResponse = new AccountResponseDTO(id, token, account.getAccount());
			return accountResponse;
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		return repository.findByEmail(email);
	}
	
}
