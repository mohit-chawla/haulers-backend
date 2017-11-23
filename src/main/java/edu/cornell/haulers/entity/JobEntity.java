package edu.cornell.haulers.entity;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author mohitchawla
 *
 */
@Document(collection="edu_cornell_haulers_jobs")
public class JobEntity extends JobRequest {
	String userEmail;
	
	String status;
	
	String driverEmail;

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDriverEmail() {
		return driverEmail;
	}

	public void setDriverEmail(String driverEmail) {
		this.driverEmail = driverEmail;
	}
	
}
