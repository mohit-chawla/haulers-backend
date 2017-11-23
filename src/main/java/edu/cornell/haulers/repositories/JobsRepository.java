package edu.cornell.haulers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.cornell.haulers.entity.JobEntity;

public interface JobsRepository extends MongoRepository<JobEntity,Integer> {
	
}
