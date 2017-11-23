package edu.cornell.haulers.services;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.haulers.entity.CustomerEntity;
import edu.cornell.haulers.exceptions.ErrorMessage;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public CustomerEntity getCustomerDetailsByEmail(String email) throws HaulersException {
		CustomerEntity customer = customerRepository.findByEmail(email);
		if (customer != null) {
			return customer;
		} else {
			throw new HaulersException(new ErrorMessage("Customer Not Found!"));
		}
	}

	public void addCustomer(CustomerEntity customer) throws HaulersException {
		try {
			ObjectId id = new ObjectId();
			customer.setId(id);
			customerRepository.insert(customer);
		} catch (Exception e) {
			throw new HaulersException(new ErrorMessage("Customer cannot be added"));
		}
	}

}
