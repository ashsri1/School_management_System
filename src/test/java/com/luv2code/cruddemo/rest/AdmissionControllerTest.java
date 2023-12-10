package com.luv2code.cruddemo.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luv2code.cruddemo.Service.AdmissionService;
import com.luv2code.cruddemo.entity.Admission;
import com.luv2code.cruddemo.rest.AdmissionContoller;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.servlet.function.RequestPredicates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;


import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@WebMvcTest(AdmissionContoller.class)
public class AdmissionControllerTest {

    @MockBean
    AdmissionService admissionService;
    @Autowired
    MockMvc mockMvc;

    @Test
    public void test_findAll() throws Exception {
    }


    @Test
    public void test_findbyId(){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInString = "7-Jun-2013";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        Admission admission=new Admission("Shiv","dk public", 10,date ,"Suresh",3098654,"Shiv@gmail",false);
        when(admissionService.findByID(2)).thenReturn(admission);
        try {
            mockMvc.perform(post("/api/admission/{id}", 2)
                    .contentType(MediaType.APPLICATION_JSON));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void test_save() throws Exception {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInString = "7-Jun-2013";
        Date date = formatter.parse(dateInString);

        Admission admission=new Admission("Shiv","dk public", 10,date  ,"Suresh",3098654,"Shiv@gmail",false);
        when(admissionService.save(admission)).thenReturn(admission);
        mockMvc.perform(post("/api/admission")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(admission)))
                .andExpect(status().isOk());



    }

    @Test
    public void test_deleById() throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        String dateInString = "7-Jun-2013";
        Date date = null;
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int theId=1;
        Admission admission=new Admission("Shiv","dk public", 10,date  ,"Suresh",3098654,"Shiv@gmail",false);

        //doNothing().when(admissionService).deleById(theId);
        //when(admissionService.save(admission)).thenReturn(admission);
        when(admissionService.findByID(theId)).thenReturn(admission);

            mockMvc.perform(MockMvcRequestBuilders
                    .delete("/api/admission/{id}", theId)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());


        Mockito.verify(admissionService, Mockito.times(1)).deleById(theId);
    }



}
