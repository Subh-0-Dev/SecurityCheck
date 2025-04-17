package com.subh.SecurityCheck.controller;

import com.subh.SecurityCheck.Entity.User;
import com.subh.SecurityCheck.service.Userservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired
	Userservices userservices;

	@GetMapping("/what")
	public String hellopage() {
		return "Hello From What Controller";
	}


	@PostMapping("/request")
	public User maybepage(@RequestBody User user) {

		return userservices.addUser(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody User user){
		return userservices.verify(user);
	}


}
