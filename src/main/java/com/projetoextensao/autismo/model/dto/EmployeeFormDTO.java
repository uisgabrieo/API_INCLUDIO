package com.projetoextensao.autismo.model.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

public record EmployeeFormDTO(
		String firstName, 
		String lastName, 
		String email, 
		String password, 
		TypeAccount account,
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		LocalDate dateOfBirth, 
		String cpf, 
		String country, 
		String state, 
		String city, 
		String cep,
		String numberPhone) {

}
