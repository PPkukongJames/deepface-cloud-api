package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParameterConfig {

	@Value("${deepface.server}")
	private String deepfaceServer;
	
	@Value("${deepface.search}")
	private String deepfaceSearch;

	public String getDeepfaceServer() {
		return deepfaceServer;
	}

	public void setDeepfaceServer(String deepfaceServer) {
		this.deepfaceServer = deepfaceServer;
	}

	public String getDeepfaceSearch() {
		return deepfaceSearch;
	}

	public void setDeepfaceSearch(String deepfaceSearch) {
		this.deepfaceSearch = deepfaceSearch;
	}
	
	
}
