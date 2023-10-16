package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Examtype;

import java.util.List;

public interface ExamtypeService {

    List<Examtype> findAll();
    Examtype findById(int theId);
    Examtype save(Examtype theExamtype);


}
