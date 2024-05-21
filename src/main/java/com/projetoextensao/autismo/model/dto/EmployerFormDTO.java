package com.projetoextensao.autismo.model.dto;

import java.time.LocalDate;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

public record EmployerFormDTO(
		String firstName, 
		String lastName, 
		String email, 
		String password, 
		TypeAccount account,
		String id,
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
