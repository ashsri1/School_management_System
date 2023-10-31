package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Attendence;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AttendenceService {

    List<Attendence>findAll();

    Attendence findById(int theId);

    Attendence save(Attendence theAttendence);


}
