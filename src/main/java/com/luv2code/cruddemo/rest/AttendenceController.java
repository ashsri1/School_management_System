package com.luv2code.cruddemo.rest;


import com.luv2code.cruddemo.Service.AttendenceService;
import com.luv2code.cruddemo.entity.Attendence;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@Service
@RequestMapping("/api")
public class AttendenceController {

    private AttendenceService attendenceService;

    public AttendenceController (AttendenceService theAttendenceService){
        attendenceService=theAttendenceService;
    }

    @GetMapping("/attendence")

    public List<Attendence> findAll(){
        return attendenceService.findAll();

    }

    @PostMapping("/attendence")

    public Attendence addAttendence(@RequestBody Attendence theAttendence){
        Attendence dbAttendence=attendenceService.save(theAttendence);
        return dbAttendence;
    }




}
