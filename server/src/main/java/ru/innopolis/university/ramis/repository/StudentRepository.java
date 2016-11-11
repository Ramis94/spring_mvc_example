package ru.innopolis.university.ramis.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.university.ramis.entity.Student;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 09.11.16.
 */
public interface StudentRepository extends CrudRepository<Student, Integer>{

    /**
     *  Получение списка студентов
     * @return
     * @throws SQLException
     */
    List<Student> findAll();

    /**
     * Поиск студента по имени
     * @param firstName
     * @return
     * @throws SQLException
     */
    Student findStudentByFirstName(String firstName) throws SQLException;

    //void updateStudentById(Student student) throws SQLException;
}
