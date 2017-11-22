package edu.cornell.haulers.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author mohitchawla
 *
 */
@Document(collection="edu_cornell_haulers_drivers")
public class DriverEntity extends UserEntity {

	private Integer rating;

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

}
