package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	List<Student> theStudents;
	// define @PostConstruct to load students data only once 
	@PostConstruct
	public void loadData(){

		theStudents = new ArrayList<>();
		
		theStudents.add(new Student("Ravi", "Varma"));
		theStudents.add(new Student("Ragu", "Sharma"));
		theStudents.add(new Student("Raju", "Barma"));
		
	}
	
	// define endpoint for "/students" - return list of student
	@GetMapping("/students")
	public List<Student> getStudents(){		
		return theStudents;
	}
	
	// define endpoint for "/students/{studentID}" - return list of student
	@GetMapping("/students/{studentID}")
	public Student getStudents(@PathVariable int studentID) {
		
		return theStudents.get(studentID);
	}
}
