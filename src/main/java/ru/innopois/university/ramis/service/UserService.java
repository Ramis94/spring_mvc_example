package ru.innopois.university.ramis.service;

import ru.innopois.university.ramis.model.Users;

import java.sql.SQLException;

/**
 * Created by innopolis on 02.11.16.
 */
public interface UserService {

    Users loadUserByUsername(String login) throws SQLException;
}
