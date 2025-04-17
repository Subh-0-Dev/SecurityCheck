package com.subh.SecurityCheck.serviceimpl;

import com.subh.SecurityCheck.Entity.User;
import com.subh.SecurityCheck.Repository.UserRepository;
import com.subh.SecurityCheck.service.JWTService;
import com.subh.SecurityCheck.service.Userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserserviceImpl implements Userservices {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService jwtService;

    @Override
    public User addUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String verify(User user) {
        Authentication authenticate = authenticationManager
                .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                user.getUsername(),
                                user.getPassword())
                );
        if(authenticate.isAuthenticated()){
            return jwtService.generateToken(user);
        }
        return "Failure";
    }
}
