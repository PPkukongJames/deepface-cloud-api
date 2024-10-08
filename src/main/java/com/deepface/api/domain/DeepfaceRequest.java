package com.deepface.api.domain;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class DeepfaceRequest implements Serializable {
	
	private static final long serialVersionUID = 3993701182382987667L;
	
	private byte[] picture;
	private String studentNo;
	private MultipartFile pictureMultipath;
	private String name;
	private String surname;
	private String nickname;
	private Integer age;
	
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
	public MultipartFile getPictureMultipath() {
		return pictureMultipath;
	}
	public void setPictureMultipath(MultipartFile pictureMultipath) {
		this.pictureMultipath = pictureMultipath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
