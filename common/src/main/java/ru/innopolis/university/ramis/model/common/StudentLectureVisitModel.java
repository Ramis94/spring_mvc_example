package ru.innopolis.university.ramis.model.common;

import ru.innopolis.university.ramis.model.StudentModel;

import java.io.Serializable;

/**
 * Created by innopolis on 01.11.16.
 */
public class StudentLectureVisitModel implements Serializable {

    private StudentModel student;

    private Integer visit;

    public StudentModel getStudent() {
        return student;
    }

    public void setStudent(StudentModel student) {
        this.student = student;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }
}
