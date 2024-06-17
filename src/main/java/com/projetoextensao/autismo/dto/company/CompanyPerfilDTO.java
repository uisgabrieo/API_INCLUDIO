package com.projetoextensao.autismo.dto.company;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.dto.employer.EmployerPerfilDTO;

public record CompanyPerfilDTO(
		EmployerPerfilDTO employer,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") 
		LocalDate createdAt,
		String companyName,
		String email,
		String logo,
		String website,
		String country, 
		String state, 
		String city, 
		String numberPhone, 
		String cep, 
		String description
		) {

}
