package com.projetoextensao.autismo.dto.account;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

public record AccountResponseDTO(
		String id,
		String token,
		TypeAccount account) {

}
