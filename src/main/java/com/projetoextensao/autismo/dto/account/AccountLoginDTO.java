package com.projetoextensao.autismo.dto.account;

import jakarta.validation.constraints.Email;

public record AccountLoginDTO(
		@Email 
		String email, 
		String password) {

}
