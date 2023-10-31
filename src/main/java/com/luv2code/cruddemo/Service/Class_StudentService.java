package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Class_Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Class_StudentService {

    List<Class_Student> findAll();

    Class_Student findById(int theId);

    Class_Student save(Class_Student theClass_Student);

}
