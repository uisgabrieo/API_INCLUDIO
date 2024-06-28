package com.projetoextensao.autismo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.dto.AuthorDTO;
import com.projetoextensao.autismo.dto.PostFormDTO;
import com.projetoextensao.autismo.dto.company.CompanyPerfilDTO;
import com.projetoextensao.autismo.model.entities.Post;
import com.projetoextensao.autismo.respository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private EmployerService employerService;
	
	public List<Post> findAll() {
		List<Post> posts = repository.findAll();
		Collections.reverse(posts);
		return posts;
	}
	
	public Post findById(String id) {
		Optional<Post> post = repository.findById(id);
		
		return post.get();
	}
	
	public void deleteById(String id) {
		repository.deleteById(id);
		
	}
	
	public List<Post> findByAuthor(String id) {
		List<Post> posts = repository.findByAuthorId(id);
		
		return posts;
	}
	
	public List<Post> filter(String field) {
		List<Post> posts = repository.findByFieldContainingIgnoreCase(field);
		return posts;
	}
	
	public List<Post> search(String text) {
		System.out.println(text);
		List<Post> posts = repository.findByRoleContainingIgnoreCase(text);
		System.out.println(posts);
		return posts;
	}
	
	public Post savePost(PostFormDTO postDTO, String email) {
		System.out.println(postDTO);
		System.out.println(email);
		String id = employerService.searchId(email);
		CompanyPerfilDTO company = companyService.findById(id);
		System.out.println(company);
		Post postCreated = createPost(postDTO, company);
		Post post = repository.save(postCreated);
		System.out.println(post);
		return post;
	}

	private Post createPost(PostFormDTO postDTO, CompanyPerfilDTO company) {
		Post post = new Post(
				null,
				postDTO.role(),
				postDTO.jobType(),
				postDTO.createAt(),
				postDTO.description(),
				postDTO.requirements(), 
				postDTO.country(),
				postDTO.state(),
				postDTO.city(),
				postDTO.field(),
				new AuthorDTO(
						company.employer().id(),
						company.logo(),
						company.employer().completeName(),
						company.email(),
						company.companyName())
				);
		return post;
	}
	
}
