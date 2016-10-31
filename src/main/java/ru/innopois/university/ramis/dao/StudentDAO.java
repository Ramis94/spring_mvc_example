package ru.innopois.university.ramis.dao;

import ru.innopois.university.ramis.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 */
public interface StudentDAO {

    /**
     * Получение студентов
     * @return
     * @throws SQLException
     */
    List<Student> getStudentList() throws SQLException;

    /**
     * Поиск студента по имени
     * @param firstName
     * @return
     * @throws SQLException
     */
    Student getStudentByName(String firstName) throws SQLException;

    /**
     * Удаление
     * @param id
     * @throws SQLException
     */
    void deleteStudent(Integer id) throws SQLException;

    void addStudent(Student student) throws SQLException;
}
