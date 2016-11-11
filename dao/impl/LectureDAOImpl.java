package ru.innopois.university.ramis.dao.impl;

import org.springframework.stereotype.Repository;
import ru.innopois.university.ramis.dao.LectureDAO;
import ru.innopois.university.ramis.model.Lecture;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
@Repository
public class LectureDAOImpl extends AbstractRepository implements LectureDAO{


    @Override
    public List<Lecture> getAllLecture() throws SQLException {
        List<Lecture> lectureList = new ArrayList<>();
        String sql = "SELECT * FROM \"lecture\"";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Lecture lecture = new Lecture();
            lecture.setId(resultSet.getInt("id"));
            lecture.setTopic(resultSet.getString("topic"));
            lecture.setDescription(resultSet.getString("description"));
            lecture.setDate(resultSet.getDate("date"));
            lectureList.add(lecture);
        }
        return lectureList;
    }

    @Override
    public void addLecture(Lecture lecture) throws SQLException {
        String sql = "INSERT INTO \"lecture\" (topic, description, date)  VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, lecture.getTopic());
        preparedStatement.setString(2, lecture.getDescription());
        preparedStatement.setDate(3, lecture.getDate());
    }
}
