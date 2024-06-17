package com.projetoextensao.autismo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.model.entities.Post;
import com.projetoextensao.autismo.respository.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;
	
	public List<Post> findAll() {
		List<Post> posts = repository.findAll();
		return posts;
	}
	
	public Post findById(String id) {
		
		Optional<Post> post = repository.findById(id);
		
		return post.get();
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
	
}
