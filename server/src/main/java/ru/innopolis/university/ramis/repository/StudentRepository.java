package ru.innopolis.university.ramis.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.innopolis.university.ramis.entity.Student;

import java.sql.Date;
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

    @Transactional
    @Modifying
    @Query("update Student s set s.firstName = :firstName, s.lastName = :lastName, s.sex = :sex, bornDate = :bornDate where id = :id")
    void updateStudentById(@Param("id") Integer id, @Param("firstName") String firstName,
                           @Param("lastName") String lastName, @Param("sex") String sex, @Param("bornDate") Date bornDate) throws SQLException;
}
