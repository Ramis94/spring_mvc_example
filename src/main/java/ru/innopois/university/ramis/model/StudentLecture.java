package ru.innopois.university.ramis.model;

/**
 * Created by innopolis on 01.11.16.
 */
public class StudentLecture {

    private Student student_id;

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
}
