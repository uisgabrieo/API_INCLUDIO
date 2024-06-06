package com.projetoextensao.autismo.dto;

import com.projetoextensao.autismo.model.entities.EmployerAccount;
import com.projetoextensao.autismo.model.util.ConvertionImgFromBase64;

public record AuthorDTO (
		String id, 
		String logo,
		String name, 
		String email, 
		String companyName) {
	
	public AuthorDTO(EmployerAccount employer) {
        this(employer.getId(), ConvertionImgFromBase64.showImage(employer.getLogo()), employer.getCompleteName(), employer.getEmail(), employer.getCompanyName());
    }
}
