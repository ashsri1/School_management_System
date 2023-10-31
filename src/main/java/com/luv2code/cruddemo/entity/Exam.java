package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private int exam_id;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "examtype_id")
    private Examtype examtype;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    public Exam(){

    }

    public Exam(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public int getExam_id() {
        return exam_id;
    }

    public void setExam_id(int exam_id) {
        this.exam_id = exam_id;
    }

    public Examtype getExamtype() {
        return examtype;
    }

    public void setExamtype(Examtype examtype) {
        this.examtype = examtype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "exam_id=" + exam_id +
                ", examtype=" + examtype +
                ", name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
