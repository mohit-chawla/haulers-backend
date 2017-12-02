package edu.cornell.haulers.entity;

import java.util.Arrays;

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

	@Override
	public String toString() {
		return "DriverEntity [available=" + available + ", rating=" + rating + ", getId()=" + getId() + ", getEmail()="
				+ getEmail() + ", getFirstName()=" + getFirstName() + ", getLastName()=" + getLastName()
				+ ", getPhone()=" + getPhone() + ", getLocation()=" + Arrays.toString(getLocation()) + "]";
	}

}
