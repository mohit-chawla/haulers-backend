package edu.cornell.haulers.exceptions;

/**
 * @author mohitchawla
 *
 */
public class ErrorMessage {
	
	String message;
	
	String details;

	public ErrorMessage(String message) {
		super();
		this.message = message;
	}

	public ErrorMessage(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
	
}
