package edu.cornell.haulers.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.cornell.haulers.dto.EmailEntity;
import edu.cornell.haulers.services.EmailService;

public class HaulersExceptionHandlers {
	
	@Autowired
	EmailService emailService;

	@Value("${developer.alerts}")
	private boolean developerAlerts;
	
	@ExceptionHandler(HaulersException.class)
	public ResponseEntity<ErrorMessage> invalidInput(HaulersException ex) {
		if(developerAlerts == true){
			EmailEntity email = new EmailEntity("Exception in Haulers", "mohitchawla.ism@gmail.com", ex.getErrorMessage().getMessage());
			try {
				emailService.sendEmail(email);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		ErrorMessage response = ex.getErrorMessage();
		return ResponseEntity.badRequest().body(response);
	}
}
