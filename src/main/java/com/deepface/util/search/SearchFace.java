package com.deepface.util.search;

import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.deepface.api.domain.DeepfaceRequest;
import com.deepface.api.domain.DeepfaceSearchResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("deprecation")
public class SearchFace {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	private String url;
	
	public SearchFace(String url) {
		this.url = url;
	}
	
	public DeepfaceSearchResponse getSearchFace(DeepfaceRequest criteria) throws IOException {
		
		RestTemplate restTemplate = new RestTemplate();
        HttpEntity<?> entity = getHttpEntity(criteria);

        ResponseEntity<String> jsonString = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        
        System.out.println(jsonString.getBody());
        DeepfaceSearchResponse response = objectMapper.readValue(jsonString.getBody(),DeepfaceSearchResponse.class);
		
		return response;
	}
	
	
	private  HttpEntity<?> getHttpEntity(DeepfaceRequest criteria) throws JSONException, IOException {
		JSONObject json = new JSONObject();
       
        
		json.put("picture", Base64.encodeBase64String(criteria.getPicture()));
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(json.toString(), headers);
	}
}
