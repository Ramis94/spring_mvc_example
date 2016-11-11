package ru.innopolis.university.ramis.controller;

import org.springframework.security.access.annotation.Secured;
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
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(){
        return "index";
    }
}
