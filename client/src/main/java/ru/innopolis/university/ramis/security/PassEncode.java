package ru.innopolis.university.ramis.security;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

public class PassEncode implements PasswordEncoder {

    PasswordEncoder passwordEncoder = new StandardPasswordEncoder("3A$&j"); // use SHA-256, 3A$&j - salt

    @Override
    public String encode(CharSequence charSequence) {
        return passwordEncoder.encode(charSequence);
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return passwordEncoder.matches(charSequence, s);
    }
}

