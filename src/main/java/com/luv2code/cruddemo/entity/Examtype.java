package com.luv2code.cruddemo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "examtype")
public class Examtype {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examtype_id")
    private int examtype_id;


    @Column(name = "name")
    private String name;

    public Examtype(){

    }

    public Examtype(String name) {
        this.name = name;
    }

    public int getExamtype_id() {
        return examtype_id;
    }

    public void setExamtype_id(int examtype_id) {
        this.examtype_id = examtype_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Examtype{" +
                "examtype_id=" + examtype_id +
                ", name='" + name + '\'' +
                '}';
    }
}
