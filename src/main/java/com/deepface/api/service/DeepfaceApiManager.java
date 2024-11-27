package com.deepface.api.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.config.ParameterConfig;
import com.deepface.api.domain.DeepfaceRequest;
import com.deepface.api.domain.DeepfaceSearchResponse;
import com.deepface.api.domain.DeepfaceUploadResponse;

@RequestScope
@Component
public class DeepfaceApiManager {

	@Autowired
	private DeepfaceApiService service;
	
	@Autowired
	private ParameterConfig config;
	
	public DeepfaceSearchResponse searchInformationLine(DeepfaceRequest criteria) throws IOException {
		DeepfaceSearchResponse response = null;
		if(havePicture(criteria)) {
			criteria.setPicture(criteria.getMultipartFile().getBytes());
			response = searchInformationAndQuery(criteria);
		}else {
			response = new DeepfaceSearchResponse();
			response.setHaveDetail(false);
			response.setHaveInformation(false);
			response.setMatch(false);
		}
		
		return response;
	}
	
	public DeepfaceSearchResponse searchInformation(DeepfaceRequest criteria) throws IOException {
		DeepfaceSearchResponse response = null;
		if(havePictureTmp(criteria)) {
			File file = new File(config.getPathTmp() + criteria.getTempFile());
			criteria.setPicture(FileUtils.readFileToByteArray(file));
			response = searchInformationAndQuery(criteria);
		}else {
			response = new DeepfaceSearchResponse();
		}
		
		return response;
	}
	
	private DeepfaceSearchResponse searchInformationAndQuery(DeepfaceRequest criteria) throws IOException {
		
		DeepfaceSearchResponse data = service.searchFace(criteria);
		data.setHaveInformation(false);
		data.setHaveInformation(false);
		List<String> listDetail = service.searchInformation(data);
		
		StringBuilder detailMsg = new StringBuilder();
		int i = 1;
		for(String detail:listDetail) {
			detailMsg.append(String.valueOf(i));
			detailMsg.append(". ");
			detailMsg.append(detail);
			detailMsg.append("\n");
			i++;
		}
		detailMsg.deleteCharAt(detailMsg.length() - 1);
		
		data.getInformation().setDetailMsg(detailMsg.toString());
		return data;
	}
	
	public Boolean addInformation(DeepfaceRequest criteria) throws IOException {
		System.out.println("addInformation");
		Boolean statusAdd = null;
		if(criteria.getFileType() != null && criteria.getTempFile() != null) {
			statusAdd = service.addInformation(criteria);
		}else {
			statusAdd = false;
		}
		
		if(Boolean.TRUE.equals(statusAdd)) {
			service.addPicture(criteria);
		}	
		
		return statusAdd;
	}
	
	private boolean havePictureTmp(DeepfaceRequest criteria) throws IOException {
		return (criteria.getTempFile() != null && !"".equals(criteria.getTempFile().strip()));
	}
	
	private boolean havePicture(DeepfaceRequest criteria) throws IOException {
		return (criteria.getMultipartFile() != null || !criteria.getMultipartFile().isEmpty() || criteria.getMultipartFile().getBytes().length != 0);
	}

	public DeepfaceUploadResponse upload(MultipartFile file) throws IOException {
		
		DeepfaceUploadResponse response = new DeepfaceUploadResponse();
		
		String tmpFileName = String.valueOf(System.nanoTime()) + ".tmp";
		String pathFileName = config.getPathTmp()+tmpFileName;
		File tmpFile = FileUtils.getFile(pathFileName);
		OutputStream output = null;
		try {
			output = new FileOutputStream(tmpFile);

			IOUtils.write(file.getBytes(), output);
		} finally {
			if (output != null) {
				output.close();
			}
		}
		
		String originName = file.getOriginalFilename();
		System.out.println(originName);
		response.setFileType("."+originName.substring(originName.lastIndexOf(".") + 1));
		response.setTempFile(tmpFileName);
		
		return response;
	}

	public void history(DeepfaceRequest criteria) throws IOException {
		System.out.println("history");
		service.history(criteria);
		service.addPicture(criteria);
	}
}
