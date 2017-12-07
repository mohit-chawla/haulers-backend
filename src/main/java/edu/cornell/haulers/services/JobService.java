package edu.cornell.haulers.services;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metric;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import edu.cornell.haulers.constants.JobStatus;
import edu.cornell.haulers.dto.JobRequestDto;
import edu.cornell.haulers.dto.JobResponseDto;
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

	public DriverEntity addNewJob(String customerEmail, JobRequestDto jobRequestDto) throws HaulersException {
		// Find a driver
		// match them
		// TODO: what if no driver can be found
		// return the match
		// TODO:
		List<DriverEntity> availableDrivers = driverRepository
				.findByLocationNearAndAvailableTrue(
						new Point(jobRequestDto.getStartLocation().getLatitude(),
								jobRequestDto.getStartLocation().getLatitude()),
						new Distance(10000, Metrics.KILOMETERS));
		for (DriverEntity driver : availableDrivers) {
			System.out.println(driver.toString());
		}
		if (availableDrivers.isEmpty()) {
			throw new HaulersException(new ErrorMessage("No Driver available!"));
		} else {
			// create new job entitiy;
			DriverEntity chosenDriver = availableDrivers.get(0);
			JobEntity entity = new JobEntity();
			entity.setCapacity(jobRequestDto.getCapacity());
			entity.setDescription(jobRequestDto.getDescription());
			entity.setPrice(jobRequestDto.getPrice());
			entity.setStart(jobRequestDto.getStart());
			entity.setEnd(jobRequestDto.getEnd());
			entity.setStatus(JobStatus.REQUESTED);
			double[] startLocation = { jobRequestDto.getStartLocation().getLatitude(),
					jobRequestDto.getStartLocation().getLongitude() };
			double[] endLocation = { jobRequestDto.getEndLocation().getLatitude(),
					jobRequestDto.getEndLocation().getLongitude() };
			entity.setStartLocation(startLocation);
			entity.setEndLocation(endLocation);
			entity.setId(new ObjectId().toString());
			entity.setCustomerEmail(customerEmail);
			entity.setDriverEmail(chosenDriver.getEmail()); // TODO: replace
															// with better
															// matching
			jobsRepository.save(entity);
			chosenDriver.setAvailable(false);
			driverRepository.save(chosenDriver);
			return chosenDriver;
		}
	}

	public List<JobEntity> getAllJobs() throws HaulersException {
		List<JobEntity> jobs = jobsRepository.findAll();
		if (jobs == null) {
			throw new HaulersException(new ErrorMessage("No job matching exist in databse"));
		}
		return jobs;
	}

	public List<JobEntity> getCustomerJobs(String customerEmail, String typeFilter) throws HaulersException {
		List<JobEntity> jobs = jobsRepository.findByCustomerEmail(customerEmail);
		if (jobs == null) {
			throw new HaulersException(new ErrorMessage("No jobs for this customer"));
		} else {
			return jobs;
		}

	}

	public List<JobEntity> getDriverJobs(String driverEmail, String typeFilter) throws HaulersException {
		List<JobEntity> jobs = jobsRepository.findByDriverEmail(driverEmail);
		if (jobs == null) {
			throw new HaulersException(new ErrorMessage("No jobs for this driver"));
		} else {
			return jobs;
		}

	}

	public void respondToJob(JobResponseDto jobResponseDto) throws HaulersException {
		JobEntity job = jobsRepository.findOne(jobResponseDto.getJobId());
		System.err.println("Searching for job with id:"+jobResponseDto.getJobId());
		if (job == null) {
			throw new HaulersException(new ErrorMessage("No job with given job id"));
		} else {
			job.setStatus(JobStatus.valueOf(jobResponseDto.getResponse()));
			JobEntity saved = jobsRepository.save(job);
			if(saved==null){
				throw new HaulersException(new ErrorMessage("Error updating job status"));
			}
		}
	}

}
