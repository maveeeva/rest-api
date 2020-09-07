package com.example.bootrest.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.*;
import com.example.bootrest.beans.Student;
import com.example.bootrest.beans.StudentRegistration;
@Controller

public class StudentRetrieveController {
	
  @RequestMapping(method = RequestMethod.GET, value="/student/allstudent", produces = "application/json")
  @CrossOrigin(origins = "http://localhost:8083")
  
  @ResponseBody
  public List<Student> getAllStudents() {
  return StudentRegistration.getInstance().getStudentRecords();
  }


}
