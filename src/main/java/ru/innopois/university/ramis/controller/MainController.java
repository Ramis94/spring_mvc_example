package ru.innopois.university.ramis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by innopolis on 31.10.16.
 */
@Controller
public class MainController {

    /**
     * Загрузка главной страницы
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(){
        return "index";
    }
}
