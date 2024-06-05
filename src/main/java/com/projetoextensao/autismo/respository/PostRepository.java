package com.projetoextensao.autismo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetoextensao.autismo.model.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}
