package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "fees")

public class Fees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fees_id")
    private  int fees_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stud_id")
    private Admission admission;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classroom_id")
    private Class_Room classRoom;

    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private Boolean status;


    public Fees(){


    }

    public Fees(Date date, Boolean status) {
        this.date = date;
        this.status = status;
    }

    public int getFees_id() {
        return fees_id;
    }

    public void setFees_id(int fees_id) {
        this.fees_id = fees_id;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Fees{" +
                "fees_id=" + fees_id +
                ", admission=" + admission +
                ", classRoom=" + classRoom +
                ", date=" + date +
                ", status=" + status +
                '}';
    }
}
