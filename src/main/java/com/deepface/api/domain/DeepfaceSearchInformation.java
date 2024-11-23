package com.deepface.api.domain;

import java.io.Serializable;

public class DeepfaceSearchInformation implements Serializable {

	private static final long serialVersionUID = -4322038843148102008L;

	private String studentId;
	private String firstName;
	private String lastName;
	private String faculty;
	private String birthDate;
	private String gpaX;
	private String detailMsg;
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
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
	public String getGpaX() {
		return gpaX;
	}
	public void setGpaX(String gpaX) {
		this.gpaX = gpaX;
	}
	public String getDetailMsg() {
		return detailMsg;
	}
	public void setDetailMsg(String detailMsg) {
		this.detailMsg = detailMsg;
	}
}
