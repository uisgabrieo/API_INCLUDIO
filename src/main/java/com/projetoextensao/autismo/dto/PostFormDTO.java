package com.projetoextensao.autismo.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.projetoextensao.autismo.model.entities.enums.JobType;

public record PostFormDTO(
		String role,
		JobType jobType,
		@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy") 
		LocalDate createAt,
		String country,
		String state,
		String city,
		List<String> field,
		String requirements, 
		String description) {

}
