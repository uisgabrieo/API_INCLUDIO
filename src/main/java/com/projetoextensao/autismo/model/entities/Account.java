package com.projetoextensao.autismo.model.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

@Document(collection = "accounts")
public class Account {

	private String completeName;
	private String email;
	private String password;
	private TypeAccount account;
	
	public Account(String completeName, String email, String password, TypeAccount account) {
		this.completeName = completeName;
		this.email = email;
		this.password = password;
		this.account = account;
	}

	public Account() {
		
	}

	public String getCompleteName() {
		return completeName;
	}

	public void setCompleteName(String completeName) {
		this.completeName = completeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TypeAccount getAccount() {
		return account;
	}

	public void setAccount(TypeAccount account) {
		this.account = account;
	}
	
	
	
}
