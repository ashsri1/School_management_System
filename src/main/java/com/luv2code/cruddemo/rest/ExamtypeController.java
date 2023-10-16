package com.luv2code.cruddemo.rest;


import com.luv2code.cruddemo.Service.ExamtypeService;
import com.luv2code.cruddemo.entity.Examtype;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class ExamtypeController {

    private ExamtypeService examtypeService;

    public ExamtypeController(ExamtypeService theExamtypeService){
        examtypeService=theExamtypeService;
    }

    @GetMapping("/Examtype")
    public List<Examtype> findAll(){
        return examtypeService.findAll();
    }

    @PostMapping("/Examtype")
    public Examtype addExamtype(@RequestBody Examtype theExamtype){
        theExamtype.setExamtype_id(0);
        Examtype dbExamtype=examtypeService.save(theExamtype);
        return dbExamtype;
    }


}
