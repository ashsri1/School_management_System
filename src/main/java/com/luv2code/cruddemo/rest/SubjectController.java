package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.Service.SubjectService;
import com.luv2code.cruddemo.entity.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class SubjectController {

    private SubjectService subjectService;

    public SubjectController(SubjectService theSubjectService){
        subjectService=theSubjectService;
    }

    @GetMapping("/subject")
    public List<Subject> findAll(){
        return subjectService.findAll();
    }

    @PostMapping("/subject")
    public Subject addSubject(@RequestBody Subject theSubject){
        theSubject.setSubject_id(0);
       Subject dbSubject = subjectService.save(theSubject);
       return dbSubject;

    }
    @PutMapping("/subject")
    public Subject updateSubject(@RequestBody Subject theSubject){
        Subject dbSubject = subjectService.save(theSubject);
        return dbSubject;
    }


}
