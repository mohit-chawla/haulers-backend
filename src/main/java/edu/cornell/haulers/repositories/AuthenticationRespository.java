package edu.cornell.haulers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.cornell.haulers.entity.AuthEntity;

public interface AuthenticationRespository extends MongoRepository<AuthEntity, String> {

	public AuthEntity findByUsername(String username);
	public AuthEntity findByUsernameAndPassword(String user, String pass);
}
