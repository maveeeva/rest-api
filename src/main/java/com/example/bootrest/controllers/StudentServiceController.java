package com.example.bootrest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.example.bootrest.beans.Student;
import com.example.bootrest.beans.StudentRegistration;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@CrossOrigin(origins = "http://localhost:8083")
@RequestMapping(value = "/orders", method=RequestMethod.GET)
public class StudentServiceController {
   // private List<Student> studentList = StudentRegistration.getInstance().getStudentRecords();
    private final AtomicLong counter = new AtomicLong();
//    StudentServiceController(){
//    	Student st = new Student();
//    	st.setName("hello1");
//    	st.setId("111");
//    	studentList.add(st);
//    }
    @GetMapping(value = "/")

    public ResponseEntity index() {
        return ResponseEntity.ok(StudentRegistration.getInstance().getStudentRecords());
    }
    
  
   
//    @GetMapping(value = "/{id}")
//    public ResponseEntity getStudent(@RequestHeader("accept-language")@PathVariable String id) {
//
//        Student itemToReturn = null;
//        for(Student bucket : studentList){
//            if(bucket.getId().equals(id))
//                itemToReturn = bucket;
//        }
//        return ResponseEntity.ok(itemToReturn.getName());
//    }
    
    @RequestMapping(value = "/add/{id}/name/{name}", method=RequestMethod.GET)
    @ResponseBody
    public String addStudent(@RequestHeader("accept-language") @PathVariable String id ,@PathVariable String name) {
        
        for(Student bucket : StudentRegistration.getInstance().getStudentRecords()){
            if(bucket.getId().equals(id)) {
                
            return "Already exist , cannot add again  student for  id: "+id ;
            }
        }
        Student st = new Student();
        st.setName(name);
        st.setId(id);
    	StudentRegistration.getInstance().add(st);
    	
        return "Added student for  id: "+id +"  name :" +name;
    }
    
    @RequestMapping(value = "/{id}", method=RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable final String id ) {
    	
    	String itemToReturn = null;

        for(Student bucket : StudentRegistration.getInstance().getStudentRecords()){
            if(bucket.getId().equals(id))
                itemToReturn = bucket.getName();
        }
      return " ID: " + id + ", Name: " + itemToReturn;
    }
   
    @RequestMapping(value = "/update/{id}/name/{name}", method=RequestMethod.GET)
    @ResponseBody
    public String updateStudent( @PathVariable String id, @PathVariable String name) {
        for(Student bucket : StudentRegistration.getInstance().getStudentRecords()){

            if(bucket.getId().equals(id)){
            	bucket.setName(name);
            	 StudentRegistration.getInstance().deleteStudent(id);
                StudentRegistration.getInstance().add(bucket);
                return "upadted  ID: " + id + "  with  Name: " + name;
            }
           	
            
        }
        return "Does not exist  ID: " + id ;
    }
    
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.GET)
    @ResponseBody
    public String removeStudent(@PathVariable  String id) {
        Student itemToRemove = null;
        for(Student bucket : StudentRegistration.getInstance().getStudentRecords()){
            if(bucket.getId() == id)
                itemToRemove = bucket;
            StudentRegistration.getInstance().deleteStudent(id);
        }
        
        
        return " deleted student ID: " + id ;
    }
}