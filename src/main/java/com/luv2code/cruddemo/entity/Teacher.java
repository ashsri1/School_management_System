package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int teacher_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "contact")
    private int contact;

   // @OneToOne(mappedBy = "teacher")
    //private Class_Room classRoom;

    public Teacher() {

    }

    public Teacher(String name, String email, int contact) {
        this.name = name;
        this.email = email;
        this.contact = contact;
     //   this.classRoom = classRoom;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

  /*  public Class_Room getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(Class_Room classRoom) {
        this.classRoom = classRoom;
    }

   */

    @Override
    public String toString() {
        return "Teacher{" +
                "teacher_id=" + teacher_id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact=" + contact +
               // ", classRoom=" + classRoom +
                '}';
    }
}