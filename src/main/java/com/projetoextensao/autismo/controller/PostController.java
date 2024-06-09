package com.projetoextensao.autismo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.model.entities.Post;
import com.projetoextensao.autismo.service.PostService;

@Controller
@RestController
@RequestMapping("/api/account/employer/post")
public class PostController {
	
	@Autowired
	private PostService service;

	@GetMapping
	public ResponseEntity<List<Post>> allPosts() {
		List<Post> posts = service.findAll();
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	@GetMapping(value = "/filter")
	public ResponseEntity<List<Post>> filter(@RequestParam(value = "caixaDeFiltro", defaultValue = "") String field) {
		System.out.println(field);
		List<Post> posts = service.filter(field);
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<List<Post>> search(@RequestParam(value = "caixaDeBusca", defaultValue = "") String text) {
		List<Post> posts = service.search(text);
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
}
