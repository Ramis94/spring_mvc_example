package ru.innopolis.university.ramis.service;

import ru.innopolis.university.ramis.model.UsersModel;

import java.sql.SQLException;

/**
 * Created by innopolis on 02.11.16.
 */
public interface UserService {

    UsersModel loadUserByUsername(String login) throws SQLException;
}
