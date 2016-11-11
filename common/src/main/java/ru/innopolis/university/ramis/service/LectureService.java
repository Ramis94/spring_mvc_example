package ru.innopolis.university.ramis.service;


import ru.innopolis.university.ramis.model.LectureModel;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
public interface LectureService {

    List<LectureModel> getAllLecture() throws SQLException;

    void addLecture(LectureModel lecture) throws SQLException;

}
