package com.luv2code.cruddemo.rest;


import com.luv2code.cruddemo.Service.Class_StudentService;
import com.luv2code.cruddemo.entity.Class_Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class Class_StudentController {

    private Class_StudentService classStudentService;

    public Class_StudentController(Class_StudentService theclassStudentService){
        classStudentService=theclassStudentService;
    }

    @GetMapping("/class_student")
    public List<Class_Student> findAll(){
        return classStudentService.findAll();
    }

    @PostMapping("/class_student")
    public Class_Student addClassStudent(@RequestBody Class_Student theClass_Student){
        theClass_Student.setClass_student_id(0);
        Class_Student dbClassStudent=classStudentService.save(theClass_Student);
        return dbClassStudent;
    }




}
