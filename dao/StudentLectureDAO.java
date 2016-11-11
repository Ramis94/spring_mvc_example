package ru.innopois.university.ramis.dao;

import ru.innopois.university.ramis.model.StudentLecture;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
public interface StudentLectureDAO {

    void addStudentLecture(List<Integer> id_user, Integer id_lesson) throws SQLException;

    List<StudentLecture> getListStudentLectures() throws SQLException;
}
