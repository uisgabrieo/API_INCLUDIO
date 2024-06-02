package com.projetoextensao.autismo.model.dto.account;

import jakarta.validation.constraints.Email;

public record AccountLoginDTO(
		@Email 
		String email, 
		String password) {

}
