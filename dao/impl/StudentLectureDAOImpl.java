package ru.innopois.university.ramis.dao.impl;

import org.springframework.stereotype.Repository;
import ru.innopois.university.ramis.dao.StudentLectureDAO;
import ru.innopois.university.ramis.model.Lecture;
import ru.innopois.university.ramis.model.Student;
import ru.innopois.university.ramis.model.StudentLecture;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
@Repository
public class StudentLectureDAOImpl extends AbstractRepository implements StudentLectureDAO {

    @Override
    public void addStudentLecture(List<Integer> student_id, Integer lecture_id) throws SQLException {
        String sql = "INSERT INTO \"student_lesson\"(student_id, lecture_id) VALUES (?,?)";
        connection.setAutoCommit(false);
        for (Integer i: student_id) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, i);
            preparedStatement.setInt(2, lecture_id);
            preparedStatement.executeUpdate();
        }
        connection.commit();
        connection.setAutoCommit(true);
    }

    @Override
    public List<StudentLecture> getListStudentLectures() throws SQLException {
        List<StudentLecture> studentLectures = new ArrayList<>();
        String sql = "SELECT * FROM \"Students\" as s JOIN student_lecture as sl ON s.id=sl.student_id JOIN lecture as l ON sl.lecture_id=l.id";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("student_id"));
            student.setFirstName(resultSet.getString("firstname"));
            student.setLastName(resultSet.getString("lastname"));
            student.setSex(resultSet.getString("sex"));
            student.setBornDate(resultSet.getDate("borndate"));
            Lecture lecture = new Lecture();
            lecture.setId(resultSet.getInt("lecture_id"));
            lecture.setTopic(resultSet.getString("topic"));
            lecture.setDescription(resultSet.getString("description"));
            lecture.setDate(resultSet.getDate("date"));
            StudentLecture studentLecture = new StudentLecture();
            studentLecture.setLecture_id(lecture);
            studentLecture.setStudent_id(student);
            studentLectures.add(studentLecture);
        }
        return studentLectures;
    }
}
