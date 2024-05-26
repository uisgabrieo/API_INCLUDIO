package com.projetoextensao.autismo.model.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public record EmployerFormDTO(
		String id,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		LocalDate createdAt,
		String companyName,
		String cnpj,
		String companyEmail,
		String website,
		String country,
		String state,
		String city,
		String numberPhone,
		String cep,
		String description) {

}
