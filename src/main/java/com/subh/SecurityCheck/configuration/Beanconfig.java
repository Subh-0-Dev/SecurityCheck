package com.subh.SecurityCheck.configuration;

import com.subh.SecurityCheck.service.Userservices;
import com.subh.SecurityCheck.serviceimpl.UserserviceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beanconfig {
    @Bean
    public Userservices getuser(){
        return new UserserviceImpl();
    }
}
