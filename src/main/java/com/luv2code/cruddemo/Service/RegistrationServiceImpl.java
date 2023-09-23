package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.RegistrationRepository;
import com.luv2code.cruddemo.entity.Registration;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService{

    private RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository theRegistrationRepository){
        registrationRepository=theRegistrationRepository;
    }


    @Override
    public List<Registration> findAll() {
        return registrationRepository.findAll();


        }

    @Override
    public Registration findByID(int theId) {
        Optional<Registration> result = registrationRepository.findById(theId);
        Registration theregistration=null;
        if(result.isPresent()){
            theregistration=result.get();

        }
        else {
            throw new RuntimeException("Did not find registration id - " +theId);
        }
        return theregistration;
    }
    @Transactional
    @Override
    public Registration save(Registration theRegistration) {

        return registrationRepository.save(theRegistration);
    }

    @Transactional
    @Override
    public void deleById(int theId) {
        registrationRepository.deleteById(theId);

    }
}

