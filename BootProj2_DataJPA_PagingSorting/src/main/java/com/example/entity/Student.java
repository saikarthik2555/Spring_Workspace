package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="StudentDetails")
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Column(name="StuId")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)   //dynamically increments
	private int id;
	
	@Column(name="StuName")
	private String name;
	
	@Column(name="Course")
	private String course;
	
	@Column(name="TutionFee")
	private double fees;
	
	@Column(name="Location")
	private String address;
	
	

	
	
	
}
