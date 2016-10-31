package ru.innopois.university.ramis.dao;

import ru.innopois.university.ramis.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 */
public interface UserDAO {

    List<Student> getStudentList() throws SQLException;

    Student getStudentByName(String firstName) throws SQLException;

    void deleteStudent(Integer id) throws SQLException;

    void addStudent(Student student) throws SQLException;
}
