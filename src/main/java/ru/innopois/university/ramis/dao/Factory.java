package ru.innopois.university.ramis.dao;

import ru.innopois.university.ramis.dao.impl.UserDAOImpl;

/**
 * Created by innopolis on 31.10.16.
 */
public class Factory {

    private static Factory instance = new Factory();
    private static UserDAO userDAO = new UserDAOImpl();

    public static Factory getInstance(){
        return instance;
    }

    public UserDAO getUserDAO(){
        return userDAO;
    }
}
