package edu.cornell.haulers.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class HaulersExceptionHandlers {

	@ExceptionHandler(HaulersException.class)
	public ResponseEntity<ErrorMessage> invalidInput(HaulersException ex) {
		ErrorMessage response = ex.getErrorMessage();
		return ResponseEntity.badRequest().body(response);
	}
}
