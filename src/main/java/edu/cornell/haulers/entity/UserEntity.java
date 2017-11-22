package edu.cornell.haulers.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class UserEntity {
	
	@Id
	private ObjectId id;
	
	private String email;
	
	private String firstName;
	
	private String lastName;
	
	private String phone;

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}