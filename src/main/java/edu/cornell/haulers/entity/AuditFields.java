package edu.cornell.haulers.entity;

import java.util.Date;

/**
 * @author mohitchawla
 *	Field used for audit 
 */
public class AuditFields {
	
	private Date created;
	
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
