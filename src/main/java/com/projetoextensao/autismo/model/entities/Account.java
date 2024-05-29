package com.projetoextensao.autismo.model.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import com.projetoextensao.autismo.model.entities.enums.TypeAccount;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

	private String completeName;
	private String email;
	private String password;
	private TypeAccount account;
	
}
