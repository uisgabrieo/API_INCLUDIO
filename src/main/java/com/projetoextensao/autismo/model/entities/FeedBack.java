package com.projetoextensao.autismo.model.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "feedBack")
public class FeedBack {

	private String completeName;
	private String email;
	private String description;
	
	public FeedBack(String completeName, String email, String description) {
		this.completeName = completeName;
		this.email = email;
		this.description = description;
	}

	public FeedBack() {
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FeedBack [completeName=" + completeName + ", email=" + email + ", description=" + description + "]";
	}
	
	
	
}
