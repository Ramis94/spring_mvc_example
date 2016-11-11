package ru.innopolis.university.ramis.service;

import ru.innopolis.university.ramis.model.StudentModel;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by innopolis on 31.10.16.
 * Сервис для работы со Студентом
 */
public interface StudentService {

    /**
     *  Получение списка студентов
     * @return
     * @throws SQLException
     */
    List<StudentModel> getStudentList() throws SQLException;

    /**
     * Поиск студента по имени
     * @param firstName
     * @return
     * @throws SQLException
     */
    StudentModel getStudentByName(String firstName) throws SQLException;

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
    void addStudent(StudentModel student) throws SQLException;

    void updateStudent(StudentModel student) throws SQLException;

    List<StudentModel> getSortedStudentListByColumn(String column) throws SQLException;
}
