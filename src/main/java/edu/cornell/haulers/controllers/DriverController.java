package edu.cornell.haulers.controllers;

import java.util.List;

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
import edu.cornell.haulers.exceptions.HaulersExceptionHandlers;
import edu.cornell.haulers.services.DriverService;

/**
 * @author mohitchawla APIs related to driver
 */
@RestController
public class DriverController extends HaulersExceptionHandlers {

	@Autowired
	DriverService driverService;

	@RequestMapping(value = HttpMappings.DRIVER, method = RequestMethod.GET)
	public ResponseEntity<DriverEntity> getDriverController(@RequestParam(name = "email", required = true) String email)
			throws HaulersException {
		return ResponseEntity.ok().body(driverService.getDriverDetailsByEmail(email));
	}

	@RequestMapping(value = HttpMappings.DRIVER + "/all", method = RequestMethod.GET)
	public ResponseEntity<List<DriverEntity>> getAllDriversController() throws HaulersException {
		return ResponseEntity.ok().body(driverService.getAllDrivers());
	}

	@RequestMapping(value = HttpMappings.DRIVER_SIGNUP, method = RequestMethod.POST)
	public ResponseEntity<DriverEntity> driverSignupController(@RequestBody(required = true) DriverEntity driver,
			@RequestParam(required = true) String password) throws HaulersException {
		driverService.addDriver(driver, password);
		return ResponseEntity.ok().body(null);
	}

	@RequestMapping(value = HttpMappings.DRIVER_UPDATE_LOC, method = RequestMethod.POST)
	public ResponseEntity<DriverEntity> updateDriverLocationController(@RequestParam(required = true) String email,
			@RequestParam(required = true) double[] newLocation) throws HaulersException {
		driverService.updateCustomerLocation(email, newLocation);
		return ResponseEntity.ok().body(null);
	}

}
