package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Exam_Result;

import java.util.List;

public interface Exam_ResultService {
    List<Exam_Result>findAll();
    Exam_Result findById(int theId);
    Exam_Result save(Exam_Result theExamResult);
}
