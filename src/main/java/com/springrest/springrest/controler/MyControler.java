package com.springrest.springrest.controler;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Employee;
import com.springrest.springrest.services.EmployeeService;

@CrossOrigin("*")

@RestController
public class MyControler {
	@Autowired
	private EmployeeService courseService;
	
	@GetMapping("/home")
	public String home()
	{
		return "this is request from home";
	}
	//get all courses
	@GetMapping("/employees")
	public List<Employee> getCourses()
	{
		return this.courseService.getCourses();
	}
	//get course by id
	@GetMapping("/employees/{employeesId}")
	public Employee getCourse(@PathVariable Long employeesId)
	{
		return this.courseService.getCourse(employeesId);
	}
	@PostMapping("/employees")
	public Employee addCourse(@RequestBody Employee employee) {
		return this.courseService.addCourse(employee);
		
	}
	@PutMapping("/employees")
	public Employee updateCourse(@RequestBody Employee employee)
	{
		return this.courseService.updateCourse(employee);
		
	}
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String employeeId)
	{
		try {
			 this.courseService.deleteCourse(Long.parseLong(employeeId));
			 return new ResponseEntity<>(HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/run")
	public String run() {
		return "Server is running";
	}

}
