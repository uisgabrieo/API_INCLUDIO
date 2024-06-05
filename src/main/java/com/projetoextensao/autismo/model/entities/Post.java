package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.projetoextensao.autismo.dto.AuthorDTO;
import com.projetoextensao.autismo.model.entities.enums.JobType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "posts")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
	
	@Id
	private String id;
	private String role;
	private JobType jobType;
	private LocalDate createAt;
	private String description;
	private String requirements;
	private List<String> field = new ArrayList<>();
	
	private AuthorDTO author; 
	
	public Post (String id, String role, JobType jobType, LocalDate createAt, String decription, String requirements, AuthorDTO author) {
		this.id = id;
		this.role = role;
		this.jobType = jobType;
		this.createAt = createAt;
		this.description = decription;
		this.requirements = requirements;
		this.author = author;
	}
	
}
