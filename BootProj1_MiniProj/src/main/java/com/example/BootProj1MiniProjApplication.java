package com.example;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import com.example.bean.Employee;
import com.example.controller.EmpController;

@SpringBootApplication
//@ImportResource("com/example/appconfig/ApplicationConfig.xml")
public class BootProj1MiniProjApplication {
	
	@Autowired
	private  Environment env;
	
	public static void main(String[] args) {
		ApplicationContext container=SpringApplication.run(BootProj1MiniProjApplication.class, args);
		
//		InsertEmpDao insert=container.getBean("empInsertdao", InsertEmpDao.class);
//		System.out.println(insert.getDataSource());

//		Scanner sc=new Scanner(System.in);
//		System.out.print("Enter Name : ");
//		String name=sc.nextLine();
//		System.out.print("\nEnter Designation : ");
//		String desg=sc.nextLine();
//		System.out.print("\nEnter Salary : ");
//		double salary=Double.parseDouble(sc.nextLine());
//		System.out.print("\nEnter Department : ");
//		String dept=sc.nextLine();		
		
		
		try {
		EmpController controller=container.getBean("empInsertController", EmpController.class);
		
//		String res=controller.insertEmpFromController(new Employee(name, desg, salary, dept));
//		System.out.println(res);
		
		List<Employee> employees=controller.getEmpFromController();
		employees.forEach(emp-> System.out.println(emp.getName()+"\t\t"+emp.getJob()+"\t\t"+emp.getSal()+"\t\t"+emp.getDept()));
		}
		catch(SQLException  e) {
			e.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		Environment env1=container.getEnvironment();
		
		System.out.println("Active Profiles are : "+Arrays.toString(env1.getActiveProfiles()));
		 ((ConfigurableApplicationContext)container).close();
//		 sc.close();
	}

}
