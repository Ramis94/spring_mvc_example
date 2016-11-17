package ru.innopolis.university.ramis.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.university.ramis.model.UsersModel;
import ru.innopolis.university.ramis.service.UserService;

import java.sql.SQLException;

/**
 * Created by innopolis on 15.11.16.
 */
@Service
public class UserServiceImplDecorator implements UserService {

    private Logger logger = LoggerFactory.getLogger(UserServiceImplDecorator.class);

    @Autowired
    private UserService userService;

    @Override
    public UsersModel loadUserByUsername(String s) throws SQLException {
        logger.info("User {} is auth", s);
        return userService.loadUserByUsername(s);
    }
}
