package com.example.bootrest.beans;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {
	private List<Student> studentRecords;
	private static StudentRegistration stdregd = null;
	
	private StudentRegistration(){
		studentRecords = new ArrayList<Student>();
		Student st = new Student();
		st.setName("honey");
		st.setId("111");
		studentRecords.add(st);
		st = new Student();
		st.setName("welcome");
		st.setId("222");
		studentRecords.add(st);
	}
	
	public static StudentRegistration getInstance() {
		if(stdregd == null) {
			stdregd = new StudentRegistration();
			return stdregd;
		}
		else {
			return stdregd;
		}
	}
	
	
	public void add(Student std) {
		studentRecords.add(std);
	}
	
	
	public String upDateStudent(Student std) {
		for(int i=0; i<studentRecords.size(); i++)
		{
			Student stdn = studentRecords.get(i);
			if(stdn.getId().equals(std.getId())) {
				studentRecords.set(i, std);//update the new record
				return "Update successful";
			}
		}
		return "Update un-successful";
	}
	
	
	public String deleteStudent(String registrationNumber) {
		for(int i=0; i<studentRecords.size(); i++)
		{
			Student stdn = studentRecords.get(i);
			if(stdn.getId().equals(registrationNumber)){
				studentRecords.remove(i);//update the new record
				return "Delete successful";
			}
		}
		return "Delete un-successful";
	}
	

	public List<Student> getStudentRecords() {
		return studentRecords;
	}
}
