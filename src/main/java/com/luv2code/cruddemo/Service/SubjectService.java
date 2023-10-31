package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {


    List<Subject>findAll();

    Subject findById(int theId);

    Subject save(Subject theSubject);

}
