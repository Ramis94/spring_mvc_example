package ru.innopois.university.ramis.service;

import ru.innopois.university.ramis.model.Lecture;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
public interface LectureService {

    List<Lecture> getAllLecture() throws SQLException;

    void addLecture(Lecture lecture) throws SQLException;

}
