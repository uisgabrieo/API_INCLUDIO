package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

@Document(collection = "employer_accounts")
public class EmployerAccount extends Account{
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String country;
	private String state;
	private String city;
	private String cep;
	private String complement;
	private String cpf;
	private String numberPhone;
	private String jobTitle;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;
	private String photograph;
	private GenderUser gender;
	public EmployerAccount(String completeName, String email, String password, TypeAccount account, String id,
			String country, String state, String city, String cep, String complement, String cpf, String numberPhone,
			String jobTitle, LocalDate dateOfBirth, String photograph, GenderUser gender) {
		super(completeName, email, password, account);
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.cep = cep;
		this.complement = complement;
		this.cpf = cpf;
		this.numberPhone = numberPhone;
		this.jobTitle = jobTitle;
		this.dateOfBirth = dateOfBirth;
		this.photograph = photograph;
		this.gender = gender;
	}
	
	public EmployerAccount(String id, String country, String state, String city, String cep, String complement,
			String cpf, String numberPhone, String jobTitle, LocalDate dateOfBirth, String photograph,
			GenderUser gender) {
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.cep = cep;
		this.complement = complement;
		this.cpf = cpf;
		this.numberPhone = numberPhone;
		this.jobTitle = jobTitle;
		this.dateOfBirth = dateOfBirth;
		this.photograph = photograph;
		this.gender = gender;
	}

	public EmployerAccount() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhotograph() {
		return photograph;
	}

	public void setPhotograph(String photograph) {
		this.photograph = photograph;
	}

	public GenderUser getGender() {
		return gender;
	}

	public void setGender(GenderUser gender) {
		this.gender = gender;
	}
	
	
	
}
