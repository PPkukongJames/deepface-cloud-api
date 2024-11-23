package com.deepface.api.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class DeepfaceRequest implements Serializable {
	
	private static final long serialVersionUID = 3993701182382987667L;
	
	private String studentId;
	private MultipartFile picture;
	private String firstName;
	private String lastName;
	private String faculty;
	private String birthDate;
	private String gpax;
	private String detail;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public MultipartFile getPicture() {
		return picture;
	}
	public void setPicture(MultipartFile picture) {
		this.picture = picture;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getGpax() {
		return gpax;
	}
	public void setGpax(String gpax) {
		this.gpax = gpax;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}

	
	
}
