package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="registration")
public class Registration {
    //define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="regis_id")
    private int regis_id;

    @Column(name="name")
    private String name;


    @Column(name="gender")
    private String gender;

    @Column(name="dob")
    private Date dob;

    @Column(name="address")
    private String address;

    @Column(name="contact")
    private int contact;

    @Column(name="date_of_join")
    private Date date_of_join;

    //define constructors

    public Registration(){

    }


    public Registration(String name, String gender, Date dob, String address, int contact, Date date_of_join) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.contact = contact;
        this.date_of_join = date_of_join;
    }


    //define getter/setter

    public int getRegis_id() {
        return regis_id;
    }

    public void setRegis_id(int regis_id) {
        this.regis_id = regis_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public Date getDate_of_join() {
        return date_of_join;
    }

    public void setDate_of_join(Date date_of_join) {
        this.date_of_join = date_of_join;
    }


    //define tostring() method

    @Override
    public String toString() {
        return "registration{" +
                "regis_id=" + regis_id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", contact=" + contact +
                ", date_of_join=" + date_of_join +
                '}';
    }
}


