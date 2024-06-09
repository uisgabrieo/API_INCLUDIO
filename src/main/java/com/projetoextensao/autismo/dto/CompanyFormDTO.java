package com.projetoextensao.autismo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record CompanyFormDTO (
		EmployerFormDTO employer,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		LocalDate createdAt,
		String companyName,
		String cnpj,
		String logo,
		String companyEmail,
		String website,
		String country,
		String state,
		String city,
		String numberPhone,
		String cep,
		String description){

}
