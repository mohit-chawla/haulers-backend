package edu.cornell.haulers.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

//import edu.cornell.haulers.entity.AuthEntity;
import edu.cornell.haulers.entity.CustomerEntity;
import edu.cornell.haulers.entity.ImageEntity;
import edu.cornell.haulers.entity.UploadDetails;
import edu.cornell.haulers.exceptions.ErrorMessage;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.repositories.CustomerRepository;
import edu.cornell.haulers.repositories.ImageRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	private StorageService storageService;
	@Autowired
	private ImageRepository imageRepository;

	public CustomerEntity getCustomerDetailsByEmail(String email) throws HaulersException {
		CustomerEntity customer = customerRepository.findByEmail(email);
		if (customer != null) {
			return customer;
		} else {
			throw new HaulersException(new ErrorMessage("Customer Not Found!"));
		}
	}

	public void addCustomer(CustomerEntity customer, String password) throws HaulersException {
		ObjectId id = new ObjectId();
		customer.setId(id);
		try {
			authenticationService.addNewAuthorisedEntrity(customer.getEmail(), password);
		} catch (HaulersException e) {
			throw new HaulersException(new ErrorMessage("Customer cannot be added"));
		}
		CustomerEntity saved = customerRepository.save(customer);
		if (saved == null) {
			// delete authorised entity
			authenticationService.removeEntity(customer.getEmail());
			throw new HaulersException(new ErrorMessage("Customer cannot be added"));
		}
	}

	public List<CustomerEntity> getAllCustomers() throws HaulersException {
		List<CustomerEntity> customers = customerRepository.findAll();
		;
		if (customers == null) {
			throw new HaulersException(new ErrorMessage("No customers in database!"));
		}
		return customers;
	}

	public void updateCustomerLocation(String email, double[] newLocation) throws HaulersException {
		CustomerEntity customer = customerRepository.findByEmail(email);
		if (customer == null) {
			throw new HaulersException(new ErrorMessage("Requested customer not found!", email));
		}
		customer.setLocation(newLocation);
		customerRepository.save(customer);
	}

	public void updateCustomerImage(MultipartFile image, String email) throws HaulersException {
		CustomerEntity customer = customerRepository.findByEmail(email);
		if (customer != null) {
			UploadDetails uploadDetails = storageService.saveImageToS3(image, email);
			if (uploadDetails != null) { // save to DB
				ImageEntity imageEntity = new ImageEntity();
				imageEntity.setKey(uploadDetails.getKey());
				imageEntity.setUrl(uploadDetails.getUrl());
				imageEntity.setEmail(email);
				imageRepository.save(imageEntity);
			}
		} else {
			throw new HaulersException(new ErrorMessage("Customer Not Found!"));
		}
	}

	public String getImageForCustomer(String email) throws HaulersException {
		ImageEntity imageEntity = imageRepository.findByEmail(email);
		if (imageEntity != null) {
			return imageEntity.getUrl();
		} else {
			throw new HaulersException(new ErrorMessage("Customer Not Found!"));
		}
	}

}
