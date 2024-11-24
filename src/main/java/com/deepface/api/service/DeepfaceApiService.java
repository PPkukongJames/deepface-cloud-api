package com.deepface.api.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.config.ParameterConfig;
import com.deepface.api.domain.DeepfaceRequest;
import com.deepface.api.domain.DeepfaceSearchResponse;
import com.deepface.util.search.SearchFace;
import com.deepface.util.upload.UploadToS3;

@RequestScope
@Service
public class DeepfaceApiService {

	@Autowired
	private ParameterConfig config;
	
	@Autowired
	private DeepfaceApiDao dao;
	
	protected DeepfaceSearchResponse searchFace(DeepfaceRequest criteria) throws IOException {
		SearchFace searchFace = new SearchFace(
					config.getDeepfaceServer()+config.getDeepfaceSearch()
				);
		

		return searchFace.getSearchFace(criteria);
	}
	
	protected Boolean addInformation(DeepfaceRequest criteria) {
		return dao.addInformation(criteria);
	}

	protected List<String> searchInformation(DeepfaceSearchResponse data) {
		return dao.searchInformation(data);
	}

	protected void history(DeepfaceRequest criteria) {
		dao.history(criteria);
		
	}

	protected void addPicture(DeepfaceRequest criteria) throws IOException {
		UploadToS3 uploadToS3 = new UploadToS3(config.getS3Client(),config.getBucketName());
		File file = new File(config.getPathTmp() + criteria.getTempFile());
		
		String fileName = criteria.getTempFile().replace(".tmp",criteria.getFileType());
		System.out.println(fileName);
		uploadToS3.uploadFile(criteria.getStudentId()+"/"+fileName, FileUtils.readFileToByteArray(file));
//		
	}

}
