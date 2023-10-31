package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Class_Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Class_StudentRepository extends JpaRepository<Class_Student,Integer> {
}
