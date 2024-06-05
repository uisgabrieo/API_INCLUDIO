package com.projetoextensao.autismo.model.entities;

import java.util.ArrayList;
import java.util.List;

import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.Document;

import com.projetoextensao.autismo.model.entities.enums.JobType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
	
	private String role;
	private JobType jobType;
	private Instant createAt;
	private String description;
	private String requirements;
	private List<String> field = new ArrayList<>();
	
}
