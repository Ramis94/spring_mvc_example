package ru.innopolis.university.ramis.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.innopolis.university.ramis.model.UsersModel;
import ru.innopolis.university.ramis.service.UserService;

import java.sql.SQLException;

@Component
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UsersModel userInfo = null;
        try {
            userInfo = userService.loadUserByUsername(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (userInfo == null) throw new UsernameNotFoundException("User with name " + s + " not found");
        return new User(userInfo);
    }
}
