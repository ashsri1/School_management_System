package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="admission")
public class Admission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stud_id")
    private int stud_id;

    @Column(name = "name")
    private String name;

    @Column(name = "previ_school")
    private String previ_school;

    @Column(name = "age")
    private int age;

    @Column(name = "admission_date")
    private Date admission_date;

    @Column(name = "father_name")
    private String father_name;

    @Column(name = "contact")
    private int contact;

    @Column(name = "email")
    private String email;

    @Column(name = "is_deleted")
    private Boolean is_deleted;


    public Admission() {


    }

    public Admission(String name, String previ_school, int age, Date admission_date, String father_name, int contact, String email, Boolean is_deleted) {
        this.name = name;
        this.previ_school = previ_school;
        this.age = age;
        this.admission_date = admission_date;
        this.father_name = father_name;
        this.contact = contact;
        this.email = email;
        this.is_deleted = is_deleted;
    }

    public int getStud_id() {
        return stud_id;
    }

    public void setStud_id(int stud_id) {
        this.stud_id = stud_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrevi_school() {
        return previ_school;
    }

    public void setPrevi_school(String previ_school) {
        this.previ_school = previ_school;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(Date admission_date) {
        this.admission_date = admission_date;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIs_deleted() {
        return is_deleted;
    }

    public boolean setIs_deleted(Boolean is_deleted) {
        this.is_deleted = is_deleted;
        return is_deleted;
    }

    @Override
    public String toString() {
        return "Admission{" +
                "stud_id=" + stud_id +
                ", name='" + name + '\'' +
                ", previ_school='" + previ_school + '\'' +
                ", age=" + age +
                ", admission_date=" + admission_date +
                ", father_name='" + father_name + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", is_deleted=" + is_deleted +
                '}';
    }
}