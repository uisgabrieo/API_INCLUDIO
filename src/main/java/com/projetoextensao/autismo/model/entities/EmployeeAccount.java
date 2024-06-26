package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

@Document(collection = "employee_accounts")
public class EmployeeAccount extends Account{
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private String country;
	private String state;
	private String city;
	private String cep;
	private String complement;
	@CPF
	private String cpf;
	private String numberPhone;
	private String sector;
	private String training;
	private String institution;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;
	private GenderUser gender;
	private String diagnostic;
	private String photograph;
	
	public EmployeeAccount(String completeName, String email, String password, TypeAccount account, String id,
			String country, String state, String city, String cep, String complement, @CPF String cpf,
			String numberPhone, String sector, String training, String institution, LocalDate dateOfBirth, GenderUser gender,
			String diagnostic, String photograph) {
		super(completeName, email, password, account);
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.cep = cep;
		this.complement = complement;
		this.cpf = cpf;
		this.numberPhone = numberPhone;
		this.sector = sector;
		this.training = training;
		this.institution = institution;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.diagnostic = diagnostic;
		this.photograph = photograph;
	}

	public EmployeeAccount(String id, String country, String state, String city, String cep, String complement,
			@CPF String cpf, String numberPhone, String sector, String training, String institution, LocalDate dateOfBirth,
			GenderUser gender, String diagnostic, String photograph) {
		this.id = id;
		this.country = country;
		this.state = state;
		this.city = city;
		this.cep = cep;
		this.complement = complement;
		this.cpf = cpf;
		this.numberPhone = numberPhone;
		this.sector = sector;
		this.training = training;
		this.institution = institution;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.diagnostic = diagnostic;
		this.photograph = photograph;
	}

	public EmployeeAccount() {
		
	}

	public String getId() {
		return id;
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

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getTraining() {
		return training;
	}

	public void setTraining(String training) {
		this.training = training;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public GenderUser getGender() {
		return gender;
	}

	public void setGender(GenderUser gender) {
		this.gender = gender;
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

	@Override
	public String toString() {
		return "EmployeeAccount [id=" + id + ", country=" + country + ", state=" + state + ", city=" + city + ", cep="
				+ cep + ", complement=" + complement + ", cpf=" + cpf + ", numberPhone=" + numberPhone + ", sector="
				+ sector + ", training=" + training + ", institution=" + institution + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", diagnostic=" + diagnostic + ", photograph=" + photograph + "]";
	}
	
	
	
}
