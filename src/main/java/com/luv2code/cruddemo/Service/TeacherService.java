package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Teacher;

import java.util.List;

public interface TeacherService {
    List<Teacher> findAll();

    Teacher findById(int theId);

    Teacher save(Teacher theTeacher);

    void deleById(int theId);
}
