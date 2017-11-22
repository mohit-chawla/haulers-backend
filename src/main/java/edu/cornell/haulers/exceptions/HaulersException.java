package edu.cornell.haulers.exceptions;

/**
 * @author mohitchawla
 *
 */
public class HaulersException extends Exception{
	ErrorMessage message;

	public HaulersException(ErrorMessage message) {
		super();
		this.message = message;
	}

	
	
}
