package com.projetoextensao.autismo.dto.account;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

public record AccountFormDTO(
		String completeName, 
		String email, 
		String password, 
		TypeAccount account) {

}
