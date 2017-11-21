package edu.cornell.haulers.services;

import org.springframework.stereotype.Service;

@Service
public class TestService {
	public String testMethod(){
		return "This is testMethod in TestService";
	}

	public String sampleJson() {
		return "{\"this\":\"testJson\"}";
	}
}
