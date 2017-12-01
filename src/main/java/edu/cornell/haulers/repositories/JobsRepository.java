package edu.cornell.haulers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.cornell.haulers.entity.JobEntity;
import java.lang.String;
import java.util.List;

public interface JobsRepository extends MongoRepository<JobEntity, Integer> {
	List<JobEntity> findByCustomerEmail(String customerEmail);

	List<JobEntity> findByDriverEmail(String driveremail);
}
