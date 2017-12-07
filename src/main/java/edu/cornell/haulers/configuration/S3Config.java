package edu.cornell.haulers.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.regions.Regions;
//import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.AmazonS3ClientBuilder;
//import com.amazonaws.services.s3.model.Region;
 
@Configuration
public class S3Config {
//	@Value("${edu.aws.access_key_id}")
//	private String awsId;
// 
//	@Value("${edu.aws.secret_access_key}")
//	private String awsKey;
//	
//	@Value("${edu.s3.region}")
//	private String region;
// 
//	@Bean
//	public AmazonS3 s3client() {
//		
//		BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsId, awsKey);
//		AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//								.withRegion(Regions.fromName(region))
//		                        .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
//		                        .build();
//		
//		return s3Client;
//	}
	
	
	 @Value("${edu.aws.access_key_id}")
	    private String accessKey;

	    @Value("${edu.aws.secret_access_key}")
	    private String secretKey;

	    @Value("${edu.s3.region}")
	    private String region;

	    @Bean
	    public BasicAWSCredentials basicAWSCredentials() {
	        return new BasicAWSCredentials(accessKey, secretKey);
	    }

	    @Bean
	    public AmazonS3Client amazonS3Client(AWSCredentials awsCredentials) {
	        AmazonS3Client amazonS3Client = new AmazonS3Client(awsCredentials);
	        return amazonS3Client;
	    }
}
