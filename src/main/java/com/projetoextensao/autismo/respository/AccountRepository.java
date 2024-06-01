package com.projetoextensao.autismo.respository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.projetoextensao.autismo.model.entities.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{

	Optional<Account> findByEmail(String email);
	
}
