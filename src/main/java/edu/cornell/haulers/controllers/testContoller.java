package edu.cornell.haulers.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.cornell.haulers.entity.LocationEntity;
import edu.cornell.haulers.entity.LocationEntry;
//import edu.cornell.haulers.repositories.LocationRepository;
import edu.cornell.haulers.services.TestService;
import io.swagger.annotations.SwaggerDefinition;

@RestController
public class testContoller {
	
	@Autowired
	TestService testService;

	@RequestMapping("/test")
	public String testContoller(){
		return "Your spring configuration is fine!";
	}
	
	@GetMapping("/testservice")
	public String testServiceContoller(){
		return testService.testMethod();
	}
	
	@RequestMapping(value="/testservice/json",produces=MediaType.APPLICATION_JSON_UTF8_VALUE,method=RequestMethod.GET)
	public String testServiceJson(){
		return testService.sampleJson();
	}
	
	
//	@Autowired
//	LocationRepository locationRepository;
	
//	@RequestMapping(value="/getnear",method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	  public ResponseEntity<List<LocationEntity> > getLocations(
//	    @RequestParam("lat") String latitude,
//	    @RequestParam("long") String longitude,
//	    @RequestParam("d") double distance,
//	    @RequestParam(value = "s", required = false) String subjects) {
//
//	    List<LocationEntity> location = locationRepository.findByLocationNear(new Point(Double.valueOf(longitude), Double.valueOf(latitude)), new Distance(distance, Metrics.KILOMETERS));
//		System.err.println("location: ");
//	    for(LocationEntity l : location) {	    
//	    	System.out.println(l.toString());
//	    }
//		return ResponseEntity.ok().body(location); 
//	}
//
//	@RequestMapping(value="/addlocation", method = RequestMethod.POST)
//	  @ResponseStatus(HttpStatus.CREATED)
//	  public final void addLocations(
//	    @RequestParam("s") String sid,
//	    @RequestBody double[] locationPoint) {
//
//	    //List<LocationEntity> entities = new ArrayList<>();
//	    //for (LocationEntry location : entries) {
////	      final GeoJsonPoint locationPoint = new GeoJsonPoint(
////	        Double.valueOf(location.getLongitude()),
////	        Double.valueOf(location.getLatitude()));
//	    	
//	      
//	    //}
//
//	    locationRepository.save(new LocationEntity(sid, locationPoint));
//	  }
	
}
