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
		DeepfaceResponse response = null;
		if(havePicture(criteria)) {
			criteria.setPicture(criteria.getPictureMultipath().getBytes());
			response = service.searchInformation(criteria);
		}else {
			response = new DeepfaceResponse();
			response.setStatus("unsuccess");
			response.setStatusDetail("Picture not found.");
		}
		
		return response;
	}
	
	public DeepfaceResponse addInformation(DeepfaceRequest criteria) {
		DeepfaceResponse response = null;
		response = service.addInformation(criteria);
		
		return response;
	}
	
	private boolean havePicture(DeepfaceRequest criteria) throws IOException {
		return criteria.getPictureMultipath() != null || !criteria.getPictureMultipath().isEmpty() || criteria.getPictureMultipath().getBytes().length != 0;
	}
}
