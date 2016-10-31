package ru.innopois.university.ramis.service;

import org.springframework.stereotype.Service;
import ru.innopois.university.ramis.model.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 * Сервис для работы со Студентом
 */
@Service
public interface StudentService {

    /**
     *  Получение списка студентов
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
     * Удаление студентов по id
     * @param id
     * @throws SQLException
     */
    void deleteStudent(Integer id) throws SQLException;

    /**
     * Добавление студентов
     * @param student
     * @throws SQLException
     */
    void addStudent(Student student) throws SQLException;
}
