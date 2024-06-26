package com.projetoextensao.autismo.respository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.projetoextensao.autismo.model.entities.Account;

@Repository
public interface AccountRepository extends MongoRepository<Account, String>{

	UserDetails findByEmail(String email);

}
