package edu.cornell.haulers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cornell.haulers.constants.HttpMappings;
import edu.cornell.haulers.entity.DriverEntity;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.services.DriverService;

@RestController
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@RequestMapping(value=HttpMappings.DRIVER,method=RequestMethod.GET)
	public ResponseEntity<DriverEntity> getDriverController(@RequestParam(name="email",required=true)String email) throws HaulersException{
		return ResponseEntity.ok().body(driverService.getDriverDetailsByEmail(email)) ;
	}
	
	@RequestMapping(value=HttpMappings.DRIVER,method=RequestMethod.POST)
	public ResponseEntity<DriverEntity> addDriverController(@RequestBody(required=true)DriverEntity driver) throws HaulersException{
		driverService.addDriver(driver);
		return ResponseEntity.ok().body(null) ;
	}
}
	
