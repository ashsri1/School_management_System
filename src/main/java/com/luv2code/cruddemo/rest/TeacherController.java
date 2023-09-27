package com.luv2code.cruddemo.rest;


import com.luv2code.cruddemo.Service.TeacherService;
import com.luv2code.cruddemo.entity.Registration;
import com.luv2code.cruddemo.entity.Teacher;
import jakarta.persistence.OneToMany;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController

@RequestMapping("/api")
public class TeacherController {
    private TeacherService teacherService;

    public TeacherController(TeacherService theTeacherService){
        teacherService=theTeacherService;
    }

    @GetMapping("/teacher")
    public List<Teacher> findAll(){
        return teacherService.findAll();
    }

    @GetMapping("/teacher/{teacherId}")
    public Teacher getteacher(@PathVariable int teacherId){
        Teacher theTeacher =teacherService.findById(teacherId);
        if (theTeacher==null){
            throw  new RuntimeException("Teacher id not found - " + teacherId);
        }
        return theTeacher;
    }
    @OneToMany
    @PostMapping("/teacher")
    public Teacher addteacher(@RequestBody Teacher theTeacher){
        theTeacher.setTeacher_id(0);
        Teacher dbTeacher= teacherService.save(theTeacher);
        return dbTeacher;
    }
    @PutMapping("/teacher")
    public Teacher updateTeacher(@RequestBody Teacher theTeacher) {
        Teacher dbTeacher = teacherService.save(theTeacher);
        return dbTeacher;
    }


    @DeleteMapping("/teacher/{teacherId}")
    public String deleteTeacher(@PathVariable int teacherId) {
      Teacher tempTeacher = teacherService.findById(teacherId);

        if(tempTeacher == null) {
            throw new RuntimeException("Teacher id not found - " + teacherId);

        }

        teacherService.deleById(teacherId);

        return "Deleted teacher id - " + teacherId;
    }

}
