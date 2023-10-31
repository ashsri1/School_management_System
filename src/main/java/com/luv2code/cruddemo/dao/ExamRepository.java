package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam,Integer> {
}
