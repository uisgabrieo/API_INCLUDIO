package com.projetoextensao.autismo.dto;

import com.projetoextensao.autismo.model.entities.EmployerAccount;

public record AuthorDTO (
		String id, 
		String name, 
		String email, 
		String companyName) {
	
	public AuthorDTO(EmployerAccount employer) {
        this(employer.getId(), employer.getCompleteName(), employer.getEmail(), employer.getCompanyName());
    }
}
