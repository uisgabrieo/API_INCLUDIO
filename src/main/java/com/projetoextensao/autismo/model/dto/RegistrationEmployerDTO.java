package com.projetoextensao.autismo.model.dto;

import jakarta.validation.Valid;

public record RegistrationEmployerDTO (@Valid EmployerFormDTO employerDTO, AccountFormDTO accountDTO) {
	
}
