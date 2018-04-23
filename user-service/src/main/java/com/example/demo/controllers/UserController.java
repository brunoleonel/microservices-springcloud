package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;

@RestController
public class UserController {

	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable String id) {
		
		User user = new User();
		user.setId(id);
		user.setEmail("jurandir@gmail.com");
		user.setName("Jurandir");
		return user;
	}
}
