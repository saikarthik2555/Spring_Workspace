package com.example.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.example.entity.Student;
import com.example.service.ServiceClass;

@Component
public class NonOptionalRunner implements CommandLineRunner{
	
	public NonOptionalRunner() {
		System.out.println("runner executed");
	}
	
	@Autowired
	public ServiceClass sc;
	
	@Override
	public void run(String... args) throws Exception {
		
		//operations
//		1.  sort by names
		
		/*Iterable<Student> sortedData =sc.sortByNames(true, "fees");
		sortedData.forEach(stu-> System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getFees()));
		*/
		
		
			//pageNo = number of  pageSize Records
		   //pageSize = totalRecords/pageSize
		Page<Student> details=sc.getStudentInfoByPageNo(1, 5, true, "name"); 
		//2,3--> ps=8/3=2 so pn=2 --> 0-3 1-3 2-2 
		//2,2 -> 0-2 1-2 2-2(you want) 3-2
		//2,1 -> ps= 8/1=1   --> 0-1 1-1 2-1(you want) 3-1 4-1 5-1 6-1 7-1
		
		//0,5 -> means my total records=8
		//pageSize=8/5=1 pageNumber=1 --> 0-5 1-3(you want)
		//so place pageNumber only after dividing the Records/pageSize and write how many
		//how many records are getting for each page and then mention page Number
		
		//PageReqyest.of(pageNo,pageSize,Sort.by(Direction.ASC,"name");
		
		//0 -2 
		//1 -2
		//2 -2
		//3 -2
		
		//pageNumber  pageSize 
		//0-1
		//1-1
		//2-1
		//3-1
		
		
		System.out.println("number : "+details.getNumber());
		System.out.println("total pages : "+details.getTotalPages());
		System.out.println("pagesize : "+details.getSize());
		System.out.println("total no of Elements : "+details.getNumberOfElements());
		
		//getContent   page  inside content
	
			List<Student> lst=details.getContent();
			lst.forEach(stu-> System.out.println(stu.getName()));
			
			
			
			System.out.println("===========\t======================\t======");
			
			
			
		
	
	
	
	
	}

}
