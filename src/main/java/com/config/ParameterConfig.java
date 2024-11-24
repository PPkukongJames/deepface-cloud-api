package com.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

@Configuration
public class ParameterConfig {

	@Value("${deepface.server}")
	private String deepfaceServer;
	
	@Value("${deepface.search}")
	private String deepfaceSearch;

	@Value("${path.tmp}")
	private String pathTmp;
	
	@Value("${objectstorage.url}")
	private String objectstorageUrl;
	
	@Value("${objectstorage.accesskey}")
	private String objectstorageAccesskey;
	
	@Value("${objectstorage.secretkey}")
	private String objectstorageSecretkey;
	
	@Value("${bucket.name}")
	private String bucketName;
	
	private S3Client s3Client;
	
	@PostConstruct
    public void init() throws Exception {
		
		AwsBasicCredentials credentials = AwsBasicCredentials.create(getObjectstorageAccesskey(), getObjectstorageSecretkey());
		S3Configuration s3Config = S3Configuration.builder()
			    .pathStyleAccessEnabled(true)
			    .build();//เนื่องจากมาจากการใช้งาน s3 ผ่านผู้ให้บริการที่ไม่ใช่ amazon จึ่งจำเป็นต้องเซ็ตค่านี้เพื่อป้องกันการแก้ไข url
		
		this.s3Client = S3Client.builder()
                .credentialsProvider(StaticCredentialsProvider.create(credentials))
                .endpointOverride(URI.create(getObjectstorageUrl()))
                .region(Region.US_EAST_1) // AWS_GLOBAL สามารถใช้ได้เนื่องจาก MinIO ไม่ใช้ region
                .serviceConfiguration(s3Config)
                .build();

		System.out.println("Connect S3");
	}
	
	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public S3Client getS3Client() {
		return s3Client;
	}

	public void setS3Client(S3Client s3Client) {
		this.s3Client = s3Client;
	}


	public String getDeepfaceServer() {
		return deepfaceServer;
	}

	public void setDeepfaceServer(String deepfaceServer) {
		this.deepfaceServer = deepfaceServer;
	}

	public String getDeepfaceSearch() {
		return deepfaceSearch;
	}

	public void setDeepfaceSearch(String deepfaceSearch) {
		this.deepfaceSearch = deepfaceSearch;
	}

	public String getPathTmp() {
		return pathTmp;
	}

	public void setPathTmp(String pathTmp) {
		this.pathTmp = pathTmp;
	}

	public String getObjectstorageUrl() {
		return objectstorageUrl;
	}

	public void setObjectstorageUrl(String objectstorageUrl) {
		this.objectstorageUrl = objectstorageUrl;
	}

	public String getObjectstorageAccesskey() {
		return objectstorageAccesskey;
	}

	public void setObjectstorageAccesskey(String objectstorageAccesskey) {
		this.objectstorageAccesskey = objectstorageAccesskey;
	}

	public String getObjectstorageSecretkey() {
		return objectstorageSecretkey;
	}

	public void setObjectstorageSecretkey(String objectstorageSecretkey) {
		this.objectstorageSecretkey = objectstorageSecretkey;
	}
		
}
