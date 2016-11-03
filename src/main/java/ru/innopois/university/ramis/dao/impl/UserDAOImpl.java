package ru.innopois.university.ramis.dao.impl;

import com.sun.jna.platform.win32.Netapi32Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.innopois.university.ramis.dao.UserDAO;
import ru.innopois.university.ramis.model.Users;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by innopolis on 02.11.16.
 */
@Repository
public class UserDAOImpl extends AbstractRepository implements UserDAO {

    JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Users loadUserByUsername(String login) throws SQLException {
        String sql = "SELECT u.id, u.login, u.password, r.role FROM users as u JOIN user_roles as r ON u.login=r.login WHERE u.login = ?";
        Users user = jdbcTemplate.queryForObject(sql, new Object[]{username}, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                Users user = new Users();
                user.setId(resultSet.getInt("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                return user;
            }
        });

/*        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, login);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            user.setId(resultSet.getInt("id"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
        }*/
        return user;
    }
}
