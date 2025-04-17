package com.subh.SecurityCheck.service;

import com.subh.SecurityCheck.Entity.User;
import org.springframework.stereotype.Service;

@Service
public interface Userservices {
    public User addUser(User user);
    public String verify(User user);
}
