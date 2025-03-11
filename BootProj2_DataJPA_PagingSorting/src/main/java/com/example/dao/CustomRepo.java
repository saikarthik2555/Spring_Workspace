package com.example.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.entity.Student;

public interface CustomRepo extends PagingAndSortingRepository<Student,Integer>{

}
