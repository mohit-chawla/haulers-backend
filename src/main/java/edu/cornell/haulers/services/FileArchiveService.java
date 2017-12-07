package edu.cornell.haulers.services;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;

//import org.joda.time.DateTime;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.context.annotation.Configuration;

import edu.cornell.haulers.entity.UploadDetails;

@Service
public class FileArchiveService {

	@Autowired
	private AmazonS3Client s3Client;

	@Value("${edu.aws.s3_bucket_name}")
	String S3_BUCKET_NAME;

	/**
	 * Save image to S3 and return CustomerImage containing key and public URL
	 * 
	 * @param multipartFile
	 * @return
	 * @throws IOException
	 */
	public UploadDetails saveFileToS3(MultipartFile multipartFile, String email) { // TODO: add throws xyzException
		try (InputStream inputStream = multipartFile.getInputStream();) {
			String key = multipartFile.getOriginalFilename();

			InputStream inputStreamCopy = multipartFile.getInputStream();

			Long contentLength = Long.valueOf(IOUtils.toByteArray(inputStreamCopy).length);
			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(contentLength);
			inputStreamCopy.close();
			PutObjectRequest fileUploadRequest = new PutObjectRequest(S3_BUCKET_NAME, key, inputStream, metadata);
			// inputStream.close();

			s3Client.putObject(fileUploadRequest); // save file

			GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(S3_BUCKET_NAME,
					key);
			generatePresignedUrlRequest.setMethod(HttpMethod.GET);
			// generatePresignedUrlRequest.setExpiration(DateTime.now().plusYears(1).toDate());

			URL signedUrl = s3Client.generatePresignedUrl(generatePresignedUrlRequest);
			return new UploadDetails(key, signedUrl.toString());
		} catch (Exception ex) {
			// TODO: add throws xyzException
			// TODO: log issue here
			ex.printStackTrace();
			System.out.println("Error occured in saveFileToS3!");

		}
		// TODO: ask for better thing to return
		System.out.println("saveFileToS3 returning null");
		return null;
	}

	/**
	 * Delete image from S3 using specified key
	 * 
	 * @param customerImage
	 */
	public void deleteImageFromS3(String key) {
		s3Client.deleteObject(new DeleteObjectRequest(S3_BUCKET_NAME, key));
	}

}
