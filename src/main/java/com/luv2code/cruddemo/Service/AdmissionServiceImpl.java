package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.AdmissionRepository;
import com.luv2code.cruddemo.entity.Admission;
import com.luv2code.cruddemo.entity.Registration;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdmissionServiceImpl implements AdmissionService{

    private AdmissionRepository admissionRepository;

    @Autowired
    public  AdmissionServiceImpl(AdmissionRepository theAdmissionRepository) {
        admissionRepository=theAdmissionRepository;
    }

    @Override
    public List<Admission> findAll() {
        return admissionRepository.findAll();
    }

    @Override
    public Admission findByID(int theId) {
        Optional<Admission> result = admissionRepository.findById(theId);
        Admission theadmission=null;
        if(result.isPresent()){
            theadmission=result.get();

        }
        else {
            throw new RuntimeException("Did not find registration id - " +theId);
        }
        return theadmission;
    }
    @Transactional
    @Override
    public Admission save(Admission theAdmission) {

        return admissionRepository.save(theAdmission);
    }

    @Transactional
    @Override
    public void deleById(int theId) {
        admissionRepository.deleteById(theId);

    }
}
