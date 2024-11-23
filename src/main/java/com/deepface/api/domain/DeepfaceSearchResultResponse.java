package com.deepface.api.domain;

import java.io.Serializable;

public class DeepfaceSearchResultResponse implements Serializable{

	private static final long serialVersionUID = -3741517888671717604L;
	
	private String id;
	private String filename;
	private String img;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
