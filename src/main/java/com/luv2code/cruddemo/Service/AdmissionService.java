package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Admission;

import java.util.List;

public interface AdmissionService {

    List<Admission> findAll();

    Admission findByID(int theId);

    Admission save(Admission theAdmission);

    Object deleById(int theId);





}
