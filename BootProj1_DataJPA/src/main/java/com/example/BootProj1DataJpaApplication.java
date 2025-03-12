package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.entity.Student;
import com.example.service.ServiceClass;

@SpringBootApplication
public class BootProj1DataJpaApplication {

	public static void main(String[] args) {
		System.out.println("App Start");
		ApplicationContext container = SpringApplication.run(BootProj1DataJpaApplication.class, args);

		ServiceClass sc = container.getBean("service", ServiceClass.class);

		/*						String res=sc.addStudent(new Student(1, "Krishna","Python", 22000d,"Hyder"));
									System.out.println(res);
									
		*/

		/*ArrayList<Student> arLst = new ArrayList<Student>();
		arLst.add(new Student(2, "A", "Python", 22000, "Sunnyvale"));
		arLst.add(new Student(3, "B", ".Net", 21000, "Chrply"));
		//arLst.add(new Student(4, "C", "UI", 20000, "Gtksr"));
		
		List<Integer> lst = sc.addAllStudents(arLst);
		lst.forEach(System.out::println);
		System.out.println("App End");
		*/
		
		
		/*		Iterable<Student> students= sc.getAllStudents();
				students.forEach(stu-> System.out.println(stu.getId()+"\t"+stu.getName()+"\t"+stu.getCourse()+"\t"+stu.getAddress()));
			
		*/	
		
		//fully updation
		/*Student stu=new Student();
		stu.setId(1);
		stu.setName("Hari Kirshna");
		stu.setCourse("Java");
		stu.setFees(25000);
		stu.setAddress("Hyderabad");
		//		String res=sc.addStudent(stu); 
		*/
		
		
		/*String res1=sc.addStudent(new Student(102,"DD", "UIUI", 10000, "PunePune"));
		//partial obj based on id 
		System.out.println(res1);
		*/
		//full obj modification/insertion dont give id
		
		String res2=sc.addStudent(new Student(160, "E", "Salesforce", 14000,"Malakpet"));
		System.out.println(res2);
	}

}
