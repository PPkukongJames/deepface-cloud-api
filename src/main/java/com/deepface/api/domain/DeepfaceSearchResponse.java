package com.deepface.api.domain;

import java.io.Serializable;

public class DeepfaceSearchResponse implements Serializable{

	private static final long serialVersionUID = 7118135255186202679L;

	private Boolean match;
	private Boolean haveInformation;
	private Boolean haveDetail;
	private DeepfaceSearchResultResponse deepface;
	private DeepfaceSearchInformation information;
	
	public Boolean getMatch() {
		return match;
	}
	public void setMatch(Boolean match) {
		this.match = match;
	}
	public DeepfaceSearchResultResponse getDeepface() {
		return deepface;
	}
	public void setDeepface(DeepfaceSearchResultResponse deepface) {
		this.deepface = deepface;
	}
	public DeepfaceSearchInformation getInformation() {
		return information;
	}
	public void setInformation(DeepfaceSearchInformation information) {
		this.information = information;
	}
	public Boolean getHaveInformation() {
		return haveInformation;
	}
	public void setHaveInformation(Boolean haveInformation) {
		this.haveInformation = haveInformation;
	}
	public Boolean getHaveDetail() {
		return haveDetail;
	}
	public void setHaveDetail(Boolean haveDetail) {
		this.haveDetail = haveDetail;
	}
		
}
