package ru.innopolis.university.ramis.service.impl;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.university.ramis.entity.Student;
import ru.innopolis.university.ramis.entity.StudentLecture;
import ru.innopolis.university.ramis.entity.common.StudentLectureVisit;
import ru.innopolis.university.ramis.model.StudentLectureModel;
import ru.innopolis.university.ramis.model.common.StudentLectureVisitModel;
import ru.innopolis.university.ramis.repository.StudentLectureRepository;
import ru.innopolis.university.ramis.repository.StudentRepository;
import ru.innopolis.university.ramis.service.StudentLectureService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
@Service
public class StudentLectureServiceImpl implements StudentLectureService {

    @Autowired
    StudentLectureRepository studentLectureRepository;

    @Autowired
    StudentRepository studentRepository;

    private MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    @Override
    public void addStudentLecture(List<Integer> id_user, Integer id_lesson) throws SQLException {
        //studentLectureDAO.addStudentLecture(id_user, id_lesson);
    }

    @Override
    public List<StudentLectureModel> getListStudentLectures() throws SQLException {
        List<StudentLectureModel> studentLectureModels = new ArrayList<>();
        mapperFacade.mapAsCollection(studentRepository.findAll(), studentLectureModels, StudentLectureModel.class);
        return studentLectureModels;
    }

    @Override
    public List<StudentLectureVisitModel> getVisit() throws SQLException {
        List<Student> students = studentRepository.findAll();
        List<StudentLecture> studentLectures = studentLectureRepository.findAll();
        Collections.sort(studentLectures, (o1, o2) -> o1.getStudent_id().getId().compareTo(o2.getStudent_id().getId()));
        List<StudentLectureVisit> studentLectureVisits = new ArrayList<>();
        for (Student student: students) {
            Integer visit = 0;
            for (StudentLecture studentLecture: studentLectures) {
                if (student.equals(studentLecture.getStudent_id())){
                    visit++;
                }
            }
            StudentLectureVisit studentLectureVisit = new StudentLectureVisit();
            studentLectureVisit.setStudent(student);
            studentLectureVisit.setVisit(visit);
            studentLectureVisits.add(studentLectureVisit);
        }
        List<StudentLectureVisitModel> studentLectureModels = new ArrayList<>();
        mapperFacade.mapAsCollection(studentLectures, studentLectureModels, StudentLectureVisitModel.class);
        return studentLectureModels ;
    }
}
