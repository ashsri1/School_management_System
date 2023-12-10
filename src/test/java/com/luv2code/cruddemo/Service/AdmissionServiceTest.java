package com.luv2code.cruddemo.Service;

import com.luv2code.cruddemo.dao.AdmissionRepository;
import com.luv2code.cruddemo.entity.Admission;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AdmissionServiceTest {

    @MockBean
    AdmissionRepository admissionRepository;

    @Autowired
    AdmissionService admissionService;


    @Test
    public void test_save(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInString = "7-Jun-2013";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Admission admission=new Admission("Shiv","dk public", 10,date ,"Suresh",3098654,"Shiv@gmail",false);

        when(admissionRepository.save(admission)).thenReturn(admission);

        assertEquals(admission,admissionService.save(admission));

    }
    @Test
    public void test_findById(){

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInString = "7-Jun-2013";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Admission admission=new Admission("Shiv","dk public", 10,date ,"Suresh",3098654,"Shiv@gmail",false);
        when(admissionRepository.findById(1)).thenReturn(Optional.of(admission));
        assertEquals("Shiv@gmail",admissionService.findByID(1).getEmail());


    }
    @Test
    public void test_findAll(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInString = "7-Jun-2013";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        List<Admission> AdmissionList= Arrays.asList(new Admission("Shiv","dk public", 10,date ,"Suresh",3098654,"Shiv@gmail",false),

                new Admission("Raaj","R.gSchool",8,date,"R.K singh",786437,"raaj@gmail",false));
                when(admissionRepository.findAll()).thenReturn(AdmissionList);
                assertEquals(2,admissionService.findAll().size());
    }
    @Test
    public void test_deleById(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInString = "7-Jun-2013";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int theId=1;
        Admission admission=new Admission("Shiv","dk public", 10,date ,"Suresh",3098654,"Shiv@gmail",false);



        Mockito.when(admissionRepository.findById(theId)).thenReturn(Optional.of(admission));


        admissionService.deleById(theId);


        Mockito.verify(admissionRepository, Mockito.times(1)).save(Mockito.any(Admission.class));
        //Mockito.verify(admissionRepository, Mockito.times(1)).deleteById(theId);


       assertTrue(admission.setIs_deleted(true));



    }
}


