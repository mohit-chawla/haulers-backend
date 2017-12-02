package edu.cornell.haulers.repositories;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;

import edu.cornell.haulers.entity.DriverEntity;

public interface DriverRepository extends MongoRepository<DriverEntity, Integer> {
	public DriverEntity findByEmail(String email);
	
	public List<DriverEntity> findByAvailableTrue();
	public List<DriverEntity>  findByLocationNearAndAvailableTrue(Point p, Distance d);
}
