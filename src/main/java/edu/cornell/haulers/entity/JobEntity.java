package edu.cornell.haulers.entity;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author mohitchawla
 *
 */
@Document(collection = "edu_cornell_haulers_jobs")
public class JobEntity extends JobRequest {

	@Indexed(unique = false)
	String customerEmail;

	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	double[] startLocation;

	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
	double[] endLocation;

	public double[] getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(double[] startLocation) {
		this.startLocation = startLocation;
	}

	public double[] getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(double[] endLocation) {
		this.endLocation = endLocation;
	}

	String status;

	@Indexed(unique = false)
	String driverEmail;

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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
