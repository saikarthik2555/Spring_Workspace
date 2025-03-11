package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BootProj2DataJpaPagingSortingApplication {

	public static void main(String[] args) {
		System.out.println("App Start");
		ApplicationContext container=SpringApplication.run(BootProj2DataJpaPagingSortingApplication.class, args);
		System.out.println("App Stop");
		
		
	}
}
