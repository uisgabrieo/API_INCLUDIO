package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "employee_accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeAccount extends Account{
	
	@Id
	private String id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;
	private String cpf;
	private String country;
	private String state;
	private String city;
	private String cep;
	private String numberPhone;
	private String diagnostic;
	private String photograph;
	private GenderUser gender;
	
	public EmployeeAccount(String completeName, String email, String password, TypeAccount account, String id,
			LocalDate dateOfBirth, String cpf, String country, String state, String city, String cep,
			String numberPhone, String diagnostic, String photograph, GenderUser gender) {
		super(completeName, email, password, account);
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.cpf = cpf;
		this.country = country;
		this.state = state;
		this.city = city;
		this.cep = cep;
		this.numberPhone = numberPhone;
		this.diagnostic = diagnostic;
		this.photograph = photograph;
		this.gender = gender;
	}

	public EmployeeAccount(String id, LocalDate dateOfBirth, String cpf, String country, String state, String city,
			String cep, String numberPhone, String diagnostic, String photograph, GenderUser gender) {
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.cpf = cpf;
		this.country = country;
		this.state = state;
		this.city = city;
		this.cep = cep;
		this.numberPhone = numberPhone;
		this.diagnostic = diagnostic;
		this.photograph = photograph;
		this.gender = gender;
	}
	
	

	public EmployeeAccount() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getNumberPhone() {
		return numberPhone;
	}

	public void setNumberPhone(String numberPhone) {
		this.numberPhone = numberPhone;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
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
