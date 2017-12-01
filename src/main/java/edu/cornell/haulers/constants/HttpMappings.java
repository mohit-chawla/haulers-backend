package edu.cornell.haulers.constants;

/**
 * @author mohitchawla
 * Http Mappings
 */
public class HttpMappings {
	
	public static final String DRIVER = "/driver";
	public static final String DRIVER_ID = DRIVER+"/{id}";
	
	public static final String DRIVER_JOBS = DRIVER+"/jobs";
	public static final String DRIVER_JOBS_OPEN = DRIVER_JOBS+"/open";
	public static final String DRIVER_JOBS_CLOSED = DRIVER_JOBS+"/closed";
	
	public static final String DRIVER_UPDATE = DRIVER+"/update";
	public static final String DRIVER_UPDATE_LOC = DRIVER_UPDATE+"/loc";
	
	public static final String CUSTOMER = "/customer";
	public static final String CUSTOMER_ID = CUSTOMER+"/{id}";
	
	public static final String CUSTOMER_JOBS = CUSTOMER+"/jobs";
	public static final String CUSTOMER_JOBS_OPEN = CUSTOMER_JOBS+"/open";
	public static final String CUSTOMER_JOBS_CLOSED = CUSTOMER_JOBS+"/closed";
	
	public static final String CUSTOMER_UPDATE = CUSTOMER+"/update";
	public static final String CUSTOMER_UPDATE_LOC = CUSTOMER_UPDATE+"/loc";
	
	public static final String JOB = "/job";
	public static final String JOB_ID = JOB+"/{id}";
	
	public static final String AUDIT = "/audit";
	public static final String AUDIT_DB = AUDIT+"/db";
	public static final String AUDIT_DB_STATS = AUDIT_DB+"/stats";
	
}
