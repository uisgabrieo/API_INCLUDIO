package com.projetoextensao.autismo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
