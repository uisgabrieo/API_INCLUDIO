package com.projetoextensao.autismo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetoextensao.autismo.model.entities.FeedBack;
import com.projetoextensao.autismo.respository.FeedBackRepository;

@Service
public class FeedBackService {
	
	@Autowired
	private FeedBackRepository repository;

	public FeedBack saveFeedBack(FeedBack feedBack){
		
		FeedBack feedBackSave = repository.save(feedBack);
		
		return feedBackSave;
	}
	
}
