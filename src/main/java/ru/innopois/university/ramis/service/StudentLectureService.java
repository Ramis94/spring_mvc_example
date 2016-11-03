package ru.innopois.university.ramis.service;

import ru.innopois.university.ramis.model.StudentLecture;
import ru.innopois.university.ramis.model.common.StudentLectureVisit;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
public interface StudentLectureService {

    void addStudentLecture(List<Integer> id_user, Integer id_lesson) throws SQLException;

    List<StudentLecture> getListStudentLectures() throws SQLException;

    List<StudentLectureVisit> getVisit() throws SQLException;
}
