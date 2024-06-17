package com.projetoextensao.autismo.dto.company;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.EmployerAccount;

public record CompanyFormDTO (
		EmployerAccount employer,
		MultipartFile logo,
		String companyName,
		String companyEmail,
		String country,
		String state,
		String city,
		String cep,
		String neighborhood,
		String street,
		String numCompany,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		LocalDate createdAt,
		String cnpj,
		String website,
		String numberPhone,
		String description){

}
