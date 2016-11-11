package ru.innopois.university.ramis.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by innopolis on 31.10.16.
 */
public abstract class AbstractRepository {

    static Connection connection;

    /**
     * Получение соединения с БД
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws SQLException
     */
    public static void getConnection() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
    }

    EntityManager entityManager = Persistence.createEntityManagerFactory("STUDENT").createEntityManager();

}
