package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Exam;

import java.util.List;

public interface ExamService {

    List<Exam>findAll();

    Exam findById(int theId);

    Exam save(Exam theExam);

}
