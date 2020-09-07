package com.example.bootrest.beans;

public class StudentRegistrationReply {
	String name;
	int age;
	String id;
	String registrationStatus;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String registrationNumber) {
		this.id = registrationNumber;
	}
	
	public String getRegistrationStatus() {
		return registrationStatus;
	}
	
	public void setRegistrationStatus(String registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
}
