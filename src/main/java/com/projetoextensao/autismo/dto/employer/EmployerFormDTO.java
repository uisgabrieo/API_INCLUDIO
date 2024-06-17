package com.projetoextensao.autismo.dto.employer;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;

public record EmployerFormDTO(
		String id,
		String country, 
		String state, 
		String city, 
		String cep,
		String complement,
		@CPF(message = "Insira um CPF válido!")
		String cpf, 
		String numberPhone,
		String jobTitle,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		LocalDate dateOfBirth, 
		MultipartFile photograph,
		GenderUser gender) {
}
