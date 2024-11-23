package com.deepface.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.deepface.api.domain.DeepfaceRequest;
import com.deepface.api.domain.DeepfaceResponse;
import com.deepface.api.domain.DeepfaceSearchResponse;

@RequestScope
@Component
public class DeepfaceApiManager {

	@Autowired
	private DeepfaceApiService service;
	
	public DeepfaceSearchResponse searchInformation(DeepfaceRequest criteria) throws IOException {
		DeepfaceSearchResponse response = null;
		if(havePicture(criteria)) {
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
	
	public DeepfaceResponse addInformation(DeepfaceRequest criteria) {
		DeepfaceResponse response = null;
		response = service.addInformation(criteria);
		
		return response;
	}
	
	private boolean havePicture(DeepfaceRequest criteria) throws IOException {
		return criteria.getPicture() != null || !criteria.getPicture().isEmpty() || criteria.getPicture().getBytes().length != 0;
	}
}
