package com.projetoextensao.autismo.dto.employer;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;

public record EmployerFormDTO(
		String id,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		LocalDate dateOfBirth, 
		@CPF(message = "Insira um CPF válido!")
		String cpf, 
		String country, 
		String state, 
		String city, 
		String cep,
		String numberPhone,
		MultipartFile photograph,
		GenderUser gender) {
}
