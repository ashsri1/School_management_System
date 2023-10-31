package com.luv2code.cruddemo.rest;


import com.luv2code.cruddemo.Service.FeesService;
import com.luv2code.cruddemo.entity.Fees;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@org.springframework.web.bind.annotation.RestController
@Service
@RequestMapping("/api")
public class FeesController {

    private FeesService feesService;

    public FeesController(FeesService theFeesservice){
        feesService=theFeesservice;
    }


    @GetMapping("/fees")
    public List<Fees> findAll(){
        return feesService.findAll();
    }

    @PostMapping("/fees")
    public Fees addFees(@RequestBody Fees theFees){
        theFees.setFees_id(0);

        Fees dbFees=feesService.save(theFees);
        return dbFees;

    }

    @PutMapping("/fees")
    public Fees updateFees(@RequestBody Fees theFees) {
        Fees dbFees = feesService.save(theFees);
        return dbFees;
    }


}
