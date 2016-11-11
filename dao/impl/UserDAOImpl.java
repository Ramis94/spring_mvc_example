package ru.innopois.university.ramis.dao.impl;

import org.springframework.stereotype.Repository;
import ru.innopois.university.ramis.dao.UserDAO;
import ru.innopois.university.ramis.model.Users;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.SQLException;

/**
 * Created by innopolis on 02.11.16.
 */
@Repository
public class UserDAOImpl extends AbstractRepository implements UserDAO {

    @Override
    public Users loadUserByUsername(String login) throws SQLException {
        //String sql = "SELECT u FROM users as u WHERE u.login = ?";
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Users> criteria = builder.createQuery(Users.class);
        Root<Users> from = criteria.from(Users.class);
        criteria.select(from);
        criteria.where(builder.equal(from.get("login"), login));
        TypedQuery<Users> typed = entityManager.createQuery(criteria);
        Users user = typed.getSingleResult();
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
