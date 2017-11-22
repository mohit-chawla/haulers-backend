package edu.cornell.haulers.exceptions;

/**
 * @author mohitchawla
 *
 */
public class HaulersException extends Exception {
	ErrorMessage errorMessage;

	public HaulersException(ErrorMessage errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}

}
