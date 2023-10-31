package com.luv2code.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "exam_result")
public class Exam_Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_result_id")
    private int exam_result_id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "exam_id")
    private Exam exam;


    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "stud_id")
    private Admission admission;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @Column(name = "marks")
    private int marks;

    public Exam_Result(){

    }

    public Exam_Result(int marks) {
        this.marks = marks;
    }

    public int getExam_result_id() {
        return exam_result_id;
    }

    public void setExam_result_id(int exam_result_id) {
        this.exam_result_id = exam_result_id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Admission getAdmission() {
        return admission;
    }

    public void setAdmission(Admission admission) {
        this.admission = admission;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Exam_Result{" +
                "exam_result_id=" + exam_result_id +
                ", exam=" + exam +
                ", admission=" + admission +
                ", subject=" + subject +
                ", marks=" + marks +
                '}';
    }
}
