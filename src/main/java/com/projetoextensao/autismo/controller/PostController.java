package com.projetoextensao.autismo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.dto.PostFormDTO;
import com.projetoextensao.autismo.model.entities.Post;
import com.projetoextensao.autismo.model.entities.enums.JobType;
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
	
	@GetMapping(value = "/all/{id}")
	public ResponseEntity<List<Post>> allPostOneAuthor(@PathVariable String id) {
		List<Post> posts = service.findByAuthor(id);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping(value = "{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = service.findById(id);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable String id) {
		System.out.println("ID: "  + id);
	    try {
	        service.deleteById(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping(value = "/filter")
	public ResponseEntity<List<Post>> filter(@RequestParam(value = "caixaDeFiltro", defaultValue = "") String field) {
		System.out.println(field);
		List<Post> posts = service.filter(field);
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@GetMapping(value = "/search")
	public ResponseEntity<List<Post>> search(@RequestParam(value = "caixaDeBusca", defaultValue = "") String text) {
		System.out.println(text);
		List<Post> posts = service.search(text);
		
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
	
	@PostMapping(value = "/create")
	public ResponseEntity<Post> savePost(
			@RequestParam("email") String email,
			@RequestParam("role") String role,
			@RequestParam("field") List<String> field,
			@RequestParam("jobType") JobType jobType,
			@RequestParam("country") String country,
			@RequestParam("state") String state,
			@RequestParam("city") String city,
			@RequestParam("requirements") String requirements,
			@RequestParam("description") String description
			) {
		
		PostFormDTO postDTO = new PostFormDTO(role, jobType, LocalDate.now(), country, state, city, field, requirements, description);
		System.out.println(postDTO);
		Post post = service.savePost(postDTO, email);
		return new ResponseEntity<>(post, HttpStatus.OK);
	}
}
