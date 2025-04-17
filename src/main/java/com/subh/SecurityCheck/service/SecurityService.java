package com.subh.SecurityCheck.service;

import com.subh.SecurityCheck.Entity.User;
import com.subh.SecurityCheck.Repository.UserRepository;
import com.subh.SecurityCheck.serviceimpl.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Component
public class SecurityService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if(Objects.isNull(user)){
            throw new UsernameNotFoundException("User Doesn't Exist");
        }
        return new CustomUserDetails(user);
    }
}
