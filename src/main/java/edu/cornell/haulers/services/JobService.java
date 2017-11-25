package edu.cornell.haulers.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cornell.haulers.entity.DriverEntity;
import edu.cornell.haulers.entity.JobEntity;
import edu.cornell.haulers.entity.JobRequest;
import edu.cornell.haulers.exceptions.ErrorMessage;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.repositories.DriverRepository;
import edu.cornell.haulers.repositories.JobsRepository;

@Service
public class JobService {

	@Autowired
	DriverRepository driverRepository;
	
	@Autowired
	JobsRepository jobsRepository;
	
	public DriverEntity addNewJob(String userEmail, JobRequest jobRequest) throws HaulersException {
		//Find a driver
		//match them
		//TODO: what if no driver can be found
		// return the match
		List<DriverEntity> availableDrivers = driverRepository.findByAvailableTrue();
		if(availableDrivers.isEmpty()){
			throw new HaulersException(new ErrorMessage("No Driver available!"));
		}else{
			//create new job entitiy;
			DriverEntity chosenDriver = availableDrivers.get(0);
			JobEntity entity = new JobEntity();
			entity.setCapacity(jobRequest.getCapacity());
			entity.setDescription(jobRequest.getDescription());
			entity.setPrice(jobRequest.getPrice());
			entity.setStart(jobRequest.getStart());
			entity.setEnd(jobRequest.getEnd());
			entity.setId(new ObjectId());
			entity.setUserEmail(userEmail);
			entity.setDriverEmail(chosenDriver.getEmail()); //TODO: replace with better matching
			jobsRepository.save(entity);
			chosenDriver.setAvailable(false);
			driverRepository.save(chosenDriver);
			return chosenDriver;
		}
	}
	
	public List<JobEntity> getAllJobs() throws HaulersException{
		List<JobEntity> jobs = jobsRepository.findAll();
		if(jobs == null){
			throw new HaulersException(new ErrorMessage("No job matching exist in databse"));
		}
		return jobs;
	}

	
}