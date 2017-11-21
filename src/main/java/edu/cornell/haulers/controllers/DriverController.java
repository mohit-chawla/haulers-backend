package edu.cornell.haulers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cornell.haulers.constants.HttpMappings;
import edu.cornell.haulers.entity.DriverEntity;
import edu.cornell.haulers.services.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@RequestMapping(value=HttpMappings.DRIVER,method=RequestMethod.GET)
	public ResponseEntity<DriverEntity> driverDetailsController(@RequestParam(name="email",required=true)String email){
		return ResponseEntity.ok().body(driverService.getDriverDetailsByEmail(email)) ;
	}
	
}
