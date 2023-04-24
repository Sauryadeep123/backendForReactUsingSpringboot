package com.springrest.springrest.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.springrest.springrest.entities.Employee;

public interface EmployeeService {
	public List<Employee> getCourses();
	public Employee getCourse(long courseId);
	public Employee addCourse(Employee course);
	public Employee updateCourse(Employee course);
	public void deleteCourse(long courseId);

}
