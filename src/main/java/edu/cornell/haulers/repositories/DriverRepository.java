package edu.cornell.haulers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.data.repository.Repository;

import edu.cornell.haulers.entity.DriverEntity;

public interface DriverRepository extends MongoRepository<DriverEntity, Integer> {
	public DriverEntity findByEmail(String email);
}
