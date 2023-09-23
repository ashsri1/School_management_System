package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.Service.AdmissionService;
import com.luv2code.cruddemo.entity.Admission;
import com.luv2code.cruddemo.entity.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController


@RequestMapping("/api")
public class AdmissionContoller {

    private AdmissionService admissionService;

    public AdmissionContoller (AdmissionService theAdmissionService) {

        admissionService = theAdmissionService;
    }

    @GetMapping("/admission")
    public List<Admission> findAll() {

        return admissionService.findAll();
    }

    @GetMapping("/admission/{admissionId}")
    public Admission getAdmission(@PathVariable int admissionId){

        Admission theAdmission = admissionService.findByID(admissionId);
        if(theAdmission==null) {
            throw  new RuntimeException("Admission id not found - " + admissionId);
        }
        return theAdmission;
    }


    @PostMapping("/admission")
    public Admission addAdmission (@RequestBody Admission theAdmission){

        theAdmission.setStud_id(0);
        Admission dbAdmission = admissionService.save(theAdmission);
        return dbAdmission;
    }

    @PutMapping("/admission")
    public Admission updateAdmission(@RequestBody Admission theAdmission) {
        Admission dbAdmission = admissionService.save(theAdmission);
        return dbAdmission;
    }

    @DeleteMapping("/admission/{admissionId}")
    public String deleteAdmission(@PathVariable int admissionId) {
        Admission tempAdmission = admissionService.findByID(admissionId);

        if(tempAdmission == null) {
            throw new RuntimeException("Admission id not found - " + admissionId);

        }

        admissionService.deleById(admissionId);

        return "Deleted admission id - " + admissionId;
    }

}
