package ru.innopolis.university.ramis.model;

import java.io.Serializable;

/**
 * Created by innopolis on 02.11.16.
 */
public class UsersModel extends AbstractEntityModel implements Serializable {

    private Integer id;

    private String login;

    private String password;

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
