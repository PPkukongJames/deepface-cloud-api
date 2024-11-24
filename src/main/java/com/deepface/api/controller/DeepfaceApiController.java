package com.deepface.api.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.multipart.MultipartFile;

import com.deepface.api.domain.DeepfaceRequest;
import com.deepface.api.domain.DeepfaceSearchResponse;
import com.deepface.api.domain.DeepfaceUploadResponse;
import com.deepface.api.service.DeepfaceApiManager;

@RequestScope
@Controller
@RequestMapping(value = "/api")
public class DeepfaceApiController {
	
	@Autowired
	private DeepfaceApiManager manager;
	
	@PostMapping(value = "/search",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public  ResponseEntity<Object> searchInformation(@RequestBody DeepfaceRequest criteria) throws IOException {
		DeepfaceSearchResponse response = null;
		
		response = manager.searchInformation(criteria);
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/search-line",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE
	)
	public  ResponseEntity<Object> searchInformationLine(@ModelAttribute DeepfaceRequest criteria) throws IOException {
		DeepfaceSearchResponse response = null;
		
		response = manager.searchInformationLine(criteria);
		
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PostMapping(value = "/add",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public  ResponseEntity<Object> addInformation(@RequestBody DeepfaceRequest criteria)throws IOException {
		Boolean statusAdd = manager.addInformation(criteria);
		
		if(Boolean.FALSE.equals(statusAdd)) {
			return new ResponseEntity<>(criteria, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<>(criteria, HttpStatus.OK);
	}
	
	@PostMapping(value = "/upload",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE
	)
	public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
		DeepfaceUploadResponse response = null;
		
		response = manager.upload(file);
		
		System.out.println("upload success");
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@PostMapping(value = "/history",
			produces = MediaType.APPLICATION_JSON_VALUE,
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public ResponseEntity<Object> history(@RequestBody DeepfaceRequest criteria) throws IOException {
		
		manager.history(criteria);
		
		return new ResponseEntity<>(criteria, HttpStatus.OK);
		
	}
	
	
	
	
	

}
