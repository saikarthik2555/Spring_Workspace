package com.example.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.bean.Employee;

public interface InsertEmpDaoI
{
	
	public boolean insertEmpFromDAO(Employee e)  throws SQLException;
	public List<Employee> getAllEmployees() throws SQLException;
}
