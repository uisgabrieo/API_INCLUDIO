package com.projetoextensao.autismo.model.dto;

import jakarta.validation.Valid;

public record RegistrationEmployeeDTO (@Valid EmployeeFormDTO employeeDTO, AccountFormDTO accountDTO) {
	
}
