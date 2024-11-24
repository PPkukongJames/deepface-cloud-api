package com.deepface.api.domain;

import java.io.Serializable;

public class DeepfaceUploadResponse implements Serializable {

	private static final long serialVersionUID = 5796123093588564577L;

	private String tempFile;
	private String fileType;

	public String getTempFile() {
		return tempFile;
	}

	public void setTempFile(String tempFile) {
		this.tempFile = tempFile;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	
}
