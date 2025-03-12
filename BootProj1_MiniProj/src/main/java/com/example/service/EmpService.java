package com.example.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.Employee;
import com.example.dao.InsertEmpDaoI;

@Service("empInsertService")
public class EmpService {
	
	@Autowired
//	@Qualifier("dao")
	public InsertEmpDaoI insertEmpDao; //super class
	
	public String insertEmpFromService(Employee e) throws SQLException{
		boolean status=insertEmpDao.insertEmpFromDAO(e);
		
		return status?"Employee Details Inserted Successfully":"Not Inserted";
	}
	
	public List<Employee> getEmpFromService() throws SQLException{
			return insertEmpDao.getAllEmployees();
	}

}
