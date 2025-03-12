package com.example.bean;

public class Employee {
	private String name;
	private String job;
	private double sal;
	private String dept;
	
	public Employee() {
		
	}
	
	public Employee(String name, String job, double sal, String dept) {
		super();
		this.name = name;
		this.job = job;
		this.sal = sal;
		this.dept = dept;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", job=" + job + ", sal=" + sal + ", dept=" + dept + "]";
	}	

}
