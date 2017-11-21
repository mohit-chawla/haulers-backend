package edu.cornell.haulers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.cornell.haulers.services.TestService;

@RestController
public class testContoller {
	
	@Autowired
	TestService testService;

	@RequestMapping("/test")
	public String testContoller(){
		return "Your spring configuration is fine!";
	}
	
	@GetMapping("/testservice")
	public String testServiceContoller(){
		return testService.testMethod();
	}
	
	@RequestMapping(value="/testservice/json",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String testServiceJson(){
		return testService.sampleJson();
	}
	
}
