package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.Class_StudentRepository;
import com.luv2code.cruddemo.entity.Class_Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Class_StudentServiceImpl implements Class_StudentService{

    private Class_StudentRepository classStudentRepository;

    @Autowired
    public Class_StudentServiceImpl(Class_StudentRepository theclassStudentRepository){
        classStudentRepository=theclassStudentRepository;
    }



    @Override
    public List<Class_Student> findAll() {
        return classStudentRepository.findAll();
    }

    @Override
    public Class_Student findById(int theId) {

        Optional<Class_Student> result=classStudentRepository.findById(theId);
        Class_Student theclassStudent=null;

        if (result.isPresent()){
            theclassStudent=result.get();
        }
        else {
            throw new RuntimeException("did not find Class_student id - " + theId);
        }


        return theclassStudent;
    }

    @Override
    public Class_Student save(Class_Student theClass_Student) {
        return classStudentRepository.save(theClass_Student);
    }
}
