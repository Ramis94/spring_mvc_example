package ru.innopois.university.ramis.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.innopois.university.ramis.model.Users;

import java.util.ArrayList;
import java.util.Collection;

public class User implements UserDetails {

    private final Users userInfo;

    public User(Users userInfo) {
        this.userInfo = userInfo;
    }

    public Users getUserInfo() {
        return userInfo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userInfo.getRole()));
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return userInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfo.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
