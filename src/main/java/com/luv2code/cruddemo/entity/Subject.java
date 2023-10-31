package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "subject")
public class Subject  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_id")
    private int subject_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "classroom_id")
    private Class_Room classRoom;

    @Column(name = "name")
    private String name;

    public Subject(){

    }

    public Subject(String name) {
        this.name = name;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public Class_Room getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Class_Room classRoom) {
        this.classRoom = classRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subject_id=" + subject_id +
                ", classRoom=" + classRoom +
                ", name='" + name + '\'' +
                '}';
    }
}
