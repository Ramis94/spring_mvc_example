package ru.innopolis.university.ramis.model;

import java.io.Serializable;

/**
 * Created by innopolis on 01.11.16.
 */
public class StudentLectureModel extends AbstractEntityModel implements Serializable {

    private StudentModel student_id;

    private LectureModel lecture_id;

    public StudentModel getStudent_id() {
        return student_id;
    }

    public void setStudent_id(StudentModel student_id) {
        this.student_id = student_id;
    }

    public LectureModel getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(LectureModel lecture_id) {
        this.lecture_id = lecture_id;
    }

    @Override
    public String toString() {
        return "StudentLectureModel{" +
                "student_id=" + student_id +
                ", lecture_id=" + lecture_id +
                '}';
    }

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
