package com.projetoextensao.autismo.dto;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;

import jakarta.validation.Valid;

public record RegistrationEmployerDTO (@Valid EmployerFormDTO employerDTO, AccountFormDTO accountDTO) {
	
}
