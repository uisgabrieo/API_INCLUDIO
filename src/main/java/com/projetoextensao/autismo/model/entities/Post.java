package com.projetoextensao.autismo.model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.projetoextensao.autismo.dto.AuthorDTO;
import com.projetoextensao.autismo.model.entities.enums.JobType;

@Document(collection = "posts")
public class Post {
	
	@Id
	private String id;
	private String role;
	private JobType jobType;
	private LocalDate createAt;
	private String description;
	private String requirements;
	private String country;
	private String state;
	private String city;
	private List<String> field = new ArrayList<>();
	
	private AuthorDTO author;

	public Post(String id, String role, JobType jobType, LocalDate createAt, String description, String requirements,
			String country, String state, String city, List<String> field, AuthorDTO author) {
		this.id = id;
		this.role = role;
		this.jobType = jobType;
		this.createAt = createAt;
		this.description = description;
		this.requirements = requirements;
		this.country = country;
		this.state = state;
		this.city = city;
		this.field = field;
		this.author = author;
	}

	public Post(String id, String role, JobType jobType, LocalDate createAt, String description, String requirements,
			String country, String state, String city, AuthorDTO author) {
		super();
		this.id = id;
		this.role = role;
		this.jobType = jobType;
		this.createAt = createAt;
		this.description = description;
		this.requirements = requirements;
		this.country = country;
		this.state = state;
		this.city = city;
		this.author = author;
	}
	
	public Post() {
		
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
