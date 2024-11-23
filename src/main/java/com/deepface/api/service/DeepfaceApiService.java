package com.deepface.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.config.ParameterConfig;
import com.deepface.api.domain.DeepfaceRequest;
import com.deepface.api.domain.DeepfaceResponse;
import com.deepface.api.domain.DeepfaceSearchResponse;
import com.deepface.util.search.SearchFace;

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
	
	protected DeepfaceResponse addInformation(DeepfaceRequest criteria) {
		DeepfaceResponse response = new DeepfaceResponse();
		
		return response;
	}

	protected List<String> searchInformation(DeepfaceSearchResponse data) {
		return dao.searchInformation(data);
	}

}
