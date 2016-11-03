package ru.innopois.university.ramis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopois.university.ramis.dao.UserDAO;
import ru.innopois.university.ramis.model.Users;
import ru.innopois.university.ramis.service.UserService;

import java.sql.SQLException;

/**
 * Created by innopolis on 02.11.16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public Users loadUserByUsername(String login) throws SQLException {
        return userDAO.loadUserByUsername(login);
    }
}
