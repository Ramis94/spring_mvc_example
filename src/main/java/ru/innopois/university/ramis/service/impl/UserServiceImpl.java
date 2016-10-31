package ru.innopois.university.ramis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopois.university.ramis.dao.UserDAO;
import ru.innopois.university.ramis.model.Student;
import ru.innopois.university.ramis.service.UserService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public List<Student> getStudentList() throws SQLException {
        return userDAO.getStudentList();
    }

    @Override
    public Student getStudentByName(String firstName) throws SQLException {
        return userDAO.getStudentByName(firstName);
    }

    @Override
    public void deleteStudent(Integer id) throws SQLException {
        userDAO.deleteStudent(id);
    }

    @Override
    public void addStudent(Student student) throws SQLException {
        userDAO.addStudent(student);
    }
}
