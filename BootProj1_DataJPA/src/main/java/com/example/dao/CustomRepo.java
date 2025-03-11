package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;

@Repository
public interface CustomRepo extends CrudRepository<Student,Integer>{

}
