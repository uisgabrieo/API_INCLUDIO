package com.projetoextensao.autismo.model.dto;

import com.projetoextensao.autismo.model.dto.account.AccountFormDTO;

import jakarta.validation.Valid;

public record RegistrationEmployerDTO (@Valid EmployerFormDTO employerDTO, AccountFormDTO accountDTO) {
	
}
