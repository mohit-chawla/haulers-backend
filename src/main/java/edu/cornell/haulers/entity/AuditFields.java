package edu.cornell.haulers.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author mohitchawla Field used for audit
 */
public class AuditFields {

	@JsonIgnore
	private Date created;

	@JsonIgnore
	private Date lastUpdated;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
