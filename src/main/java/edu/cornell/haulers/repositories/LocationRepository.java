package edu.cornell.haulers.repositories;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;



import edu.cornell.haulers.entity.LocationEntity;

public interface LocationRepository extends MongoRepository<LocationEntity, String> {
		
		List<LocationEntity>  findByLocationNear(Point p, Distance d);
		
	  // List<LocationEntity> findBySubjectAndLocationNear(String sid, Point p, Distance d);

	}

