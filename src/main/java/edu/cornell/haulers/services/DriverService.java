package edu.cornell.haulers.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.cornell.haulers.entity.DriverEntity;
import edu.cornell.haulers.entity.ImageEntity;
import edu.cornell.haulers.entity.UploadDetails;
import edu.cornell.haulers.exceptions.ErrorMessage;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.repositories.DriverRepository;
import edu.cornell.haulers.repositories.ImageRepository;

@Service
public class DriverService {

	@Autowired
	DriverRepository driverRepository;

	@Autowired
	AuthenticationService authenticationService;
	@Autowired
	private StorageService storageService;
	@Autowired
	private ImageRepository imageRepository;

	public DriverEntity getDriverDetailsByEmail(String email) throws HaulersException {
		DriverEntity driver = driverRepository.findByEmail(email);
		if (driver != null) {
			return driver;
		} else {
			throw new HaulersException(new ErrorMessage("Driver Not Found!"));
		}
	}

	public void addDriver(DriverEntity driver, String password) throws HaulersException {

		try {
			authenticationService.addNewAuthorisedEntrity(driver.getEmail(), password);
		} catch (HaulersException e) {
			// TODO: log here
			throw new HaulersException(new ErrorMessage("Driver cannot be added"));
		}
		double[] location = driver.getLocation();
		System.err.println(location[0]);
		System.err.println(location[1]);
		ObjectId id = new ObjectId();
		driver.setId(id);
		driver.setAvailable(true);
		DriverEntity saved = driverRepository.save(driver);
		if (saved == null) {
			// TODO: log here
			// driver was not saved, remove authentication entity
			authenticationService.removeEntity(driver.getEmail());
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
		DriverEntity driver = driverRepository.findByEmail(email);
		;
		if (driver == null) {
			throw new HaulersException(new ErrorMessage("No customers in database!"));
		}
		driver.setLocation(newLocation);
		driverRepository.save(driver);
	}

	public void updateDriverImage(MultipartFile image, String email) throws HaulersException {
		DriverEntity driver = driverRepository.findByEmail(email);
		if(driver!=null) {
			UploadDetails uploadDetails = storageService.saveImageToS3(image, email);
			if (uploadDetails != null) { // save to DB
				ImageEntity imageEntity = new ImageEntity();
				imageEntity.setKey(uploadDetails.getKey());
				imageEntity.setUrl(uploadDetails.getUrl());
				imageEntity.setEmail(email);
				imageRepository.save(imageEntity);
			}
		}else {
			throw new HaulersException(new ErrorMessage("Driver Not Found!"));
		}
		
	}
	
	public String getImageForDriver(String email) throws HaulersException {
		ImageEntity imageEntity = imageRepository.findByEmail(email);
		if(imageEntity!=null) {
			return imageEntity.getUrl(); 
		}else {
			throw new HaulersException(new ErrorMessage("Driver Not Found!"));
		}
	}

}
