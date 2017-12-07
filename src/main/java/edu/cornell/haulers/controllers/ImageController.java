package edu.cornell.haulers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import edu.cornell.haulers.entity.UploadDetails;
import edu.cornell.haulers.exceptions.HaulersExceptionHandlers;
import edu.cornell.haulers.services.StorageService;

@RestController
public class ImageController extends HaulersExceptionHandlers{

	@Autowired
	private StorageService storageService;
	
	@RequestMapping(value = "/images", method = RequestMethod.POST)
    public @ResponseBody UploadDetails saveImage(@RequestParam(value="image", required=true) MultipartFile image, @RequestParam(value="email", required=true) String email) {
		UploadDetails customerImage = storageService.saveImageToS3(image, email);
		return customerImage; 
	}
	@RequestMapping(value = "/images", method = RequestMethod.GET)
	public @ResponseBody String getImageURL(@RequestParam(value="email", required=true) String email) {
		return storageService.getImageURL(email);
	}
	
}
