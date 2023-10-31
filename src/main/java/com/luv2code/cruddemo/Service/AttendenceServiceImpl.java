package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.AttendenceRepository;
import com.luv2code.cruddemo.entity.Attendence;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@Service

public class AttendenceServiceImpl implements AttendenceService{

    private AttendenceRepository attendenceRepository;

    @Autowired
    public AttendenceServiceImpl(AttendenceRepository theAttendenceRepository){
        attendenceRepository=theAttendenceRepository;

    }


    @Override
    public List<Attendence> findAll() {
        return attendenceRepository.findAll();
    }

    @Override
    public Attendence findById(int theId) {

        Optional<Attendence> result=attendenceRepository.findById(theId);
        Attendence theAttendence=null;

        if (result.isPresent()){
            theAttendence=result.get();
        }
        else {
            throw new RuntimeException("Did not find attendence id -" + theId);
        }

        return theAttendence;
    }

    @Override
    @Transactional
    public Attendence save(Attendence theAttendence) {
        return attendenceRepository.save(theAttendence);
    }
}
