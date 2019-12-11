package com.samin005.restwebservice.jwt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.samin005.restwebservice.jwt.model.JwtUserDetails;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    private static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

    static {
        inMemoryUserList.add(new JwtUserDetails(1L, "Samin",
                "$2y$12$XPLutle8hOLK.KvDv2rHZOB0VQGyQOyAU084g1V/2XFVKbGyFlAY6", "ROLE_USER_2"));
        inMemoryUserList.add(new JwtUserDetails(2L, "Azhan",
                "$2y$12$XPLutle8hOLK.KvDv2rHZOB0VQGyQOyAU084g1V/2XFVKbGyFlAY6", "ROLE_USER_2"));

        //$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
                .filter(user -> user.getUsername().equals(username)).findFirst();

        if (!findFirst.isPresent()) {
            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
        }

        return findFirst.get();
    }

}