package ru.innopolis.university.ramis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.university.ramis.model.LectureModel;
import ru.innopolis.university.ramis.model.StudentModel;
import ru.innopolis.university.ramis.model.common.StudentLectureVisitModel;
import ru.innopolis.university.ramis.service.LectureService;
import ru.innopolis.university.ramis.service.StudentLectureService;
import ru.innopolis.university.ramis.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
@Controller
@RequestMapping(value = "/lecture")
public class LectureController {

    @Autowired
    StudentService studentService;

    @Autowired
    LectureService lectureService;

    @Autowired
    StudentLectureService studentLectureService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllLecture() throws SQLException {
        List<LectureModel> lectureList = lectureService.getAllLecture();
        ModelAndView modelAndView = new ModelAndView("listLecture");
        modelAndView.addObject("list", lectureList);
        return modelAndView;
    }

    /**
     * получение посещаемости
     * @return
     */
    @RequestMapping(value = "/visit", method = RequestMethod.GET)
    public ModelAndView getOmissions() throws SQLException {
        List<StudentLectureVisitModel> getVisit = studentLectureService.getVisit();
        ModelAndView modelAndView = new ModelAndView("getVisit");
        modelAndView.addObject("listVisit", getVisit);
        return modelAndView;
    }

    @RequestMapping(value = "/visit/add={lecture_id}", method = RequestMethod.GET)
    public ModelAndView addVisitLecture() throws SQLException {
        List<StudentModel> studentList = studentService.getStudentList();
        ModelAndView modelAndView = new ModelAndView("addVisit");
        modelAndView.addObject("listStudent", studentList);
        return modelAndView;
    }
}