package edu.cornell.haulers.dto;

import java.util.Date;

import edu.cornell.haulers.entity.LocationEntity;

public class JobRequestDto {

	Integer capacity;

	float price;

	String description;

	Date start;

	Date end;

	LocationEntity startLocation;

	LocationEntity endLocation;

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public LocationEntity getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(LocationEntity startLocation) {
		this.startLocation = startLocation;
	}

	public LocationEntity getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(LocationEntity endLocation) {
		this.endLocation = endLocation;
	}

}
