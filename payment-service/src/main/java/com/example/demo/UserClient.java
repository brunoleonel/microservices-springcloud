package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.models.User;

@FeignClient(name = "user-service")
public interface UserClient {

	@RequestMapping(method = RequestMethod.GET, value = "/user/{id}")
	User getUser(@PathVariable("id") int id);
}
