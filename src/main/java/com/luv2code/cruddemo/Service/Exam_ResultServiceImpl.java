package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.Exam_resultRepository;
import com.luv2code.cruddemo.entity.Exam_Result;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Repository
@Service
public class Exam_ResultServiceImpl implements Exam_ResultService{

    private Exam_resultRepository examResultRepository;

    public Exam_ResultServiceImpl(Exam_resultRepository theExam_ResultRepository){
        examResultRepository=theExam_ResultRepository;
    }




    @Override
    public List<Exam_Result> findAll() {
        return examResultRepository.findAll();
    }

    @Override
    public Exam_Result findById(int theId) {

        Optional<Exam_Result> result=examResultRepository.findById(theId);
        Exam_Result theExam_Result=null;
        if (result.isPresent()){
            theExam_Result=result.get();
        }
        else {
            throw new RuntimeException("Did not find exam_result id -" + theId);
        }

        return theExam_Result;
    }
    @Transactional
    @Override
    public Exam_Result save(Exam_Result theExamResult) {
        return examResultRepository.save(theExamResult);
    }
}
