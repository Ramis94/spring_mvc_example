package ru.innopolis.university.ramis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.innopolis.university.ramis.model.StudentModel;
import ru.innopolis.university.ramis.service.StudentService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by innopolis on 31.10.16.
 * Работа со студентами
 */
@Controller
@RequestMapping(value = "/student")
public class StudentController {

    private String redirect = "redirect:/student/list";

    @Autowired
    StudentService studentService;

    /**
     * Вывод всех студентов
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/list")
    public ModelAndView getAllStudents() throws SQLException {
        List<StudentModel> studentList = studentService.getStudentList();

        ModelAndView modelAndView = new ModelAndView("listStudent");
        modelAndView.addObject("list", studentList);

        return modelAndView;
    }

    /**
     * Получение студента по имени
     * @param firstName
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/{firstName}")
    public ModelAndView getStudentByName(@PathVariable String firstName) throws SQLException {
        ModelAndView modelAndView = new ModelAndView("getStudent");
        StudentModel student = studentService.getStudentByName(firstName);
        modelAndView.addObject("student", student);
        return modelAndView;
    }

    /**
     * Поиск студента по имени
     * @param firstName
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/search={firstName}")
    @ResponseBody
    public StudentModel searchStudentByName(@PathVariable String firstName) throws SQLException {
        StudentModel student = studentService.getStudentByName(firstName);
        return student;
    }

    /**
     * Удаление студента по id
     * @param id
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/del={id}")
    public String delStudentById(@PathVariable Integer id) throws SQLException {
        studentService.deleteStudent(id);
        return redirect;
    }

    /**
     * Добавление студента
     * @param student
     * @param bindingResult
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("studentForm") @Validated StudentModel student, BindingResult bindingResult) throws SQLException {
        studentService.addStudent(student);
        return redirect;
    }

    /**
     * Сортировка таблицы по колонкам
     * @param column
     * @return
     * @throws SQLException
     */
    @RequestMapping(value = "/sort={column}", method = RequestMethod.GET)
    public ModelAndView getSortByColumn(@PathVariable String column) throws SQLException {
        List<StudentModel> studentList = studentService.getSortedStudentListByColumn(column);
        ModelAndView modelAndView = new ModelAndView("listStudent");
        modelAndView.addObject("list", studentList);
        return modelAndView;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("studentForm") @Validated StudentModel student, BindingResult bindingResult) throws SQLException {
        studentService.updateStudent(student);
        return "redirect:/student/" + student.getFirstName();
    }

}
