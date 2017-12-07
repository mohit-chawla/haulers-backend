package edu.cornell.haulers.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import edu.cornell.haulers.constants.DatabaseMappings;

@Document(collection = DatabaseMappings.DB_IMAGES)
public class ImageEntity extends UploadDetails {
	
	@Id
    private String email;
	public ImageEntity() {}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
