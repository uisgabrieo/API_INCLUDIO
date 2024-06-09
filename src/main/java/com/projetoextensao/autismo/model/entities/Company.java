package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Company{
	
	@Id
	private String id;
	private EmployerAccount employer;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate createdAt;
	private String companyName;
	private String cnpj;
	private String logo;
	private String companyEmail;
	private String website;
	private String country;
	private String state;
	private String city;
	private String numberPhone;
	private String cep;
	private String description;
	
	@Setter(value = AccessLevel.PRIVATE)
	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();
	
	public Company(String id, EmployerAccount employer, LocalDate createdAt, String companyName, String cnpj, String logo, String companyEmail, String website,
			String country, String state, String city, String numberPhone, String cep, String description) {
		this.id = id;
		this.employer = employer;
		this.createdAt = createdAt;
		this.companyName = companyName;
		this.cnpj = cnpj;
		this.logo = logo;
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
