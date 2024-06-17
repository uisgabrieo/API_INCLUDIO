package com.projetoextensao.autismo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetoextensao.autismo.model.entities.FeedBack;

@Repository
public interface FeedBackRepository extends MongoRepository<FeedBack, String>{
	
	
	
}
