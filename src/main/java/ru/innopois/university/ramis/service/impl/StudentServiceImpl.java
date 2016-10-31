package ru.innopois.university.ramis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopois.university.ramis.dao.StudentDAO;
import ru.innopois.university.ramis.model.Student;
import ru.innopois.university.ramis.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 * Сервис для работы со Студентом
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    /**
     *  Получение списка студентов
     * @return
     * @throws SQLException
     */
    @Override
    public List<Student> getStudentList() throws SQLException {
        return studentDAO.getStudentList();
    }

    /**
     * Поиск студента по имени
     * @param firstName
     * @return
     * @throws SQLException
     */
    @Override
    public Student getStudentByName(String firstName) throws SQLException {
        return studentDAO.getStudentByName(firstName);
    }

    /**
     * Удаление студентов по id
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteStudent(Integer id) throws SQLException {
        studentDAO.deleteStudent(id);
    }

    /**
     * Добавление студентов
     * @param student
     * @throws SQLException
     */
    @Override
    public void addStudent(Student student) throws SQLException {
        studentDAO.addStudent(student);
    }
}
