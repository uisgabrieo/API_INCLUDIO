package com.projetoextensao.autismo.respository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetoextensao.autismo.model.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	List<Post> findByAuthorId(String id);
	
	List<Post> findByFieldContainingIgnoreCase(String field);
	
	List<Post> findByRoleContainingIgnoreCase(String text);
	
}
