package ru.innopolis.university.ramis.service.impl;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.university.ramis.entity.Student;
import ru.innopolis.university.ramis.model.StudentModel;
import ru.innopolis.university.ramis.repository.StudentRepository;
import ru.innopolis.university.ramis.service.StudentService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 * Сервис для работы со Студентом
 */
@Service
public class StudentServiceImpl implements StudentService {

//    @Autowired
//    private StudentDAO studentDAO;

    @Autowired
    private StudentRepository studentRepository;

    private MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    /**
     *  Получение списка студентов
     * @return
     * @throws SQLException
     */
    @Override
    public List<StudentModel> getStudentList() throws SQLException {
        List<StudentModel> studentModels = new ArrayList<>();
        mapperFacade.mapAsCollection(studentRepository.findAll(), studentModels, StudentModel.class);
        return studentModels;
    }

    /**
     * Поиск студента по имени
     * @param firstName
     * @return
     * @throws SQLException
     */
    @Override
    public StudentModel getStudentByName(String firstName) throws SQLException {
        Student student = studentRepository.findStudentByFirstName(firstName);
        return mapperFacade.map(student, StudentModel.class);
    }

    /**
     * Удаление студентов по id
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteStudent(Integer id) throws SQLException {
        studentRepository.delete(id);
    }

    /**
     * Добавление студентов
     * @param student
     * @throws SQLException
     */
    @Override
    public void addStudent(StudentModel student) throws SQLException {
        studentRepository.save(mapperFacade.map(student, Student.class));
    }

    @Override
    public void updateStudent(StudentModel student) throws SQLException {
        //studentRepository.updateStudentById(student);
    }

    @Override
    public List<StudentModel> getSortedStudentListByColumn(String column) throws SQLException {
        List<StudentModel> studentList = getStudentList();
        switch (column){
            case "id":
                Collections.sort(studentList, (o1, o2) -> o1.getId().compareTo(o2.getId()));
                break;
            case "firstName":
                Collections.sort(studentList, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
                break;
            case "lastName":
                Collections.sort(studentList, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
                break;
            case "sex":
                Collections.sort(studentList, (o1, o2) -> o1.getSex().compareTo(o2.getSex()));
                break;
            case "bornDate":
                Collections.sort(studentList, (o1, o2) -> o1.getBornDate().compareTo(o2.getBornDate()));
                break;
        }
        return studentList;
    }
}
