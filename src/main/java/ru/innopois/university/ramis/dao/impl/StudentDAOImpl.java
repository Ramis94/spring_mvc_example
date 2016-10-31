package ru.innopois.university.ramis.dao.impl;

import org.springframework.stereotype.Repository;
import ru.innopois.university.ramis.dao.StudentDAO;
import ru.innopois.university.ramis.model.Student;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 */
@Repository
public class StudentDAOImpl extends AbstractRepository implements StudentDAO {

    /*private List<Student> students = new ArrayList<>();

    {
        students.add(new Student(1, "Вася", "Иванов", "М", new Date(111111111)));
        students.add(new Student(2, "Катя", "Иванова", "Ж", new Date(222222222)));
        students.add(new Student(3, "Иван", "Иванов", "М", new Date(333333333)));
        students.add(new Student(4, "Михаил", "Иванов", "М", new Date(1111)));
        students.add(new Student(5, "Стас", "Иванов", "М", new Date(2222)));
        students.add(new Student(6, "Марат", "Иванов", "М", new Date(333333333)));
    }*/

    /**
     * В блоке соединяемся с БД
     */
    static {
        try {
            AbstractRepository.getConnection();
        } catch (ClassNotFoundException | IllegalAccessException | SQLException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Получение списка студентов из БД
     * @return
     * @throws SQLException
     */
    @Override
    public List<Student> getStudentList() throws SQLException {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM \"Students\"";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setFirstName(resultSet.getString("firstName"));
            student.setLastName(resultSet.getString("lastName"));
            student.setSex(resultSet.getString("sex"));
            student.setBornDate(resultSet.getDate("bornDate"));
            students.add(student);
        }
        return students;
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
}
