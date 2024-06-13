package com.projetoextensao.autismo.dto.employee;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.GenderUser;

public record EmployeeFormDTO(
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		String country, 
		String state, 
		String city, 
		String cep,
		String complement,
		@CPF
		String cpf, 
		String numberPhone,
		String sector,
		String training,
		String institution,
		LocalDate dateOfBirth, 
		GenderUser gender,
		MultipartFile diagnostic,
		MultipartFile photograph
		) {

}
