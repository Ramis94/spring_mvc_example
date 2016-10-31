package ru.innopois.university.ramis.service;

import org.springframework.stereotype.Service;
import ru.innopois.university.ramis.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 */
@Service
public interface UserService {

    List<Student> getStudentList() throws SQLException;

    Student getStudentByName(String firstName) throws SQLException;

    void deleteStudent(Integer id) throws SQLException;

    void addStudent(Student student) throws SQLException;
}
