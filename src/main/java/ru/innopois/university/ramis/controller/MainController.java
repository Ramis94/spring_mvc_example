package ru.innopois.university.ramis.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.innopois.university.ramis.dao.impl.AbstractRepository;

import java.sql.SQLException;

/**
 * Created by innopolis on 31.10.16.
 */
@Controller
public class MainController {

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
     * Загрузка главной страницы
     * @return
     */
    @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(){
        return "index";
    }
}
