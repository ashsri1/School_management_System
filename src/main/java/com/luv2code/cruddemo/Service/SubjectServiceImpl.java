package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.SubjectRepository;
import com.luv2code.cruddemo.entity.Subject;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public class SubjectServiceImpl implements SubjectService{

    private SubjectRepository subjectRepository;

    @Autowired
    public SubjectServiceImpl(SubjectRepository theSubjectRepository){
        subjectRepository=theSubjectRepository;
    }


    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject findById(int theId) {

        Optional<Subject> result=subjectRepository.findById(theId);
        Subject theSubject=null;
        if (result.isPresent()){
            theSubject=result.get();
        }
        else {
            throw new RuntimeException("Did not find subject id - " +theId);
        }

        return theSubject;
    }

    @Override
    @Transactional
    public Subject save(Subject theSubject) {
        return subjectRepository.save(theSubject);
    }
}
