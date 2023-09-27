package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.TeacherRepository;
import com.luv2code.cruddemo.entity.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TeacherServiceImpl implements TeacherService{

    private TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImpl (TeacherRepository theTeacherRepository){
        teacherRepository=theTeacherRepository;
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(int theId) {
        Optional<Teacher> result = teacherRepository.findById(theId);
        Teacher theTeacher=null;
        if (result.isPresent()){
            theTeacher=result.get();
        }
        else {
            throw new RuntimeException("Did not find teacher id - " +theId);
        }

        return theTeacher;
    }
    @Transactional
    @Override
    public Teacher save(Teacher theTeacher) {
        return teacherRepository.save(theTeacher);
    }

    @Override
    public void deleById(int theId) {
        teacherRepository.deleteById(theId);


    }
}
