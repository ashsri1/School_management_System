package com.luv2code.cruddemo.rest;


import com.luv2code.cruddemo.Service.Exam_ResultService;
import com.luv2code.cruddemo.entity.Exam_Result;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@Service
@RequestMapping("/api")
public class Exam_ResultController {

    private Exam_ResultService examResultService;

    public Exam_ResultController(Exam_ResultService theExam_ResultService){
        examResultService=theExam_ResultService;
    }

    @GetMapping("/exam_result")
    public List<Exam_Result> findAll(){
        return examResultService.findAll();
    }

    @PostMapping("/exam_result")
    public Exam_Result addExam_Result(@RequestBody Exam_Result theexamResult){
        theexamResult.setExam_result_id(0);
        Exam_Result dbExam_Result=examResultService.save(theexamResult);
        return dbExam_Result;
    }
    @PutMapping("/exam_result")
    public Exam_Result updateExam_Result(@RequestBody Exam_Result theExam_Result){
        Exam_Result dbExam_result=examResultService.save(theExam_Result);
        return dbExam_result;
    }



}
