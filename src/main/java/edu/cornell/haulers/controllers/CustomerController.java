package edu.cornell.haulers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cornell.haulers.constants.HttpMappings;
import edu.cornell.haulers.entity.CustomerEntity;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.exceptions.HaulersExceptionHandlers;
import edu.cornell.haulers.services.CustomerService;

@RestController
public class CustomerController extends HaulersExceptionHandlers {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = HttpMappings.CUSTOMER, method = RequestMethod.GET)
	public ResponseEntity<CustomerEntity> getCustomerController(
			@RequestParam(name = "email", required = true) String email) throws HaulersException {
		return ResponseEntity.ok().body(customerService.getCustomerDetailsByEmail(email));
	}

	@RequestMapping(value = HttpMappings.CUSTOMER, method = RequestMethod.POST)
	public ResponseEntity<CustomerEntity> addCustomerController(@RequestBody(required = true) CustomerEntity customer)
			throws HaulersException {
		customerService.addCustomer(customer);
		return ResponseEntity.ok().body(null);
	}
}
