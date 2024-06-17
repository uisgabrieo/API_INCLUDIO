package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;	

@Document(collection = "company")
public class Company{
	@Id
	private String id;
	private EmployerAccount employer;
	private String logo;
	private String companyName;
	private String companyEmail;
	private String country;
	private String state;
	private String city;
	private String cep;
	private String neighborhood;
	private String street;
	private String numCompany;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate createdAt;
	private String cnpj;
	private String website;
	private String numberPhone;
	private String description;

	@DBRef(lazy = true)
	private List<Post> posts = new ArrayList<>();

	public Company(String id, EmployerAccount employer, String logo, String companyName, String companyEmail,
			String country, String state, String city, String cep, String neighborhood, String street,
			String numCompany, LocalDate createdAt, String cnpj, String website, String numberPhone, String description) {
		this.id = id;
		this.employer = employer;
		this.logo = logo;
		this.companyName = companyName;
		this.companyEmail = companyEmail;
		this.country = country;
		this.state = state;
		this.city = city;
		this.cep = cep;
		this.neighborhood = neighborhood;
		this.street = street;
		this.numCompany = numCompany;
		this.createdAt = createdAt;
		this.cnpj = cnpj;
		this.website = website;
		this.numberPhone = numberPhone;
		this.description = description;
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

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyEmail() {
		return companyEmail;
	}

	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumCompany() {
		return numCompany;
	}

	public void setNumCompany(String numCompany) {
		this.numCompany = numCompany;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
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
