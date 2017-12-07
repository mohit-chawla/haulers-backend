package edu.cornell.haulers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.cornell.haulers.entity.ImageEntity;

public interface ImageRepository extends MongoRepository<ImageEntity, String>{
	public ImageEntity findByEmail(String email);
}
