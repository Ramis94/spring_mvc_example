package ru.innopois.university.ramis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopois.university.ramis.dao.LectureDAO;
import ru.innopois.university.ramis.dao.StudentDAO;
import ru.innopois.university.ramis.dao.StudentLectureDAO;
import ru.innopois.university.ramis.model.Student;
import ru.innopois.university.ramis.model.StudentLecture;
import ru.innopois.university.ramis.model.common.StudentLectureVisit;
import ru.innopois.university.ramis.service.StudentLectureService;

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
    StudentLectureDAO studentLectureDAO;

    @Autowired
    StudentDAO studentDAO;

    @Autowired
    LectureDAO lectureDAO;

    @Override
    public void addStudentLecture(List<Integer> id_user, Integer id_lesson) throws SQLException {
        studentLectureDAO.addStudentLecture(id_user, id_lesson);
    }

    @Override
    public List<StudentLecture> getListStudentLectures() throws SQLException {
        return studentLectureDAO.getListStudentLectures();
    }

    @Override
    public List<StudentLectureVisit> getVisit() throws SQLException {
        List<Student> students = studentDAO.getStudentList();
        List<StudentLecture> studentLectures = studentLectureDAO.getListStudentLectures();
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
        return studentLectureVisits;
    }
}
