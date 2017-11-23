package edu.cornell.haulers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.cornell.haulers.entity.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity, Integer> {
	public CustomerEntity findByEmail(String email);
}
