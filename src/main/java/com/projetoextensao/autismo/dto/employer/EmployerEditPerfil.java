package com.projetoextensao.autismo.dto.employer;

import org.springframework.web.multipart.MultipartFile;

import com.projetoextensao.autismo.model.entities.enums.GenderUser;

public record EmployerEditPerfil(
		String country, 
		String state, 
		String city, 
		String complement,
		String cep,
		String completeName,
		String numberPhone,
		GenderUser gende,
		MultipartFile photograph,
		String jobTitle
		) {

}
