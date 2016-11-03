package ru.innopois.university.ramis.model.common;

import ru.innopois.university.ramis.model.Student;

/**
 * Created by innopolis on 01.11.16.
 */
public class StudentLectureVisit {

    private Student student;

    private Integer visit;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getVisit() {
        return visit;
    }

    public void setVisit(Integer visit) {
        this.visit = visit;
    }
}
