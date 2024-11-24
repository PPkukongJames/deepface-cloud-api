package com.deepface.util.upload;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class UploadToS3 {

	private S3Client s3Client; 
	private String bucketName;
	
	public UploadToS3(S3Client s3Client,String bucketName){
		this.s3Client = s3Client;
		this.bucketName = bucketName;
	}
	
	public void uploadFile(String objectName ,byte[] fileContent) {
		PutObjectRequest putObjectRequest = null;
		putObjectRequest = PutObjectRequest.builder()
	            .bucket(bucketName)
	            .key(objectName)
	            .build();
		RequestBody requestBody = RequestBody.fromBytes(fileContent);
		putObjectForUpload(putObjectRequest,requestBody);
    }
	
	private void putObjectForUpload(PutObjectRequest putObjectRequest,RequestBody requestBody) {
		this.s3Client.putObject(putObjectRequest, requestBody);	
	}
}
