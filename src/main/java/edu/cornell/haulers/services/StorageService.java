package edu.cornell.haulers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import edu.cornell.haulers.entity.UploadDetails;
import edu.cornell.haulers.repositories.ImageRepository;

@Service
public class StorageService {
	@Autowired
	private FileArchiveService fileArchiveService;
	
	@Autowired
	private ImageRepository imageRepository;

	public UploadDetails saveImageToS3(MultipartFile image, String email) {
		UploadDetails uploadDetails = fileArchiveService.saveFileToS3(image, email);
//		if(uploadDetails!=null) {
//			// save key and email to backend
//			System.out.println("Saving key:"+uploadDetails.getKey()+"email:"+uploadDetails.getEmail());
//			imageRepository.save(uploadDetails);
//		}
		return uploadDetails;
	}
	
	public String getImageURL(String email) { // fetch the customer image entity and send image url to frontend
		System.out.println("Getting key for email: "+email);
		// OR fetch the URL from s3 using the key
		return imageRepository.findByEmail(email).getUrl();
	}
	
	
}
