package ru.innopois.university.ramis.dao;

import ru.innopois.university.ramis.model.Lecture;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
public interface LectureDAO {

    List<Lecture> getAllLecture() throws SQLException;

    void addLecture(Lecture lecture) throws SQLException;


}
