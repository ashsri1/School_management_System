package com.luv2code.cruddemo.rest;



import com.luv2code.cruddemo.CruddemoApplication;


import com.luv2code.cruddemo.entity.Admission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;

import org.springframework.boot.test.web.server.LocalServerPort;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

import java.util.Locale;


import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = CruddemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class AdmissionControllerIntegrationTest {

    @LocalServerPort
    private int port;

    private String baseurl = "http://localhost";


    private static TestRestTemplate restTemplate;


    @BeforeAll
    public static void init() {
        restTemplate = new TestRestTemplate();

    }

    @BeforeEach
    public void setup() {
        baseurl = baseurl.concat(":").concat(port + "").concat("/admission");
    }

    @Test
    public void testAddAdmission() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInString = "7-Jun-2013";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Admission admission = new Admission("Shiv", "dk public", 10, date, "Suresh", 3098654, "Shiv@gmail", false);
        Admission response = restTemplate.postForObject(baseurl, admission, Admission.class);
      Assertions.assertEquals("Shiv",admission.getName());
      Assertions.assertEquals(10,admission.getAge());

    }


  }









