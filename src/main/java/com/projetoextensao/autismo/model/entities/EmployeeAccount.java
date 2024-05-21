package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAccount extends Account{
	
	@Id
	private String id;
	private LocalDate dateOfBirth;
	private String cpf;
	private String country;
	private String state;
	private String city;
	private String cep;
	private String numberPhone;
	
	public EmployeeAccount(String firstName, String lastName, String email, String password, TypeAccount account,
			String id, LocalDate dateOfBirth, String cpf, String country, String state, String city, String cep,
			String numberPhone) {
		super(firstName, lastName, email, password, account);
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.cpf = cpf;
		this.country = country;
		this.state = state;
		this.city = city;
		this.cep = cep;
		this.numberPhone = numberPhone;
	}
	
	
	
}
