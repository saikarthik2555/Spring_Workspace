package com.example.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.bean.Employee;
import com.example.service.EmpService;

@Controller("empInsertController")
public class EmpController {
	
	@Autowired
	public EmpService empser;
	
	
	public String insertEmpFromController(Employee e) throws SQLException{
		return empser.insertEmpFromService(e);
	}
	
	public List<Employee> getEmpFromController() throws SQLException{
		return empser.getEmpFromService();
	}
}
