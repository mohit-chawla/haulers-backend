package edu.cornell.haulers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.cornell.haulers.entity.DriverEntity;
import edu.cornell.haulers.entity.JobEntity;
import edu.cornell.haulers.entity.JobRequest;
import edu.cornell.haulers.exceptions.HaulersException;
import edu.cornell.haulers.exceptions.HaulersExceptionHandlers;
import edu.cornell.haulers.services.JobService;

/**
 * @author mohitchawla
 *
 */
@RestController
public class JobController extends HaulersExceptionHandlers {

	@Autowired
	JobService jobService;

	/**
	 * Request to add a new job in the system
	 * 
	 * @param userEmail
	 * @param jobRequest
	 * @return
	 * @throws HaulersException
	 */
	@RequestMapping(value = "/job", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DriverEntity> postNewJobController(@RequestParam(required = true) String userEmail,
			@RequestBody(required = true) JobRequest jobRequest) throws HaulersException {
		DriverEntity driver = jobService.addNewJob(userEmail, jobRequest);
		return ResponseEntity.ok().body(driver);
	}

	/**
	 * Get all jobs
	 * 
	 * @return
	 * @throws HaulersException
	 */
	@RequestMapping(value = "/job/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<JobEntity>> getAllJobsController() throws HaulersException {
		return ResponseEntity.ok().body(jobService.getAllJobs());
	}

	/**
	 * Get jobs for a customer
	 * 
	 * @param customerEmail
	 * @param typeFilter
	 * @return
	 * @throws HaulersException
	 */
	@RequestMapping(value = "/job/customer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<JobEntity>> getCustomerJobsController(
			@RequestParam(required = true) String customerEmail, @RequestParam(required = false) String typeFilter)
			throws HaulersException {
		return ResponseEntity.ok().body(jobService.getCustomerJobs(customerEmail, typeFilter));
	}

	/**
	 * Get jobs for a driver
	 * 
	 * @param driverEmail
	 * @param typeFilter
	 * @return
	 * @throws HaulersException
	 */
	@RequestMapping(value = "/job/driver", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<JobEntity>> getDriverJobsController(@RequestParam(required = true) String driverEmail,
			@RequestParam(required = false) String typeFilter) throws HaulersException {
		return ResponseEntity.ok().body(jobService.getDriverJobs(driverEmail, typeFilter));
	}

}
