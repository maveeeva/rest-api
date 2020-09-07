package com.example.bootrest.beans;

public class Student {
    String name;
    int age;
    String id;
    
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setId(String registrationNumber) {
		this.id = registrationNumber;
	}
}
