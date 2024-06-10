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

	public Company(String id, EmployerAccount employer, LocalDate createdAt, String companyName, String cnpj,
			String logo, String companyEmail, String website, String country, String state, String city,
			String numberPhone, String cep, String description, List<Post> posts) {
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
		this.posts = posts;
	}

	public Company() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EmployerAccount getEmployer() {
		return employer;
	}

	public void setEmployer(EmployerAccount employer) {
		this.employer = employer;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Post> getPosts() {
		return posts;
	}
	
	
	
}
