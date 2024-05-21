package com.projetoextensao.autismo.model.dto;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public record EmployeeFormDTO(
		@DateTimeFormat(pattern = "dd/MM/yyyy")
		LocalDate dateOfBirth, 
		String cpf, 
		String country, 
		String state, 
		String city, 
		String cep,
		String numberPhone) {

}
