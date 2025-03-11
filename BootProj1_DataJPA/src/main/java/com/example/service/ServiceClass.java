package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.CustomRepo;
import com.example.entity.Student;

@Service("service")
public class ServiceClass {
	
	@Autowired
	public CustomRepo customrepo;

	
	public String addStudent(Student s){
		
		Student stuInstance=customrepo.save(s);
		return "The Student with Id :: "+stuInstance.getId()+" has Successfully Registered";
	}
	
	public List<Integer> addAllStudents(Iterable<Student> students) {
			Iterable<Student> insertedStus=	customrepo.saveAll(students);
			
			List<Integer> lst=new ArrayList<Integer>();
			insertedStus.forEach(stu-> lst.add(stu.getId()));
		
		return lst;
	}
	//select 
	//findById(Id) 
	//findAllById(Iterable<ID>)
	//findAll()
	
	
	public Iterable<Student> getAllStudents(){
		Iterable<Student> students=customrepo.findAll();
		return students;
	}
	
	//delete
	//deleteById
	//delete(T)
	//deleteAll()
	//deleteAll(Iterable<Id>)
	//deleteAllById(Iterable<ID>)
	
	
	
}
