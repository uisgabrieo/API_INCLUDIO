package com.projetoextensao.autismo.model.dto;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

public record AccountDTO(String firstName, String lastName, String email, String password, TypeAccount account) {

}
