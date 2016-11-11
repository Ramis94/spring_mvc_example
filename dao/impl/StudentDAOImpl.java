package ru.innopois.university.ramis.dao.impl;

import org.springframework.stereotype.Repository;
import ru.innopois.university.ramis.dao.StudentDAO;
import ru.innopois.university.ramis.model.Student;

import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 */
@Repository
public class StudentDAOImpl extends AbstractRepository implements StudentDAO {

    /**
     * Получение списка студентов из БД
     * @return
     * @throws SQLException
     */
    @Override
    public List<Student> getStudentList() throws SQLException {
        entityManager.getTransaction().begin();
        TypedQuery<Student> students = entityManager.createNamedQuery("Student.getAll", Student.class);
        entityManager.getTransaction().commit();
        return students.getResultList();
    }

    /**
     * Получение студента по имени
     * @param firstName
     * @return
     * @throws SQLException
     */
    @Override
    public Student getStudentByName(String firstName) throws SQLException {
        String sql = "SELECT * FROM \"Students\" WHERE firstname= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, firstName);
        ResultSet resultSet = preparedStatement.executeQuery();
        Student student = new Student();
        while (resultSet.next()){
            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("firstName"));
            student.setLastName(resultSet.getString("lastName"));
            student.setSex(resultSet.getString("sex"));
            student.setBornDate(resultSet.getDate("bornDate"));
        }
        return student;
    }

    /**
     * Удаление студента по id
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteStudent(Integer id) throws SQLException {
        String sql = "DELETE FROM \"Students\" WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    /**
     * Добавление студента
     * @param student
     * @throws SQLException
     */
    @Override
    public void addStudent(Student student) throws SQLException {
        String sql = "INSERT INTO \"Students\"(firstname, lastname, sex, borndate) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, student.getSex());
        preparedStatement.setDate(4, student.getBornDate());
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        String sql = "UPDATE \"Students\" SET firstname=?, lastname=?, sex=?, borndate=? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, student.getFirstName());
        preparedStatement.setString(2, student.getLastName());
        preparedStatement.setString(3, student.getSex());
        preparedStatement.setDate(4, student.getBornDate());
        preparedStatement.setInt(5, student.getId());
        preparedStatement.executeQuery();
    }
}
