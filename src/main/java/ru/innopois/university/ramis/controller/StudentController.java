package ru.innopois.university.ramis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.innopois.university.ramis.model.Student;
import ru.innopois.university.ramis.service.StudentService;

import java.sql.SQLException;
import java.util.Collections;
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
        List<Student> studentList = studentService.getStudentList();

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
        Student student = studentService.getStudentByName(firstName);
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
    public Student searchStudentByName(@PathVariable String firstName) throws SQLException {
        Student student = studentService.getStudentByName(firstName);
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
    public String addStudent(@ModelAttribute("studentForm") @Validated Student student, BindingResult bindingResult) throws SQLException {
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
        List<Student> studentList = studentService.getStudentList();
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
        ModelAndView modelAndView = new ModelAndView("listStudent");
        modelAndView.addObject("list", studentList);
        return modelAndView;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String updateStudent(@ModelAttribute("updateStudentForm") @Validated Student student, BindingResult bindingResult) throws SQLException {
        studentService.updateStudent(student);
        return "redirect:/student" + student.getFirstName();
    }

}
