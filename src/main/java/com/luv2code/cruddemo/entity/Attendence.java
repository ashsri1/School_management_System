package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "attendence")
public class Attendence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendence_id")
    private int attendence_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stud_id")
    private Admission admission;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classroom_id")
    private Class_Room classRoom;

    @Column(name = "date")
    private Date date;

    public Attendence(){

    }

    public Attendence(Date date) {
        this.date = date;
    }

    public int getAttendence_id() {
        return attendence_id;
    }

    public void setAttendence_id(int attendence_id) {
        this.attendence_id = attendence_id;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    public Class_Room getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Class_Room classRoom) {
        this.classRoom = classRoom;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Attendence{" +
                "attendence_id=" + attendence_id +
                ", admission=" + admission +
                ", classRoom=" + classRoom +
                ", date=" + date +
                '}';
    }
}
