package com.projetoextensao.autismo.model.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public record EmployerFormDTO(
		String id,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		LocalDate createdAt,
		@Size(min = 1, max = 20, message = "Número mínimo de letras (1), máximo (20)")
		String companyName,
		@CNPJ(message = "CNPJ inválido")
		String cnpj,
		@Email(message = "Email inválido!")
		String companyEmail,
		String website,
		String country,
		String state,
		String city,
		String numberPhone,
		String cep,
		@Size(max = 500)
		String description) {

}
