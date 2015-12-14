package com.cheny.web.security;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Collection<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();

        SimpleGrantedAuthority auth2 = new SimpleGrantedAuthority("ROLE_ADMIN");
        SimpleGrantedAuthority auth1 = new SimpleGrantedAuthority("ROLE_USER");

        if (username.equals("lcy")) {
            auths.add(auth1);
            auths.add(auth2);
        }

        User user = new User(username, "lcy", true, true, true, true, auths);
        return user;
    }
}
