package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.ExamtypeRepository;
import com.luv2code.cruddemo.entity.Examtype;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamtypeServiceImpl implements ExamtypeService{

    private ExamtypeRepository examtypeRepository;

    @Autowired
    public ExamtypeServiceImpl(ExamtypeRepository theExamtypeRepository){
        examtypeRepository=theExamtypeRepository;
    }




    @Override
    public List<Examtype> findAll() {
        return examtypeRepository.findAll();
    }

    @Override
    public Examtype findById(int theId) {

        Optional<Examtype> result=examtypeRepository.findById(theId);
        Examtype theExamtype=null;

        if (result.isPresent()){
            theExamtype=result.get();
        }
        else {
            throw new RuntimeException("did not find examtype id - " + theId);
        }

        return theExamtype;
    }

    @Override
    @Transactional
    public Examtype save(Examtype theExamtype) {
        return examtypeRepository.save(theExamtype);
    }
}
