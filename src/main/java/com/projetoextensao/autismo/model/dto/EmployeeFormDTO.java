package com.projetoextensao.autismo.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;

public record EmployeeFormDTO(
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		LocalDate dateOfBirth, 
		String cpf, 
		String country, 
		String state, 
		String city, 
		String cep,
		String numberPhone,
		String diagnostic,
		String photograph,
		GenderUser gender) {

}
