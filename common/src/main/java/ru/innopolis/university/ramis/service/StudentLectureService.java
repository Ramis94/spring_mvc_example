package ru.innopolis.university.ramis.service;

import ru.innopolis.university.ramis.model.StudentLectureModel;
import ru.innopolis.university.ramis.model.common.StudentLectureVisitModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
public interface StudentLectureService {

    void addStudentLecture(List<Integer> id_user, Integer id_lesson) throws SQLException;

    List<StudentLectureModel> getListStudentLectures() throws SQLException;

    List<StudentLectureVisitModel> getVisit() throws SQLException;
}
