package com.deepface.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.config.ParameterConfig;
import com.deepface.api.domain.DeepfaceRequest;
import com.deepface.api.domain.DeepfaceResponse;

@RequestScope
@Service
public class DeepfaceApiService {

	@Autowired
	private ParameterConfig config;
	
	protected DeepfaceResponse searchInformation(DeepfaceRequest criteria) {
		DeepfaceResponse response = new DeepfaceResponse();
		
		return response;
	}
	
	protected DeepfaceResponse addInformation(DeepfaceRequest criteria) {
		DeepfaceResponse response = new DeepfaceResponse();
		
		return response;
	}

}
