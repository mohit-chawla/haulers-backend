package edu.cornell.haulers.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.cornell.haulers.constants.DatabaseMappings;

/**
 * @author mohitchawla
 *
 */
@Document(collection = DatabaseMappings.DB_DRIVERS)
public class DriverEntity extends UserEntity {
	
	//TODO: replace with more realistic scheduling
	private boolean available;
	
	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	private Integer rating;

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
