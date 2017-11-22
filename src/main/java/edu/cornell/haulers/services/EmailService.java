package edu.cornell.haulers.services;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import edu.cornell.haulers.dto.EmailEntity;

/**
 * @author mohitchawla Service used to send email
 */
@Service
public class EmailService {

	@Autowired
	private JavaMailSender sender;

	// TODO: check for non-null args
	/**
	 * Sends an email, rest config in application.properties
	 * 
	 * @param subject
	 * @param receiverEmail
	 * @param body
	 * @throws Exception
	 */
	public void sendEmail(EmailEntity entity) throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setTo(entity.getReceiverEmail());
		helper.setText(entity.getBody());
		helper.setSubject(entity.getSubject());
		sender.send(message);
	}
}
