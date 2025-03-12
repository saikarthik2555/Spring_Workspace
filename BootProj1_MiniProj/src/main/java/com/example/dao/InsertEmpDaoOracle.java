package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.example.bean.Employee;

@Repository("oracledao")
@Profile({"act","prod"})
public class InsertEmpDaoOracle implements InsertEmpDaoI{

	private static final String INSERTQUERY="INSERT INTO EMPLOYEE (EMPID,EMPNAME,EMPSAL,EMPJOB,EMPDEPT) VALUES(EMPSEQ.NEXTVAL,?,?,?,?)";
	
	@Autowired
	private DataSource ds;   //driver details app.prop
	
	@Override
	public boolean insertEmpFromDAO(Employee e) throws SQLException {	

			int i=0;
			try(Connection con=ds.getConnection(); PreparedStatement ps=con.prepareStatement(INSERTQUERY)){
				
				ps.setString(2, e.getName());
				ps.setDouble(3, e.getSal());
				ps.setString(4, e.getJob());
				ps.setString(5, e.getDept());

			
				
				i=ps.executeUpdate();
				
				System.out.println(ds.getClass());
			}catch(SQLException exp) {
				System.out.println(exp.getMessage());
				throw new SQLException();
			}
			return i>0;
		}

	@Override
	public List<Employee> getAllEmployees()  throws SQLException{
		return null;
	}

		}


