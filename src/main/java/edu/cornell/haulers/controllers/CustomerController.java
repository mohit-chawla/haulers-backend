package edu.cornell.haulers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.cornell.haulers.constants.HttpMappings;
import edu.cornell.haulers.entity.CustomerEntity;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.exceptions.HaulersExceptionHandlers;
import edu.cornell.haulers.services.CustomerService;

/**
 * @author mohitchawla. APIs related to customer
 */
@RestController
public class CustomerController extends HaulersExceptionHandlers {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = HttpMappings.CUSTOMER, method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CustomerEntity> getCustomerController(
			@RequestParam(name = "email", required = true) String email) throws HaulersException {
		return ResponseEntity.ok().body(customerService.getCustomerDetailsByEmail(email));
	}

	@RequestMapping(value = HttpMappings.CUSTOMER + "/all", method = RequestMethod.GET)
	public ResponseEntity<List<CustomerEntity>> getAllCustomersController() throws HaulersException {
		return ResponseEntity.ok().body(customerService.getAllCustomers());
	}

	@RequestMapping(value = HttpMappings.CUSTOMER_SIGNUP, method = RequestMethod.POST)
	public ResponseEntity<CustomerEntity> customerSignUpController(
			@RequestBody(required = true) CustomerEntity customer, String password) throws HaulersException {
		customerService.addCustomer(customer, password);
		return ResponseEntity.status(HttpStatus.CREATED).body(null);
	}

	@RequestMapping(value = HttpMappings.CUSTOMER_UPDATE_LOC, method = RequestMethod.POST)
	public ResponseEntity<CustomerEntity> updateCustomerLocationController(@RequestParam(required = true) String email,
			@RequestParam(required = true) double[] newLocation) throws HaulersException {
		customerService.updateCustomerLocation(email, newLocation);
		return ResponseEntity.ok().body(null);
	}

	@RequestMapping(value = HttpMappings.CUSTOMER + "/images", method = RequestMethod.POST)
	public ResponseEntity<CustomerEntity> updateCustomerImage(
			@RequestParam(value = "image", required = true) MultipartFile image,
			@RequestParam(value = "email", required = true) String email) throws HaulersException {
		customerService.updateCustomerImage(image, email);
		return ResponseEntity.ok().body(null);
	}

	@RequestMapping(value = HttpMappings.CUSTOMER + "/images", method = RequestMethod.GET)
	public ResponseEntity<String> getImageURL(@RequestParam(value = "email", required = true) String email)
			throws HaulersException {
		String imageUrl = customerService.getImageForCustomer(email);
		return ResponseEntity.ok().body(imageUrl);
	}

}
