package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "class_student")
public class Class_Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_student_id")
    private int class_student_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classroom_id")
    private Class_Room classRoom;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stud_id")
    private Admission admission;

    public Class_Student(){


    }

    public int getClass_student_id() {
        return class_student_id;
    }

    public void setClass_student_id(int class_student_id) {
        this.class_student_id = class_student_id;
    }

    public Class_Room getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Class_Room classRoom) {
        this.classRoom = classRoom;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    @Override
    public String toString() {
        return "Class_Student{" +
                "class_student_id=" + class_student_id +
                ", classRoom=" + classRoom +
                ", admission=" + admission +
                '}';
    }
}
