package com.projetoextensao.autismo.dto;

import com.projetoextensao.autismo.config.util.ConvertionImgFromBase64;
import com.projetoextensao.autismo.model.entities.Company;

public record AuthorDTO (
		String id,
		String logo,
		String name, 
		String email, 
		String companyName) {
	
	public AuthorDTO(Company company) {
        this(company.getEmployer().getId(), ConvertionImgFromBase64.showImage(company.getLogo()), company.getEmployer().getCompleteName(), company.getCompanyEmail(), company.getCompanyName());
    }
}
