package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.dao.CustomRepo;
import com.example.entity.Student;

@Service("service")
public class ServiceClass {
	
	@Autowired
	public CustomRepo customrepo;
	
	
	public Iterable<Student> sortByNames(boolean option,String property){    //property names
		Sort direction=Sort.by(option?Sort.Direction.ASC:Sort.Direction.DESC,property);
	
		return customrepo.findAll(direction);
	}
	  
	public Page<Student> getStudentInfoByPageNo(int pageNo,int pageSize,boolean status,String property){
		
		
		
		Sort sorting=Sort.by(status?Direction.ASC:Direction.DESC,property);
		Pageable pg=PageRequest.of(pageNo, pageSize,sorting);
		
		Page<Student> details=customrepo.findAll(pg);
	return details;	
	}
	
	public void showDataThroughPagesize(int size) {

	
	}

	
	
}
