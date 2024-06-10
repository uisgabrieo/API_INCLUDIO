package com.projetoextensao.autismo.dto.employer;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;

public record EmployerPerfilDTO(
		String completeName,
		String email,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") 
		LocalDate dateOfBirth,
		String country, 
		String state, 
		String city, 
		String cep, 
		String numberPhone, 
		String photograph,
		GenderUser gender) {

}
