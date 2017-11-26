package edu.cornell.haulers.util;

import edu.cornell.haulers.entity.CustomerEntity;

/**
 * @author mohitchawla
 *	Used to generate test data for unit tests
 */
public class TestDataGenerator {
	
	public CustomerEntity getValidCustomer(){
		CustomerEntity customer = new CustomerEntity();
		customer.setEmail("k@k.com");
		customer.setFirstName("k");
		customer.setLastName("last anme");
		customer.setPhone("929");
		return customer;
	}
	
}
