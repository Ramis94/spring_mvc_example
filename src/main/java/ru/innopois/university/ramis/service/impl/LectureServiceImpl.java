package ru.innopois.university.ramis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopois.university.ramis.dao.LectureDAO;
import ru.innopois.university.ramis.model.Lecture;
import ru.innopois.university.ramis.service.LectureService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
@Service
public class LectureServiceImpl implements LectureService {

    @Autowired
    LectureDAO lectureDAO;

    @Override
    public List<Lecture> getAllLecture() throws SQLException {
        return lectureDAO.getAllLecture();
    }

    @Override
    public void addLecture(Lecture lecture) throws SQLException {
        lectureDAO.addLecture(lecture);
    }
}
