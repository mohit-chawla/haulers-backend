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
public class JobController extends HaulersExceptionHandlers{
	
	@Autowired
	JobService jobService;
	
	@RequestMapping(value="/job",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<DriverEntity> postNewJobController(@RequestParam(required=true)String userEmail,@RequestBody(required=true) JobRequest jobRequest) throws HaulersException{
		DriverEntity driver = jobService.addNewJob(userEmail,jobRequest);
		return ResponseEntity.ok().body(driver);
	}
	
//	@RequestMapping(value="/job",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	public ResponseEntity<List<JobEntity>> getJobsController(@RequestParam(required=true)String userEmail) throws HaulersException{
//		
//	}
}
