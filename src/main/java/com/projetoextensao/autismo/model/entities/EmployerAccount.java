package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "employer_accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployerAccount extends Account{
	
	@Id
	private String id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
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
	
	public EmployerAccount(String completeName, String email, String password, TypeAccount account,
			String id, LocalDate createdAt, String companyName, String cnpj, String companyEmail, String website,
			String country, String state, String city, String numberPhone, String cep, String description) {
		super(completeName, email, password, account);
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
