package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.bean.Employee;

@Repository("mysqldao")
@Profile({"dev","test"})
public class InsertEmpDaoMySql implements InsertEmpDaoI{

	private static final String INSERTQuery="INSERT INTO employee(empName,sal,job,deptno) values(?,?,?,?)";
	private static final String GETEMPLOYEES="SELECT * FROM EMPLOYEE ORDER BY SAL";
	@Autowired
	private DataSource ds;   //driver details app.prop
	
	
	@Override
	public boolean insertEmpFromDAO(Employee e) throws SQLException{
		int i=0;
		try(Connection con=ds.getConnection(); PreparedStatement ps=con.prepareStatement(INSERTQuery)){
			
			ps.setString(1, e.getName());
			ps.setDouble(2, e.getSal());
			ps.setString(3, e.getJob());
			ps.setString(4, e.getDept());

			
			
			i=ps.executeUpdate();
			
			System.out.println(ds.getClass());		//ds
	
		}catch(SQLException exp) {
			System.out.println(exp.getMessage());
			throw new SQLException();
		}
		return i>0;
	}

	public DataSource getDataSource() {
		return ds;
	}

	@Override
	public List<Employee> getAllEmployees() throws SQLException{
		List<Employee> lst;
		try(Connection con=ds.getConnection(); PreparedStatement ps=con.prepareStatement(GETEMPLOYEES)){
			ResultSet rs=ps.executeQuery();
			
			lst=new ArrayList<Employee>();
			while(rs.next()) {
				Employee emp=new Employee();
				emp.setName(rs.getString(2));
				emp.setSal(rs.getDouble(3));
				emp.setJob(rs.getString(4));
				emp.setDept(rs.getString(5));
				lst.add(emp);
			}
			
			System.out.println("DataSource : "+ds.getClass());
			
		}catch(SQLException se) {
			System.out.println(se.getMessage());
			throw new SQLException();
		}
		
		return lst;
	}


}
