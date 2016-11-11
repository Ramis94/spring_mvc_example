package ru.innopolis.university.ramis.service.impl;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.university.ramis.entity.Users;
import ru.innopolis.university.ramis.model.UsersModel;
import ru.innopolis.university.ramis.repository.UserRepository;
import ru.innopolis.university.ramis.service.UserService;

import java.sql.SQLException;

/**
 * Created by innopolis on 02.11.16.
 */
@Service
public class UserServiceImpl implements UserService {

    private MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    @Autowired
    UserRepository userRepository;

    @Override
    public UsersModel loadUserByUsername(String login) throws SQLException {
        Users users = userRepository.findByLogin(login);
        return mapperFacade.map(users, UsersModel.class);
    }
}
