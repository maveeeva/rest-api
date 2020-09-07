package com.example.bootrest.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.bootrest.beans.StudentRegistration;

@Controller
public class StudentDeleteController {
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/student/{id}")
	
	@ResponseBody
	public String deleteStudentRecord(@PathVariable("id") String regdNum) {
		System.out.println("In deleteStudentRecord");   
		return StudentRegistration.getInstance().deleteStudent(regdNum);
	}
}
