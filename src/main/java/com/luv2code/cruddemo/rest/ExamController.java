package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.Service.ExamService;
import com.luv2code.cruddemo.entity.Exam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController


@RequestMapping("/api")
public class ExamController {

    private ExamService examService;

    public ExamController (ExamService theExamService) {

        examService=theExamService;
    }

    @GetMapping("/exam")
    public List<Exam> findAll(){
        return examService.findAll();
    }

    @PostMapping("/exam")
    public Exam addExam(@RequestBody Exam theExam){
        theExam.setExam_id(0);
        Exam dbExam=examService.save(theExam);
        return dbExam;
    }


}
