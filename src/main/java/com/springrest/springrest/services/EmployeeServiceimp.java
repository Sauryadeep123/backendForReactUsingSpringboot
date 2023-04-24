package com.springrest.springrest.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springrest.springrest.dao.EmployeeDao;
import com.springrest.springrest.entities.Employee;
@Service
public class EmployeeServiceimp implements EmployeeService {
	//List<Course> list;
	@Autowired
	private EmployeeDao coursedao;
    
	public EmployeeServiceimp() {
//		list=new ArrayList<>();
//		list.add(new Course(102,"java","almost oops"));
//		list.add(new Course(103,"CPP","oops"));
		
	}


	@Override
	public List<Employee> getCourses() {
		
		//return list;
		return coursedao.findAll();
	}


	
	@SuppressWarnings("deprecation")
	@Override
	public Employee getCourse(long courseId) {
		//Course c=null;
//		for(Course var:list)
//		{
//			if(var.getId()==courseId)
//			{
//				c=var;
//				break;
//			}
//		}
		Optional<Employee> o=coursedao.findById(courseId);

		if(o.isPresent()) return o.get();

		else return null;
		//return coursedao.getById(courseId);
	}


	@Override
	public Employee addCourse(Employee course) {
//		list.add(course);
		coursedao.save(course);
     	return course;
	}


	@Override
	public Employee updateCourse(@ModelAttribute Employee course) {
//		for(int i=0;i<list.size();i++)
//		{
//			if(list.get(i).getId()==course.getId())
//			{
//				list.set(i, course);
//				break;
//			}
//		}
		
		coursedao.save(course);
		return course;
		
	}


	@Override
	public void deleteCourse(long courseId) {
//		for(int i=0;i<list.size();i++)
//		{
//			if(list.get(i).getId()==courseId)
//			{
//				list.remove(i);
//				break;
//			}
//		}
		Employee entity=coursedao.getOne(courseId);
		coursedao.delete(entity);
	}

}
