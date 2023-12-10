package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.AdmissionRepository;
import com.luv2code.cruddemo.entity.Admission;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdmissionServiceImpl implements AdmissionService {

    Logger logger= LoggerFactory.getLogger(AdmissionServiceImpl.class);

    private AdmissionRepository admissionRepository;

    @Autowired
    public AdmissionServiceImpl(AdmissionRepository theAdmissionRepository) {
        admissionRepository = theAdmissionRepository;
    }

    @Override
    public List<Admission> findAll() {

        logger.info("get all admission method in service class");

        List<Admission> Adms =admissionRepository.findAll();
      List<Admission> result =new ArrayList<Admission>();

        for ( Admission adm : Adms
             ) {
            if(!adm.getIs_deleted()){
                result.add(adm);
            }

        }
        return result;

    }

    @Override
    public Admission findByID(int theId) {
        Optional<Admission> result = admissionRepository.findById(theId);
        Admission theadmission = null;
        if (result.isPresent()) {
            theadmission = result.get();

        if(theadmission.getIs_deleted()){
            theadmission=null;
        }

        } else {
            throw new RuntimeException("Did not find registration id - " + theId);
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
    public Object deleById(int theId) {
       Optional<Admission>  Ad1 = admissionRepository.findById(theId);




           if (Ad1.isPresent())
           {
               Admission Ad = Ad1.get();
               Ad.setIs_deleted(true);
               admissionRepository.save(Ad);
           }


        return null;
    }


    }
