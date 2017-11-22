package edu.cornell.haulers.dto;

/**
 * @author mohitchawla
 * 
 * Entity for Email
 */
public class EmailEntity {
	private String subject;
	private String receiverEmail;
	private String body;
	
	public EmailEntity(String subject, String receiverEmail, String body) {
		super();
		this.subject = subject;
		this.receiverEmail = receiverEmail;
		this.body = body;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getReceiverEmail() {
		return receiverEmail;
	}

	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	

}
