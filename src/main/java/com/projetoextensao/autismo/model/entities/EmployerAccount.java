package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "employer_accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployerAccount extends Account{
	
	@Id
	private String id;
	private LocalDate createdAt;
	private String companyName;
	private String cnpj;
	private String companyEmail;
	private String website;
	private String country;
	private String state;
	private String city;
	private String numberPhone;
	private String cep;
	private String description;
	
	public EmployerAccount(String firstName, String lastName, String email, String password, TypeAccount account,
			String id, LocalDate createdAt, String companyName, String cnpj, String companyEmail, String website,
			String country, String state, String city, String numberPhone, String cep, String description) {
		super(firstName, lastName, email, password, account);
		this.id = id;
		this.createdAt = createdAt;
		this.companyName = companyName;
		this.cnpj = cnpj;
		this.companyEmail = companyEmail;
		this.website = website;
		this.country = country;
		this.state = state;
		this.city = city;
		this.numberPhone = numberPhone;
		this.cep = cep;
		this.description = description;
	}
	
	
	
}
