package com.projetoextensao.autismo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetoextensao.autismo.model.entities.FeedBack;
import com.projetoextensao.autismo.service.FeedBackService;

@Controller
@RestController
@RequestMapping("/api/account/feedback")
public class FeedBackController {
	
	@Autowired
	private FeedBackService service;

	@PostMapping
	public ResponseEntity<FeedBack> saveFeedBack(@RequestBody FeedBack feedBack) {
		
		System.out.println("feedBack: " + feedBack.toString());
		FeedBack save = service.saveFeedBack(feedBack);
		
		return new ResponseEntity<>(save, HttpStatus.OK);
	}
	
}
