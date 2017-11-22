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
	
	

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

	@Override
	public String toString() {
		return "ErrorMessage [message=" + message + ", details=" + details + "]";
	}
	
}
