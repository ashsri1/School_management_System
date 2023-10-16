package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;
import org.hibernate.engine.internal.Cascade;

import java.time.Year;

@Entity
@Table(name = "class_room")

public class Class_Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private int classroom_id;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @Column(name = "year")
    private Year year;

    @Column(name = "section")
    private String section;

    public Class_Room() {

    }

    public Class_Room(Year year, String section) {
        this.year = year;
        this.section = section;
    }

    public int getClassroom_id() {
        return classroom_id;
    }

    public void setClassroom_id(int classroom_id) {
        this.classroom_id = classroom_id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "Class_Room{" +
                "classroom_id=" + classroom_id +
                ", teacher=" + teacher +
                ", year=" + year +
                ", section='" + section + '\'' +
                '}';
    }
}

