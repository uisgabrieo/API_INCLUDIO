package com.projetoextensao.autismo.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record EmployeeFormDTO(
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		LocalDate dateOfBirth, 
		String cpf, 
		String country, 
		String state, 
		String city, 
		String cep,
		String numberPhone) {

}
