package edu.cornell.haulers.entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "edu_cornell_haulers_auth")
public class AuthEntity {

	@Indexed(unique = true)
	String username;

	String password;

	String authority;

	public AuthEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
