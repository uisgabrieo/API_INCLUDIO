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

	public Post(String id, String role, JobType jobType, LocalDate createAt, String description, String requirements,
			List<String> field, AuthorDTO author) {
		this.id = id;
		this.role = role;
		this.jobType = jobType;
		this.createAt = createAt;
		this.description = description;
		this.requirements = requirements;
		this.field = field;
		this.author = author;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public JobType getJobType() {
		return jobType;
	}

	public void setJobType(JobType jobType) {
		this.jobType = jobType;
	}

	public LocalDate getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDate createAt) {
		this.createAt = createAt;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public List<String> getField() {
		return field;
	}

	public void setField(List<String> field) {
		this.field = field;
	}

	public AuthorDTO getAuthor() {
		return author;
	}

	public void setAuthor(AuthorDTO author) {
		this.author = author;
	}
	
	
	
}
