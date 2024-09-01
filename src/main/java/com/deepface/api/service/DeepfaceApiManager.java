package com.deepface.api.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.deepface.api.domain.DeepfaceRequest;
import com.deepface.api.domain.DeepfaceResponse;

@RequestScope
@Component
public class DeepfaceApiManager {

	@Autowired
	private DeepfaceApiService service;
	
	public DeepfaceResponse searchInformation(DeepfaceRequest criteria) throws IOException {
		DeepfaceResponse response = new DeepfaceResponse();
		if(havePicture(criteria)) {
			criteria.setPicture(criteria.getFile().getBytes());
		}else {
			response.setStatus("unsuccess");
			response.setStatusDetail("Picture not found.");
		}
		
		return response;
	}
	
	public void addInformation(DeepfaceRequest criteria) {
		
	}
	
	private boolean havePicture(DeepfaceRequest criteria) throws IOException {
		return criteria.getFile() != null || !criteria.getFile().isEmpty() || criteria.getFile().getBytes().length != 0;
	}
}
