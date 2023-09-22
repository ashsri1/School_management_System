package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.Service.RegistrationService;
import com.luv2code.cruddemo.entity.Registration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

   private RegistrationService registrationService;

   public RestController(RegistrationService theRegistrationService){

       registrationService=theRegistrationService;
   }

   @GetMapping("/registration")
    public List<Registration> findAll() {

       return registrationService.findAll();
   }
   @GetMapping("/registration/{registrationId}")
       public Registration getRegistration(@PathVariable int registrationId){

       Registration theRegistration = registrationService.findByID(registrationId);
       if(theRegistration==null) {
           throw  new RuntimeException("Registration id not found - " + registrationId);
       }
        return theRegistration;
   }



        @PostMapping("/registration")
    public Registration addRegistration (@RequestBody Registration theRegistration){

       theRegistration.setRegis_id(0);
       Registration dbRegistration = registrationService.save(theRegistration);
       return dbRegistration;
        }

        @PutMapping("/registration")
    public Registration updateRegistration(@RequestBody Registration theRegistration) {
       Registration dbRegistration = registrationService.save(theRegistration);
       return dbRegistration;
        }

        @DeleteMapping("/registration/{registrationId}")
    public String deleteRegistration(@PathVariable int registrationId) {
       Registration tempRegistration = registrationService.findByID(registrationId);

       if(tempRegistration == null) {
           throw new RuntimeException("Regstraion id not found - " + registrationId);

       }

       registrationService.deleById(registrationId);

       return "Deleted registration id - " + registrationId;
        }
}
