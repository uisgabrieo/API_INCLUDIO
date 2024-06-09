package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;
import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployerAccount extends Account{
	
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
	private String photograph;
	private GenderUser gender;
	
	public EmployerAccount(String completeName, String email, String password, TypeAccount account, String id,
			LocalDate dateOfBirth, String cpf, String country, String state, String city, String cep,
			String numberPhone, String photograph, GenderUser gender) {
		super(completeName, email, password, account);
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.cpf = cpf;
		this.country = country;
		this.state = state;
		this.city = city;
		this.cep = cep;
		this.numberPhone = numberPhone;
		this.photograph = photograph;
		this.gender = gender;
	}
	
}
