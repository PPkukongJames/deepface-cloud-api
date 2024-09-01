package com.deepface.api.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

import com.deepface.api.domain.DeepfaceRequest;
import com.deepface.api.domain.DeepfaceResponse;
import com.deepface.api.service.DeepfaceApiManager;

@RequestScope
@Controller
@RequestMapping(value = "/deepface")
public class DeepfaceApiController {
	
	@Autowired
	private DeepfaceApiManager manager;
	
	@PostMapping(value = "/search",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE}
	)
	public  ResponseEntity<Object> searchInformation(@ModelAttribute DeepfaceRequest criteria) {
		
		DeepfaceResponse response = null;
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = {MediaType.MULTIPART_FORM_DATA_VALUE,MediaType.APPLICATION_JSON_VALUE}
	)
	public  ResponseEntity<Object> addInformation(@ModelAttribute DeepfaceRequest criteria) {
		
		DeepfaceResponse response = null;
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	

}
