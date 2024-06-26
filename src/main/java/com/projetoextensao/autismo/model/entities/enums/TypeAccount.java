package com.projetoextensao.autismo.model.entities.enums;

public enum TypeAccount {
	EMPLOYEE("EMPLOYEE"),
	EMPLOYER("EMPLOYER");
	
	private String typeAccount;
	
	TypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}
	
	public String getTypeAccount() {
		return typeAccount;
	}
}
