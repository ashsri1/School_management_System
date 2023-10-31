package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Exam_Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Exam_resultRepository extends JpaRepository<Exam_Result,Integer> {
}
