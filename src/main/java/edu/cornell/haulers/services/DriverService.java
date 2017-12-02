package edu.cornell.haulers.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.haulers.entity.DriverEntity;
import edu.cornell.haulers.exceptions.ErrorMessage;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.repositories.DriverRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository driverRepository;

	public DriverEntity getDriverDetailsByEmail(String email) throws HaulersException {
		DriverEntity driver = driverRepository.findByEmail(email);
		if (driver != null) {
			return driver;
		} else {
			throw new HaulersException(new ErrorMessage("Driver Not Found!"));
		}
	}

	public void addDriver(DriverEntity driver) throws HaulersException {
		try {
			double[] location  = driver.getLocation();
			System.err.println(location[0]);
			System.err.println(location[1]);
			ObjectId id = new ObjectId();
			driver.setId(id);
			driverRepository.save(driver);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HaulersException(new ErrorMessage("Driver cannot be added"));
		}
	}

	public List<DriverEntity> getAllDrivers() throws HaulersException {
		List<DriverEntity> drivers = driverRepository.findAll();
		if (drivers == null) {
			throw new HaulersException(new ErrorMessage("No drivers exists in databse"));
		}
		return drivers;
	}
	
	public void updateCustomerLocation(String email, double[] newLocation) throws HaulersException {
		DriverEntity driver = driverRepository.findByEmail(email);;
		if(driver == null){
			throw new HaulersException(new ErrorMessage("No customers in database!"));
		}
		driver.setLocation(newLocation);
		driverRepository.save(driver);
	}

}
