package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Teacher;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@SpringBootApplication

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
