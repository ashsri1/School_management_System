package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.ExamRepository;
import com.luv2code.cruddemo.entity.Exam;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamServiceImpl implements  ExamService{

    private ExamRepository examRepository;

    @Autowired
    public ExamServiceImpl(ExamRepository theExamRepository){
        examRepository=theExamRepository;
    }


    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }

    @Override
    public Exam findById(int theId) {

        Optional<Exam> result = examRepository.findById(theId);
        Exam theExam=null;
        if (result.isPresent()){
            theExam=result.get();
        }
        else {
            throw  new RuntimeException("Did not find Exam id -" +theId);
        }


        return theExam;
    }

    @Override
    @Transactional
    public Exam save(Exam theExam) {
        return examRepository.save(theExam);
    }
}
