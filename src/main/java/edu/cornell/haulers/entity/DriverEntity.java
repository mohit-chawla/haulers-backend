package edu.cornell.haulers.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import edu.cornell.haulers.constants.DatabaseMappings;

/**
 * @author mohitchawla
 *
 */
@Document(collection = DatabaseMappings.DB_DRIVERS)
public class DriverEntity extends UserEntity {

	private Integer rating;

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
