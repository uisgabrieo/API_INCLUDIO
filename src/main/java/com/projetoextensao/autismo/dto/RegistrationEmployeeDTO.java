package com.projetoextensao.autismo.dto;

import com.projetoextensao.autismo.dto.account.AccountFormDTO;
import com.projetoextensao.autismo.dto.employee.EmployeeFormDTO;

import jakarta.validation.Valid;

public record RegistrationEmployeeDTO (@Valid EmployeeFormDTO employeeDTO, AccountFormDTO accountDTO) {
	
}
