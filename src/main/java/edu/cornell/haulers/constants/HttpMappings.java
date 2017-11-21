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
	
	public static final String USER = "/user";
	public static final String USER_ID = USER+"/{id}";
	public static final String USER_JOBS = USER+"/jobs";
	public static final String USER_JOBS_OPEN = USER_JOBS+"/open";
	public static final String USER_JOBS_CLOSED = USER_JOBS+"/closed";
	
	public static final String JOB = "/job";
	public static final String JOB_ID = JOB+"/{id}";
	
	public static final String AUDIT = "/audit";
	public static final String AUDIT_DB = AUDIT+"/db";
	public static final String AUDIT_DB_STATS = AUDIT_DB+"/stats";
	
}
