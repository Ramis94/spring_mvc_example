package ru.innopolis.university.ramis.entity;

import javax.persistence.*;

/**
 * Created by innopolis on 01.11.16.
 */
@Entity
@Table(name = "student_lecture")
public class StudentLecture {

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student_id;

    @ManyToOne
    @JoinColumn(name = "lecture_id")
    private Lecture lecture_id;

    public Student getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Student student_id) {
        this.student_id = student_id;
    }

    public Lecture getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(Lecture lecture_id) {
        this.lecture_id = lecture_id;
    }

    @Override
    public String toString() {
        return "StudentLecture{" +
                "student_id=" + student_id +
                ", lecture_id=" + lecture_id +
                '}';
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
