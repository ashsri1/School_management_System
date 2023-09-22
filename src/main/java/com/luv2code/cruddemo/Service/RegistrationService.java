package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.entity.Registration;

import java.util.List;

public interface RegistrationService {

    List<Registration> findAll();

    Registration findByID(int theId);

    Registration save(Registration theRegistration);

    void deleById(int theId);
}
